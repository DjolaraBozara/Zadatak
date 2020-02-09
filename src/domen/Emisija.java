package domen;

import java.util.Objects;

import enums.EmisijaType;


public class Emisija {
	private final long id;
	private String naziv;
	private String opis;
	private EmisijaType tip;
	private long globalID=0;
	public Emisija(String naziv, String opis, EmisijaType tip) {
		this.id = ++globalID;
		this.naziv = Objects.requireNonNull(naziv);
		this.opis = Objects.requireNonNull(opis);
		this.tip = Objects.requireNonNull(tip);
	}
	public long getId() {
		return id;
	}
	public String getNaziv() {
		return naziv;
	}
	public String getOpis() {
		return opis;
	}
	public EmisijaType getTip() {
		return tip;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public void setOpis(String opis) {
		this.opis = opis;
	}
	public void setTip(EmisijaType tip) {
		this.tip = tip;
	}

	
		
	
	
}
