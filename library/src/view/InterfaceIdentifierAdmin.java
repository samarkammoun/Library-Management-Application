package view;

import dao.Test;
import model.Administrateur;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;

public class InterfaceIdentifierAdmin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField login;
	private JTextField pwd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceIdentifierAdmin frame = new InterfaceIdentifierAdmin();
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
	public InterfaceIdentifierAdmin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Espace Administrateur");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setBounds(115, 27, 215, 41);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Login:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(43, 70, 180, 53);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Mot de passe:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(43, 118, 180, 53);
		contentPane.add(lblNewLabel_1_1);
		
		login = new JTextField();
		login.setBounds(177, 89, 199, 19);
		contentPane.add(login);
		login.setColumns(10);
		
		pwd = new JTextField();
		pwd.setColumns(10);
		pwd.setBounds(177, 133, 199, 19);
		contentPane.add(pwd);
		
		JButton btnNewButton = new JButton("Envoyer");
		final JLabel erreurD = new JLabel("");
		erreurD.setBounds(101, 181, 215, 25);
		contentPane.add(erreurD);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con = Test.connection("jdbc:mysql://localhost:3306/tp3", "root", "samar2709");
			    String log = login.getText();
			    String pass = pwd.getText();
			    Administrateur admin = new Administrateur(pass, log);
			    boolean accepted = admin.verifierAdmin(con, log, pass);
			    if (accepted==true && log!=null && pwd!=null) {
			        dispose();
			        InterfaceOptionsAdmin optAdmin = new InterfaceOptionsAdmin();
			        optAdmin.setVisible(true);
			    } else {
			        login.setText("");
			        pwd.setText("");
			        erreurD.setText("Veuillez vérifier vos données !");
			    }
			}
		});
		
	
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(43, 216, 111, 37);
		contentPane.add(btnNewButton);
		
		JButton btnRetour = new JButton("Retour");
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				InterfaceIdentifierAdmin ui = new InterfaceIdentifierAdmin();
				ui.show();
			}
		});
		btnRetour.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnRetour.setBounds(259, 216, 111, 37);
		contentPane.add(btnRetour);
		
		
	}

}
