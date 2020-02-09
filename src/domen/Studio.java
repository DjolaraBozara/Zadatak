package domen;

import java.util.Objects;

public class Studio {
	
	private static long globalID=0; 
	private final long id;
	private String naziv;
	private String opis;
	private String lokacija;
	
	
	
	
	
	public Studio(String naziv, String opis, String lokacija) {
		super();
		this.id = ++globalID;
		this.naziv = Objects.requireNonNull(naziv);
		this.opis =  Objects.requireNonNull(opis);
		this.lokacija =  Objects.requireNonNull(lokacija);
	}

	public long getId() {
		return id;
	}

	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public String getOpis() {
		return opis;
	}
	public void setOpis(String opis) {
		this.opis = opis;
	}
	public String getLokacija() {
		return lokacija;
	}
	public void setLokacija(String lokacija) {
		this.lokacija = lokacija;
	}
	
	
	
}
