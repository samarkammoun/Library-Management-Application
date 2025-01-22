package model;

public class Livre {
	public String isbn;
	public String auteur;
	public String titre;
	public int année_Parution;
	private float prix;
	
	
	public Livre(String i,String a,String t,int aP,float p) {
		this.isbn=i;
		this.auteur=a;
		this.titre=t;
		this.année_Parution=aP;
		this.prix=p;
	}
	
	public void setPrix(float p) {
		this.prix=p;
	}
	
	public float getPrix() {
		return prix;
	}
	
}


















