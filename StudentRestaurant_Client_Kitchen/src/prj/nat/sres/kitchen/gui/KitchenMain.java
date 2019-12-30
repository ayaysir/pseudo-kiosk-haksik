package prj.nat.sres.kitchen.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import prj.nat.sres.dto.Menu;
import prj.nat.sres.kitchen.net.ConnectionManager;

public class KitchenMain extends JFrame {
	
	static final long serialVersionUID = 1L;
	
	ConnectionManager cm = new ConnectionManager();

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KitchenMain frame = new KitchenMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws Exception 
	 */
	public KitchenMain() throws Exception {
		
		final Dimension dm1 = new Dimension(180, 30);
		final Font ft1 = new Font("맑은 고딕", Font.BOLD, 20);
		final Font ft2 = new Font("맑은 고딕", Font.PLAIN, 16);
		
		setTitle("주방 관리 프로그램");
		
		List<Menu> list = cm.getMenuList();
		
		// 카테고리 목록 생성
		List<String> category = new ArrayList<>();
		for(int i = 0; i < list.size(); i++) {
			if(i == 0) {
				category.add(list.get(i).getCategory());
			} else if (list.get(i).getCategory().equals(list.get(i-1).getCategory())) {
				continue;
			} else {
				category.add(list.get(i).getCategory());
			}
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(780, 100));
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("파트 선택");
		lblNewLabel.setPreferredSize(new Dimension(100, 50));
		lblNewLabel.setFont(ft1);
		panel.add(lblNewLabel);
		
		JComboBox<String> comboBox = new JComboBox<>();
		comboBox.setPreferredSize(new Dimension(140, 30));
		comboBox.setFont(ft1);
		for(String t: category) {
			comboBox.addItem(t);
		}
		panel.add(comboBox);
		
		JLabel lblCurrentTime = new JLabel("");
		lblCurrentTime.setFont(ft2);
		panel.add(lblCurrentTime);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.SOUTH);
		String help = "<html>위의 [파트 선택]에서 해당 컴퓨터가 위치한 파트를 선택해주세요. 판매상황에 따라 수량이 초마다 갱신됩니다.<br>"+
		"주방 상황으로 인해 재고의 변동이 필요한 경우 [-], [+]을 클릭하시면 재고가 1개씩 변경됩니다. <br>예기치 못한 상황으로 메뉴 판매가 불가능해진 경우"+
				"[판매취소요청]을 클릭해주세요.</html>";
		JLabel lblNewLabel_1 = new JLabel(help);
		lblNewLabel_1.setPreferredSize(new Dimension(750, 50));
		panel_2.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(new GridLayout(5, 0, 10, 10));
		
		
		
		new Thread( () -> {
			while(true) {
				
				// =====================================================
				try {
					List<Menu> checkList = cm.getMenuList();
					panel_1.removeAll();
					
					String selected = comboBox.getSelectedItem().toString();
					// System.out.println("@"+selected);
					
					
					int ix = 0;
					for(Menu t : checkList) {
						if(selected.equals(t.getCategory())) {
							
							final int IX = ix;
			
							JPanel linePanel = new JPanel();
							linePanel.setLayout(new GridBagLayout());
							JLabel menuName = new JLabel(t.getMenuName());
							menuName.setPreferredSize(dm1);
							menuName.setFont(ft1);
							
							JLabel quantity = null;
							if(t.getQuantity() <= 10) {
								quantity = new JLabel(" 남은 수량: " + t.getQuantity());	
								quantity.setForeground(new Color(131, 11, 31));
							} else {
								quantity = new JLabel(" 남은 수량: " + t.getQuantity() + "  ");	
							}
								
							quantity.setPreferredSize(dm1);
							quantity.setFont(ft1);
							
							
							linePanel.add(menuName);
							linePanel.add(quantity);
							
							JButton jbMinus = new JButton("-");
							JButton jbPlus = new JButton("+");
							JButton jbCancel = new JButton("판매취소요청");
							
							jbMinus.setFont(ft1);
							jbMinus.addActionListener(ev->{
								t.setQuantity(t.getQuantity()-1);
								list.set(IX, t);
								try {
									cm.setMenuList(list);
								} catch (Exception e) {
									e.printStackTrace();
								}
							});
							jbPlus.setFont(ft1);
							jbPlus.addActionListener(ev->{
								t.setQuantity(t.getQuantity()+1);
								list.set(IX, t);
								try {
									cm.setMenuList(list);
								} catch (Exception e) {
									e.printStackTrace();
								}
							});
							jbCancel.setFont(ft1);
							jbCancel.addActionListener(ev->{
								JOptionPane.showMessageDialog(null, "기능 준비중(주방에서 재고상황을 판단하여 전체 주문 가능량을 취소하는 시스템입니다.)");
							});
							
							linePanel.add(jbMinus);
							linePanel.add(jbPlus);		
							linePanel.add(jbCancel);
							linePanel.setBackground(new Color(211, 211, 211));
							
							panel_1.add(linePanel);						
							
						}
						ix++;
					}
									
					panel_1.revalidate();
					panel_1.repaint();
					contentPane.revalidate();
					contentPane.repaint();
					
					contentPane.add(panel_1, BorderLayout.CENTER);
					setFocusable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
				// =====================================================
				
				
				// 스레드 슬립
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
		
		// 현재 시간 설정
		new Thread(()->{
			
			while(true) {				
				long time = System.currentTimeMillis(); 
				SimpleDateFormat dayTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String timeStr = dayTime.format(new Date(time));
				lblCurrentTime.setText("현재 시각: " + timeStr);
				lblCurrentTime.revalidate();
				lblCurrentTime.repaint();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}	
			
			
		}).start();
		
		
	}

}
