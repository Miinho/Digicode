import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.*;

public class afficheSalle extends JFrame implements ActionListener{

	private JButton afficher,afficher2;
	private JLabel lblTitre;
	private JPanel pan;
	private JComboBox<salle> selecteur;
	
	private modifSalle modifsal;
	
	public afficheSalle(user user) {
		
		setSize(400, 400);
		pan = new JPanel();
		getContentPane().add(pan);
		pan.setBackground(Color.white);
		pan.setLayout(new GridLayout(12, 1));
		if (user.getGrade() == 1) {
			lblTitre = new JLabel("Panel Digicode [Mode Administrateur]");
		}else {
			lblTitre = new JLabel("Panel Digicode");
		}
		
		lblTitre.setForeground(Color.black);
		pan.add(lblTitre);
		
		selecteur = new JComboBox<salle>();
		pan.add(selecteur);
		if (user.getGrade() == 1) {
			afficher2 = new JButton("Modifier détails");
			afficher2.addActionListener(this);
			pan.add(afficher2);
		}
		
		afficher = new JButton("Afficher détails");
		afficher.addActionListener(this);
		pan.add(afficher);
		
		connexion c = new connexion();
		ArrayList<salle> listeSalle = new ArrayList<salle>();
		ResultSet r = c.executeRequete("select * from salles");
		
		try {
			while(r.next())
			{
				salle salle = new salle(r.getInt(1), r.getInt(3), r.getInt(8), r.getString(2), r.getString(4), r.getString(5), r.getString(6), r.getString(7));
				listeSalle.add(salle);
			}
			
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		for (salle salle1 : listeSalle) {
			selecteur.addItem(salle1);
		}
		
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
			salle s = (salle)selecteur.getSelectedItem();
			
			ArrayList<salle> listeSalle = new ArrayList<salle>();
			
			connexion c = new connexion();
			ResultSet r = c.executeRequete("SELECT * FROM salles WHERE id LIKE "+s.getId());
			
			try {
				while(r.next())
				{
					salle sal = new salle(r.getInt(1), r.getInt(3), r.getInt(8), r.getString(2), r.getString(4), r.getString(5), r.getString(6), r.getString(7));
					listeSalle.add(sal);
					if(e.getSource() == afficher)
					{
						String resultSalle = "Détails de la salle n°"+s.getId()+"\n"
								+ "Nom : "+s.getNom()+"\n"
								+ "Etage : "+s.getEtage()+"\n"
								+ "Code : "+s.getCode()+"\n"
								+ "Type : "+s.getType()+"\n"
								+ "Adresse : "+s.getAdresse()+"\n"
								+ "Ville : "+s.getVille()+"\n"
								+ "CP : "+s.getCp()+"\n";
						
						JOptionPane.showMessageDialog(null,resultSalle);
					}
					if(e.getSource() == afficher2)
					{
						modifsal = new modifSalle(sal);
					}
				}
				
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
			
		}
}
