package prj.nat.sres.customer.machine;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;

public class VirtualCashModule extends JDialog {
	
	static final long serialVersionUID = 1L;
	
	private JTextField cashField;
	private JTextField fldInsertedCash;
	private int insertedCash;
	private boolean isPurchaseSuccess = false;

	/**
	 * Launch the application.
	 */
	//	public static void main(String[] args) {
	//		EventQueue.invokeLater(new Runnable() {
	//			public void run() {
	//				try {
	//					VirtualCashModule dialog = new VirtualCashModule();
	//					
	//				} catch (Exception e) {
	//					e.printStackTrace();
	//				}
	//			}
	//		});
	//	}


	/**
	 * Create the dialog.
	 */
	public VirtualCashModule(int cashSum) {
		setModal(true);
		setTitle("가상 현금결제 시뮬레이터");
		setSize(320, 409);
		setLocationRelativeTo(getParent());
		getContentPane().setLayout(null);

		JButton button = new JButton("10000");
		button.setFont(new Font("굴림", Font.BOLD, 16));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fldInsertedCash.setText(String.valueOf(insertedCash += 10000));
			}
		});
		button.setBounds(12, 104, 164, 56);
		getContentPane().add(button);

		JButton button_1 = new JButton("5000");
		button_1.setFont(new Font("굴림", Font.BOLD, 16));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fldInsertedCash.setText(String.valueOf(insertedCash += 5000));
			}
		});
		button_1.setBounds(12, 166, 164, 56);
		getContentPane().add(button_1);

		JButton button_2 = new JButton("1000");
		button_2.setFont(new Font("굴림", Font.BOLD, 16));
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fldInsertedCash.setText(String.valueOf(insertedCash += 1000));
			}
		});
		button_2.setBounds(12, 229, 164, 56);
		getContentPane().add(button_2);

		JButton button_3 = new JButton("500");
		button_3.setFont(new Font("굴림", Font.BOLD, 16));
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fldInsertedCash.setText(String.valueOf(insertedCash += 500));
			}
		});
		button_3.setBounds(12, 294, 73, 56);
		getContentPane().add(button_3);

		JButton button_4 = new JButton("100");
		button_4.setFont(new Font("굴림", Font.BOLD, 16));
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fldInsertedCash.setText(String.valueOf(insertedCash += 100));
			}
		});
		button_4.setBounds(103, 295, 73, 56);
		getContentPane().add(button_4);

		cashField = new JTextField();
		cashField.setBackground(new Color(175, 238, 238));
		cashField.setEditable(false);
		cashField.setText(String.valueOf(cashSum));
		cashField.setBounds(95, 10, 154, 31);
		getContentPane().add(cashField);
		cashField.setColumns(10);

		fldInsertedCash = new JTextField();
		fldInsertedCash.setBackground(new Color(173, 216, 230));
		fldInsertedCash.setEditable(false);
		fldInsertedCash.setColumns(10);
		fldInsertedCash.setBounds(95, 51, 154, 31);
		getContentPane().add(fldInsertedCash);

		JLabel label = new JLabel("결제할 금액");
		label.setBounds(12, 18, 73, 15);
		getContentPane().add(label);

		JLabel label_1 = new JLabel("투입한 금액");
		label_1.setBounds(12, 59, 73, 15);
		getContentPane().add(label_1);

		JButton btnPurchase = new JButton("결제");

		btnPurchase.setBounds(188, 288, 97, 36);
		getContentPane().add(btnPurchase);

		JButton button_6 = new JButton("취소");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setPurchaseSuccess(false);
				dispose();
			}
		});
		button_6.setBounds(188, 329, 97, 36);
		getContentPane().add(button_6);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("kiosk_mini.jpg"));
		lblNewLabel.setBounds(188, 105, 100, 177);
		getContentPane().add(lblNewLabel);

		// 결제 버튼
		btnPurchase.addActionListener(ev -> {
			if(cashSum == Integer.parseInt(fldInsertedCash.getText())) {
				System.out.println("결제 성공: [상황1] 식권 발매");
				JOptionPane.showMessageDialog(null, "결제 성공: [상황1] 식권 발매");
				setPurchaseSuccess(true);
				dispose();
			} else if (cashSum < Integer.parseInt(fldInsertedCash.getText())){
				JOptionPane.showMessageDialog(null, "[상황2] 초과 지급, 거스름돈 지급");
				setPurchaseSuccess(true);
				int change = keepTheChange(Integer.parseInt(fldInsertedCash.getText()), cashSum);
				JOptionPane.showMessageDialog(null, "옛다 거스름돈: " + change);
				payMonetary(change);
				dispose();
			} else {
				JOptionPane.showMessageDialog(null, "잔액이 부족합니다.");
			}
		});


		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setVisible(true);
		setType(Type.UTILITY);


	}

	public boolean isPurchaseSuccess() {
		return isPurchaseSuccess;
	}

	public void setPurchaseSuccess(boolean isPurchaseSuccess) {
		this.isPurchaseSuccess = isPurchaseSuccess;
	}

	public int keepTheChange(int insertedCash, int cashSum) {
		return insertedCash - cashSum;
	}

	// 거스름돈을 화폐별로 지급합니다. (1000원 ~ 100원)
	public void payMonetary(int change) {
		int[] p = new int[3];
		int[] t = new int[3];
		int res = change;
		int m = 1000;
		int sw = 1;

		for(int k = 0; k < p.length; k++) {
			p[k] = res / m;
			t[k] += p[k];
			res = res - (p[k] * m);
			if(sw == 1) {
				m = m / 2;
				sw = 0;
			} else {
				m = m / 5;
				sw = 1;
			}


		}

		// 거스름돈 지급 상황 재현
		System.out.print("거스름돈(1000, 500, 100):\t");
		for(int i = 0; i < p.length; i++) {
			System.out.print(p[i] + "\t");
		}
		System.out.println();
	}


	//	public VirtualCashModule() {
	//		
	//		
	//		this(10000);
	//	}
}
