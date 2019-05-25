import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class modifSalle extends JFrame implements ActionListener {
	private JButton afficher;
	private JLabel lblTitre,label1,label2;
	private JPanel pan;
	private JTextField code;
	private String code1;
	private salle sal;

	public modifSalle(salle sal) {
		this.sal = sal;
		setSize(400, 400);
		pan = new JPanel();
		getContentPane().add(pan);
		pan.setBackground(Color.white);
		pan.setLayout(new GridLayout(12, 1));
		
		lblTitre = new JLabel("Panel Digicode");
		lblTitre.setForeground(Color.black);
		pan.add(lblTitre);
		
		label1 = new JLabel("Modifier le code de la salle n°"+sal.getId()+"");
		label1.setForeground(Color.black);
		pan.add(label1);
		
		label2 = new JLabel("Code actuel : "+sal.getCode()+"");
		pan.add(label2);
		code = new JTextField();
		pan.add(code);

		afficher = new JButton("Appliquer");
		afficher.addActionListener(this);
		pan.add(afficher);
		
		setLocationRelativeTo(null);
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		code1 = code.getText();
		connexion c = new connexion();
		int r = c.executeUp("UPDATE `salles` SET `code` = '"+code1+"' WHERE `salles`.`id` = "+sal.getId()+"");
				JOptionPane.showMessageDialog(null,"Le digicode de la salle n°"+sal.getId()+" à bien été mis à jour !");
			
				
		}
}
