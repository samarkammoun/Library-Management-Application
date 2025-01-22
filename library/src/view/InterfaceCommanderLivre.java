

package view;

import dao.Test;

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
import model.Client;
public class InterfaceCommanderLivre extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField isbn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceCommanderLivre frame = new InterfaceCommanderLivre();
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
	public InterfaceCommanderLivre() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Commander un livre");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setBounds(116, 23, 256, 47);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Donner l'isbn du livre:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(39, 93, 215, 27);
		contentPane.add(lblNewLabel_1);
		
		isbn = new JTextField();
		isbn.setBounds(208, 98, 146, 19);
		contentPane.add(isbn);
		isbn.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(100, 202, 22, 0);
		contentPane.add(lblNewLabel_2);
		
		final JLabel resultat = new JLabel("");
		resultat.setBounds(100, 153, 229, 39);
		contentPane.add(resultat);
		
		JButton btnNewButton = new JButton("Commander");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con = Test.connection("jdbc:mysql://localhost:3306/tp3", "root", "samar2709");
				Client client = new Client ();
				String result = (String) client.commanderLivre(con,isbn.getText());
				resultat.setText(result);
				
				
			}
		});
		btnNewButton.setBounds(49, 214, 125, 27);
		contentPane.add(btnNewButton);
		
		JButton btnRetour = new JButton("retour");
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				InterfaceOptionsClient oc = new InterfaceOptionsClient();
				oc.show();
			}
		});
		btnRetour.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnRetour.setBounds(247, 214, 125, 27);
		contentPane.add(btnRetour);
	}

}
