package view;

import java.awt.EventQueue;
import dao.Test;
import model.Client;

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

public class InterfaceIdentifierClient extends JFrame {

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
					InterfaceIdentifierClient frame = new InterfaceIdentifierClient();
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
	public InterfaceIdentifierClient() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Espace Client");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setBounds(145, 32, 189, 21);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Login :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(50, 74, 166, 21);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Mot de passe:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(50, 116, 166, 21);
		contentPane.add(lblNewLabel_1_1);
		
		login = new JTextField();
		login.setBounds(192, 75, 189, 21);
		contentPane.add(login);
		login.setColumns(10);
		
		pwd = new JTextField();
		pwd.setColumns(10);
		pwd.setBounds(192, 118, 189, 21);
		contentPane.add(pwd);
		
		final JLabel erreur = new JLabel("");
		erreur.setBounds(110, 165, 210, 33);
		contentPane.add(erreur);
		
		JButton btnNewButton = new JButton("Envoyer");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con = Test.connection("jdbc:mysql://localhost:3306/tp3", "root", "samar2709");
			    String log = login.getText();
			    String pass = pwd.getText();
			    Client client = new Client(pass, log);
			    boolean accepted = client.verifierClient(con, log, pass);
			    if (accepted==true && log!=null && pwd!=null) {
			        dispose();
			        InterfaceOptionsClient optClient = new InterfaceOptionsClient();
			        optClient.setVisible(true);
			    } else {
			        login.setText("");
			        pwd.setText("");
			        erreur.setText("Veuillez vérifier vos données !");
			    }
			}
			
			
		});
		btnNewButton.setBounds(50, 208, 98, 33);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("retour");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				InterfaceIdentifierClient ui = new InterfaceIdentifierClient();
				ui.show();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.setBounds(283, 208, 98, 33);
		contentPane.add(btnNewButton_1);
	}

}







