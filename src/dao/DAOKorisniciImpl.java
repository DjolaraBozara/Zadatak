package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import domen.Korisnik;
import enums.KorisnikRole;
import exceptions.DataAlreadyExists;
import exceptions.DataNotFoundException;

public class DAOKorisniciImpl implements DaoInterface<Korisnik> {
	
	private final List<Korisnik> listaKorisnika;
	private static final DAOKorisniciImpl INSTANCE = new DAOKorisniciImpl();
	
	
	
	
	private DAOKorisniciImpl() {
		listaKorisnika = new ArrayList<Korisnik>() {
			{
				add(new Korisnik("admin", "adminovic", "admin", "admin123", KorisnikRole.ADMIN));
			}
		};
	}

	@Override
	public void add(Korisnik t) throws  DataAlreadyExists {
		Optional<Korisnik> korisnikOptional = returnOne(t);
		if(korisnikOptional.isPresent()) {
			throw new DataAlreadyExists();
		}
		listaKorisnika.add(t);
	}

	@Override
	public void delete(Korisnik t) throws DataNotFoundException {
		Optional<Korisnik> korisnikOptional = returnOne(t);
		if(!korisnikOptional.isPresent()) {
			throw new DataNotFoundException();
		}
		listaKorisnika.remove(t);
		
		
	}

	@Override
	public Optional<Korisnik> returnOne(Korisnik t) {
		return listaKorisnika.stream().filter(e -> e.equals(t)).findFirst();
	}

	@Override
	public List<Korisnik> returnAll() {
		return listaKorisnika;
	}

	@Override
	public void printAll() {
		listaKorisnika.stream().forEach(System.out::println);
	}

	public static DAOKorisniciImpl getINSTANCE() {
		return INSTANCE;
	}

	@Override
	public void izmeni(Korisnik t) throws DataNotFoundException {
		Optional<Korisnik> optionalKorisnik = returnOne(t);
		if(!optionalKorisnik.isPresent()) {
			throw new DataNotFoundException();
		}
		Scanner scanner = new Scanner(System.in);
		Korisnik korisnik = optionalKorisnik.get();
		System.out.println("Unesite novo ime: ");
		korisnik.setIme(scanner.next());
		System.out.println("Unesite novo prezime: ");
		korisnik.setPrezime(scanner.next());
		System.out.println("Unesite novi username: ");
		korisnik.setUsername(scanner.next());
		String role;
		while(true) {
		System.out.println("Unesite novi role(admin, editor");
		 role = scanner.next().toLowerCase();
		 if(role.equals("admin") || role.equals("editor")) {
			 break;
		 }
		System.out.println("Pogresan role");
		}
		KorisnikRole roleKorisnika = null;
		switch(role) {
		case "admin":
			roleKorisnika = KorisnikRole.ADMIN;
			break;
		case "editor":
			roleKorisnika = KorisnikRole.EDITOR;
			break;
		}
		korisnik.setRole(roleKorisnika);
		
	}
	
	public Optional<Korisnik> userPassCheck(String username, String password) {
		return listaKorisnika.stream().filter(x -> x.getUsername().equals(username) && x.getPassword().equals(password)).findFirst();
	
	}
	

}
