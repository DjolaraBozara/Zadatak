package meni;

import java.util.Scanner;

public class AdministracijaEmisija {

	public static void main(String[] args) {
		
		int a;
		Scanner sc = new Scanner(System.in);
		System.out.println("Administracija emisija");
		a = sc.nextInt();
		switch(a) 
		{
		
		case 1 : System.out.println("Unos");
		break;
		case 2 : System.out.println("Prikaz svih emisija");
		break;
		case 3 : System.out.println("Prikaz sortiran po nazivu");
		break;
		case 4 : System.out.println("Prikaz sortiran po tipu");
		break;
		case 5 : System.out.println("Prikaz emisije(a)");
		break;
		case 6 : System.out.println("Pretraga po nazivu");
		break;
		case 7 : System.out.println("Pretraga po tipu");
		break;
		case 8 : System.out.println("Izmena emisije");
		break;
		case 9 : System.out.println("Brisanje emisije (ne može se obrisati ukoliko je deo nekog snimanja");
		break;
		default: System.out.println("Povratak u glavni meni");
		break;
		}
	}	

}
	