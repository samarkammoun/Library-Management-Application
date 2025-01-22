package view;

import java.awt.EventQueue;
import dao.Test;
import model.Administrateur;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class InterfaceAfficheLivresAuteur extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField nomAuteur;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceAfficheLivresAuteur frame = new InterfaceAfficheLivresAuteur();
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
	public InterfaceAfficheLivresAuteur() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 556, 329);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setBounds(196, 26, 336, 205);
		contentPane.add(table);
		
		JLabel lblNewLabel = new JLabel("Donner le nom de l'auteur:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 61, 182, 15);
		contentPane.add(lblNewLabel);
		
		nomAuteur = new JTextField();
		nomAuteur.setBounds(10, 94, 159, 26);
		contentPane.add(nomAuteur);
		nomAuteur.setColumns(10);
		
		JButton btnNewButton = new JButton("Afficher");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con = Test.connection("jdbc:mysql://localhost:3306/tp3", "root", "samar2709");
				Administrateur admin = new Administrateur ();
				ResultSet rs = admin.afficheLivresAuteur(con,nomAuteur.getText());
				try {
					ResultSetMetaData rsmd = rs.getMetaData();
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					int cols = rsmd.getColumnCount();
					String[] colName = new String [cols];
					for (int i = 0; i<cols;i++) 
						colName[i]=rsmd.getColumnName(i+1);
					model.setColumnIdentifiers(colName);
					model.addRow(new Object[]{"isbn","auteur","titre","Année de Parution","Prix","Quantité"});
					while (rs.next()) {
						String isbn = rs.getString(1);
						String auteur = rs.getString(2);
						String titre = rs.getString(3);
						int anneeP = rs.getInt(4);
						float prix = rs.getFloat(5);
						int quantité = rs.getInt(6);
						String [] row = {isbn,auteur,titre,String.valueOf(anneeP),String.valueOf(prix),String.valueOf(quantité)};
						model.addRow(row);
					}
						
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBounds(28, 249, 102, 33);
		contentPane.add(btnNewButton);
		
		JButton btnRetour = new JButton("Retour");
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				InterfaceOptionsAdmin oa = new InterfaceOptionsAdmin();
				oa.show();
				
			}
		});
		btnRetour.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnRetour.setBounds(413, 249, 102, 33);
		contentPane.add(btnRetour);
	}
}





