package hu.unideb.inf.DAO;

import java.time.LocalDateTime;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Player {
	
	int celban;
	int lepes;
	String datum;
	String nev;
	
	
	public String getNev() {
		return nev;
	}
	
	@XmlElement
	public void setNev(String nev) {
		this.nev = nev;
	}

	public int getCelban() {
		return celban;
	}
	
	@XmlElement
	public void setCelban(int celban) {
		this.celban = celban;
	}
	
	
	public int getLepes() {
		return lepes;
	}
	
	@XmlElement
	public void setLepes(int lepes) {
		this.lepes = lepes;
	}

	public String getDatum() {
		return datum;
	}

	@XmlAttribute
	public void setDatum(String datum) {
		this.datum = datum;
	}

	
}
