package meni;

import java.util.Scanner;

public class AdministracijaOsnovnihSredstava {

	public static void main(String[] args) {
		
		int a;
		Scanner sc = new Scanner(System.in);
		System.out.println("Administracija osnovnih stredstava");
		a = sc.nextInt();
		switch(a) 
		{
		
		case 1 : System.out.println("Unos");
		break;
		case 2 : System.out.println("Prikaz svih osnovnih sredstava");
		break;
		case 3 : System.out.println("Prikaz sortiran po datumu nabavke");
		break;
		case 4 : System.out.println("Prikaz sortiran po nazivu");
		break;
		case 5 : System.out.println("Prikaz osnovnog sredstava");
		break;
		case 6 : System.out.println("Pretraga po nazivu");
		break;
		case 7 : System.out.println(" Pretraga po tipu");
		break;
		case 8 : System.out.println("Izmena osnovnog sredstva");
		break;
		case 9 : System.out.println("Brisanje osnovnog sredstva (ne može se obrisati ukoliko je deo nekog snimanja");
		break;
		default: System.out.println("Povratak u glavni meni");
		break;
		}
	}	

}
	


