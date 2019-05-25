
public class salle {
	private int id,code,etage;
	private String nom,type,adresse,cp,ville;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public int getEtage() {
		return etage;
	}
	public void setEtage(int etage) {
		this.etage = etage;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getCp() {
		return cp;
	}
	public void setCp(String cp) {
		this.cp = cp;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	@Override
	public String toString() {
		return "Salle n° " + id + "";
	}
	public salle(int id, int code, int etage, String nom, String type, String adresse, String cp, String ville) {
		super();
		this.id = id;
		this.code = code;
		this.etage = etage;
		this.nom = nom;
		this.type = type;
		this.adresse = adresse;
		this.cp = cp;
		this.ville = ville;
	}
	
	
}
