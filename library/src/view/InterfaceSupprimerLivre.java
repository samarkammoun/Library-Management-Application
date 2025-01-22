package view;
import model.Administrateur;
import dao.Test;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;

public class InterfaceSupprimerLivre extends JFrame {

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
					InterfaceSupprimerLivre frame = new InterfaceSupprimerLivre();
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
	public InterfaceSupprimerLivre() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Supprimer Livres");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(119, 38, 209, 29);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ISBN du livre :");
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(50, 96, 134, 29);
		contentPane.add(lblNewLabel_1);
		
		isbn = new JTextField();
		isbn.setBounds(181, 99, 195, 25);
		contentPane.add(isbn);
		isbn.setColumns(10);
		
		final JLabel resultat = new JLabel("");
		resultat.setForeground(new Color(0, 0, 0));
		resultat.setFont(new Font("Tahoma", Font.PLAIN, 13));
		resultat.setBounds(81, 150, 283, 43);
		contentPane.add(resultat);
		
		JButton supprimer = new JButton("supprimer");
		supprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con = Test.connection("jdbc:mysql://localhost:3306/tp3", "root", "samar2709");
				Administrateur admin = new Administrateur ();
				int rows = admin.supprimerLivres(con, isbn.getText());
				if(rows>0) {
					resultat.setText("Livre supprimé");
				}
				else {
					resultat.setText("Livre introuvable");
				}
			}
		});
		supprimer.setFont(new Font("Tahoma", Font.BOLD, 13));
		supprimer.setBounds(70, 203, 99, 29);
		contentPane.add(supprimer);
		
		JButton retour = new JButton("retour");
		retour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				InterfaceOptionsAdmin oa = new InterfaceOptionsAdmin();
				oa.show();
			}
		});
		retour.setFont(new Font("Tahoma", Font.BOLD, 13));
		retour.setBounds(248, 203, 99, 29);
		contentPane.add(retour);
	}

}










