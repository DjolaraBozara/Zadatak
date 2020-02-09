package domen;

import java.util.Objects;

import enums.KorisnikRole;

public class Korisnik {
	private String ime;
	private String prezime;
	private String username;
	private String password;
	private KorisnikRole role;

	public Korisnik(String ime, String prezime, String username, String password, KorisnikRole role) {
		if(!proveraSifre(password)) {
			throw new IllegalArgumentException();
		}
		this.ime = Objects.requireNonNull(ime);
		this.prezime = Objects.requireNonNull(prezime);
		this.username = Objects.requireNonNull(username);
		this.password = Objects.requireNonNull(password);
		this.role = Objects.requireNonNull(role);
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}


	public KorisnikRole getRole() {
		return role;
	}

	public void setRole(KorisnikRole role) {
		this.role = role;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		Korisnik other = (Korisnik) obj;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Korisnik [ime=" + ime + ", prezime=" + prezime + ", username=" + username + ", role=" + role + "]";
	}
	
	private boolean proveraSifre(String password) {
		return password.matches("^[A-Za-z]+\\d+.*$");
	}
	

}
