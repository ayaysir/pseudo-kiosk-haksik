package prj.nat.sres.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FileDialog;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import prj.nat.sres.core.EntryMenu;
import prj.nat.sres.server.OpenServer;

public class ServerMain_Quick extends JFrame {
	
	static final long serialVersionUID = 1L;

	private JPanel contentPane;

	EntryMenu em = new EntryMenu();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ServerMain_Quick frame = new ServerMain_Quick();
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
	public ServerMain_Quick() throws Exception {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		FileDialog fd = new FileDialog(this, "파일 불러오기", FileDialog.LOAD);
		fd.setVisible(true);
		JOptionPane.showMessageDialog(this, fd.getDirectory()+fd.getFile(), 
				"File", JOptionPane.INFORMATION_MESSAGE);
		em.entryCSV(fd.getDirectory()+fd.getFile());
		new OpenServer(em.getMenuList());
		


	}

}
