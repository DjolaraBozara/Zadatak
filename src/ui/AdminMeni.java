package ui;

import java.util.Optional;
import java.util.Scanner;

import dao.DAOKorisniciImpl;
import domen.Korisnik;
import enums.KorisnikRole;
import exceptions.DataAlreadyExists;
import exceptions.DataNotFoundException;


public class AdminMeni {
	private static Scanner scanner = new Scanner(System.in);
	public static void adminMeni() {

		while(true) {
		printGlavniAdminMeni();
		int izbor =  scanner.nextInt();
		if(izbor ==0) {
			MainUi.currentUser = null;
			break;
		}
		switch(izbor) {
		case 1: 
			unosKorisnika();
			break;
		case 2:
			printAllKorisnika();
			break;
		case 3:
			try {
				prikaziKorisnika();
			} catch (DataNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println("Korisnik ne postoji");
			}
			break;
		case 4:
			izmeniKorisnika(scanner);
			break;
		case 5:
			obrisiKorisnika();
			break;
		default:
			System.out.println("Pogresna komanda");
		}
		
		
		}
		MainUi.main(null);
		
	}
	private static void obrisiKorisnika() {
		String username = username();
		Korisnik korisnik = new Korisnik("a", "b", username, "a1", KorisnikRole.ADMIN);
		System.out.println("Korisnik uspesno obrisan!");
		try {
			DAOKorisniciImpl.getINSTANCE().delete(korisnik);
		} catch (DataNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Uneti korisnik ne postoji");
		}
	}
	private static void izmeniKorisnika(Scanner scanner) {
		System.out.println("Username korisnika kojeg zelite da izmenite: ");
		String username = scanner.next();
		try {
			DAOKorisniciImpl.getINSTANCE().izmeni(new Korisnik("a", "a", username, "a2", KorisnikRole.ADMIN));
		} catch (DataNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Uneti korisnik ne postoji");
		}
		
	}
	private static void prikaziKorisnika() throws DataNotFoundException {
	String username = username();
	Optional<Korisnik> optionalKorisnik = DAOKorisniciImpl.getINSTANCE().returnOne(new Korisnik("a", "a", username, "a23", KorisnikRole.ADMIN));
	if(!optionalKorisnik.isPresent()) {
		throw new DataNotFoundException();
	}
	System.out.println(optionalKorisnik.get());
	}
	private static void printAllKorisnika() {
		DAOKorisniciImpl.getINSTANCE().printAll();
	}
	private static void unosKorisnika() {
		System.out.println("Ime novog korisnika: ");
		String ime = scanner.next();
		System.out.println("Prezime novog korisnika");
		String prezime = scanner.next();
		String username = username();
		String role;
		while(true) {
			System.out.println("Unesite novi role(admin, editor)");
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
			String password;
		while(true) {
		System.out.println("Ukucajte password: ");
		password = scanner.next();
		System.out.println("Potvrdite password: ");
		String password1 = scanner.next();
		if(password.equals(password1)) {
			break;
		}
		else {
			System.out.println("Pogresno ste uneli password");
		}
		}
		
		try {
			Korisnik korisnik = new Korisnik(ime, prezime, username, password, roleKorisnika);
			DAOKorisniciImpl.getINSTANCE().add(korisnik);
		} catch (DataAlreadyExists e) {
			// TODO Auto-generated catch block
			System.out.println("Korisnik vec postoji!");
		} catch (IllegalArgumentException e) {
			System.out.println("Sifra je lose uneta!");
		}
		
		
		
	}
	public static void printGlavniAdminMeni() {
		System.out.println("1. Unos");
		System.out.println("2. Prikaz svih korisnika");
		System.out.println("3. Prikaz korisnika");
		System.out.println("4. Izmena korisnika");
		System.out.println("5. Brisanje korisnika");
		System.out.println("0. exit");
	}
	
	public static String username() {
		System.out.println("Ukucajte username: ");
		return scanner.next();
	}
}
