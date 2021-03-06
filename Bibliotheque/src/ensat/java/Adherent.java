package ensat.java;

import java.util.Iterator;
import java.util.Vector;

public class Adherent {
private String nom;
private String prenom;
private Vector<Livre> panier ;
private long idAdherent;

public Adherent(String nom, String prenom) {
	this.nom=nom;
	this.prenom=prenom;
	panier= new Vector<Livre>();
	idAdherent++;
}

public String toString(){
	String res;
	res = prenom+" "+ nom;
	Iterator<Livre> i = panier.iterator();
	while(i.hasNext()){
		res+= ":\n"+i.next().toString()+"\n";
	}
	return res;
}

void emprunter(Document d){
	if(d.empruntable()){
		Livre l = (Livre) d; 
		if(l.dispo){
			panier.addElement(l);
			l.dispo=false;
			l.idEmprunteur = idAdherent;
		}
	}
	else{
		System.out.println("Ce document ne peut pas �tre emprunter");
	}
}
}
