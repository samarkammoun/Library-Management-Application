package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InterfaceIdentifierUtilisateur extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceIdentifierUtilisateur frame = new InterfaceIdentifierUtilisateur();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public InterfaceIdentifierUtilisateur() {
		setTitle("IdentifierUtilisateur");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 478, 440);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("S'authentifier");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(147, 41, 285, 45);
		contentPane.add(lblNewLabel);
		
		JButton utilisateurbtn = new JButton("Utilisateur");
		utilisateurbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				InterfaceIdentifierClient ic = new InterfaceIdentifierClient();
				ic.show();
				
			}
		});
		utilisateurbtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		utilisateurbtn.setBounds(142, 241, 154, 45);
		contentPane.add(utilisateurbtn);
		
		JButton adminbtn = new JButton("Administrateur");
		adminbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				InterfaceIdentifierAdmin IdAdmin = new InterfaceIdentifierAdmin();
				IdAdmin.show();
				
			}
		});
		adminbtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		adminbtn.setBounds(142, 146, 154, 45);
		contentPane.add(adminbtn);
	}
}












