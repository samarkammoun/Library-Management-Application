package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;

public class InterfaceOptionsAdmin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceOptionsAdmin frame = new InterfaceOptionsAdmin();
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
	public InterfaceOptionsAdmin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Veuillez chosir une option");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setBounds(98, 0, 385, 89);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Afficher la liste de livres:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(32, 76, 179, 35);
		contentPane.add(lblNewLabel_1);
		
		JLabel btnChercherLivres = new JLabel("Chercher les livres d'un auteur :");
		btnChercherLivres.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnChercherLivres.setBounds(32, 121, 282, 35);
		contentPane.add(btnChercherLivres);
		
		JLabel lblNewLabel_1_2 = new JLabel("Supprimer un livre:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_1_2.setBounds(30, 166, 162, 35);
		contentPane.add(lblNewLabel_1_2);
		
		JButton btnSupprimerLivres = new JButton("Choisir");
		btnSupprimerLivres.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSupprimerLivres.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				InterfaceSupprimerLivre sl = new InterfaceSupprimerLivre();
				sl.show();
			}
		});
		btnSupprimerLivres.setBounds(274, 166, 98, 34);
		contentPane.add(btnSupprimerLivres);
		
		JButton btnChoisir_1 = new JButton("Choisir");
		btnChoisir_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnChoisir_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				InterfaceAfficheLivresAuteur ala = new InterfaceAfficheLivresAuteur();
				ala.show();
			}
		});
		btnChoisir_1.setBounds(274, 121, 98, 34);
		contentPane.add(btnChoisir_1);
		
		JButton btnAfficherLivres = new JButton("Choisir");
		btnAfficherLivres.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAfficherLivres.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				InterfaceAfficheLivres al = new InterfaceAfficheLivres();
				al.show();
				
			}
		});
		btnAfficherLivres.setBounds(274, 76, 98, 34);
		contentPane.add(btnAfficherLivres);
		
		JButton btnNewButton = new JButton("Retour");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				InterfaceIdentifierAdmin ad = new InterfaceIdentifierAdmin ();
				ad.show();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBounds(148, 226, 113, 27);
		contentPane.add(btnNewButton);
	}
}



