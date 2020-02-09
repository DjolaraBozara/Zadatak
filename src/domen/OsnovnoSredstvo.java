package domen;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Optional;

import dao.DAOOsnovnaSredstvaImpl;
import enums.OSStatus;
import enums.OSType;
import exceptions.DataAlreadyExists;

public class OsnovnoSredstvo {
	private final long id;
	private long inventarskiBroj;
	private String naziv;
	private String opis;
	private OSType tip;
	private OSStatus status;
	private LocalDate datumNabavke;
	private static long globalID=0;
	public OsnovnoSredstvo(String naziv, String opis, OSType tip,OSStatus status, long inventarskiBroj, LocalDate datumNabavke) throws DataAlreadyExists {
		this.naziv = Objects.requireNonNull(naziv);
		this.opis = Objects.requireNonNull(opis);
		this.tip = Objects.requireNonNull(tip);
		this.status = Objects.requireNonNull(status);
		setInventarskiBroj(inventarskiBroj);
		this.datumNabavke = Objects.requireNonNull(datumNabavke);
		this.id = ++globalID;
	}
	public long getId() {
		return id;
	}
	public long getInventarskiBroj() {
		return inventarskiBroj;
	}
	public String getNaziv() {
		return naziv;
	}
	public String getOpis() {
		return opis;
	}
	public OSType getTip() {
		return tip;
	}
	public OSStatus getStatus() {
		return status;
	}
	public LocalDate getDatumNabavke() {
		return datumNabavke;
	}
	public void setInventarskiBroj(long inventarskiBroj) throws DataAlreadyExists {
		Optional<OsnovnoSredstvo> optional = DAOOsnovnaSredstvaImpl.getINSTANCE().returnOne(inventarskiBroj);
		if(optional.isPresent()) {
			throw new DataAlreadyExists("Vec postoji osnovno sredstvo sa inventarskim brojem " + inventarskiBroj);
		}
		else {
		this.inventarskiBroj = inventarskiBroj;
		}
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public void setOpis(String opis) {
		this.opis = opis;
	}
	public void setTip(OSType tip) {
		this.tip = tip;
	}
	public void setStatus(OSStatus status) {
		this.status = status;
	}
	public void setDatumNabavke(LocalDate datumNabavke) {
		this.datumNabavke = datumNabavke;
	}
	@Override
	public String toString() {
		return "OsnovnoSredstvo [id=" + id + ", inventarskiBroj=" + inventarskiBroj + ", naziv=" + naziv + ", opis="
				+ opis + ", tip=" + tip + ", status=" + status + ", datumNabavke=" + datumNabavke + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (inventarskiBroj ^ (inventarskiBroj >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OsnovnoSredstvo other = (OsnovnoSredstvo) obj;
		if (inventarskiBroj != other.inventarskiBroj)
			return false;
		return true;
	}
	
	
	
	
	
}
