import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.*;

public class checkMembre extends JFrame implements ActionListener{
	
	private JLabel lblTitre, lblId, lblMdp;
	private JTextField id, mdp;
	private JButton afficher;
	private JPanel pan;
	private String id1,mdp1;
	private afficheSalle fensal;
	
	public checkMembre()
	{
		setSize(400, 400);
		pan = new JPanel();
		getContentPane().add(pan);
		pan.setBackground(Color.white);
		pan.setLayout(new GridLayout(12, 1));
		lblTitre = new JLabel("Connexion espace Digicode");
		Font f = new Font("Courrier New", Font.BOLD, 18);
		lblTitre.setForeground(Color.black);
		lblTitre.setFont(f);
		pan.add(lblTitre);
		
		lblId = new JLabel("Entrer votre identifiant :");
		pan.add(lblId);
		id = new JTextField();
		pan.add(id);
		
		
		lblMdp= new JLabel("Entrer votre mot de passe :");
		pan.add(lblMdp);
		mdp = new JTextField();
		pan.add(mdp);
		
		afficher = new JButton("Connexion");
		afficher.addActionListener(this);
		pan.add(afficher);
		
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		id1 = id.getText();
		mdp1 = mdp.getText();
		ArrayList<user> users = new ArrayList<user>();
		
		connexion c = new connexion();
		ResultSet r2 = c.executeRequete("SELECT COUNT(*) FROM users WHERE pseudo LIKE '"+id1+"'");
		try {
			System.out.println(r2);
			while(r2.next())
			{		
				if(r2.getInt(1) < 1)
				{
					JOptionPane.showMessageDialog(null,"Aucun utilisateur trouvé !");
				}
			}
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		ResultSet r = c.executeRequete("SELECT * FROM users WHERE pseudo LIKE '"+id1+"'");
		try {
			while(r.next())
			{		
					if (mdp1.equals(r.getString(6))) {
						user user = new user(r.getInt(1), r.getString(2),r.getString(3), r.getString(4), r.getString(5),r.getString(6),r.getInt(7));
						users.add(user);
						JOptionPane.showMessageDialog(null,"Vous êtes bien connecté !");
						fensal = new afficheSalle(user);
						setVisible(false);
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Mot de passe incorrect !");
					}
					
			}
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
		
		
		
	}

}
