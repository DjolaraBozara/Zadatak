package ui;

import java.util.Optional;
import java.util.Scanner;



import dao.DAOKorisniciImpl;
import domen.Korisnik;
import enums.KorisnikRole;

public class MainUi {
	
	public static Scanner scanner = new Scanner(System.in);
	public static Korisnik currentUser = null;

	public static void main(String[] args) {
		for (int i = 4; i > 0; i--) {
			System.out.printf("Imate jos %d pokusaja %n", i);
			Optional<Korisnik> korisnikOptional = unesiUserPass();
			if (korisnikOptional.isPresent()) {
				currentUser = korisnikOptional.get();
				break;
			}
		}
		
		
		if(currentUser == null) {
			System.out.println("Kraj programa");
			System.exit(0);
		}
		if(currentUser.getRole().equals(KorisnikRole.ADMIN)) {
			AdminMeni.adminMeni();
		}
		else if(currentUser.getRole().equals(KorisnikRole.EDITOR)) {

			EditorMeni.glavniMeni();
		}
	}
	
	
	
	
	
	public static Optional<Korisnik> unesiUserPass(){
		
		System.out.println("Unesite username: ");
		String username = MainUi.scanner.next();
		System.out.println("Unesite password: ");
		String password = MainUi.scanner.next();
		return DAOKorisniciImpl.getINSTANCE().userPassCheck(username, password);
	}
}
