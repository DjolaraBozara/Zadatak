package domen;

import java.util.Date;
import java.util.Objects;

public class OsnovnaSredstva {
	private String naziv;
	private Date datum;
	private String tip;

	private OsnovnaSredstva(String naziv, Date datum, String tip) {

		this.naziv = Objects.requireNonNull(naziv);
		this.datum = Objects.requireNonNull(datum);
		this.tip = Objects.requireNonNull(tip);

	}
	
	
	public static OsnovnaSredstva valueOf(String naziv, Date datum, String tip) {
		return new OsnovnaSredstva(naziv,datum,tip);
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public Date getDatum() {
		return datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	@Override
	public String toString() {
		return "OsnovnaSredstva [naziv=" + naziv + ", datum=" + datum + ", tip=" + tip + "]";
	}

}
