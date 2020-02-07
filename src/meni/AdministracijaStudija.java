package meni;

import java.util.Scanner;

public class AdministracijaStudija {

	public static void main(String[] args) {
		
		int a;
		Scanner sc = new Scanner(System.in);
		System.out.println("Administracija Studija");
		a = sc.nextInt();
		switch(a) 
		{
		
		case 1 : System.out.println("Unos");
		break;
		case 2 : System.out.println("Prikaz svih studija");
		break;
		case 3 : System.out.println("Prikaz sortiran po nazivu");
		break;
		case 4 : System.out.println("Prikaz sortiran po lokaciji");
		break;
		case 5 : System.out.println("Prikaz studija");
		break;
		case 6 : System.out.println("Pretraga po nazivu");
		break;
		case 7 : System.out.println("Pretraga po lokaciji");
		break;
		case 8 : System.out.println("Izmena studija");
		break;
		case 9 : System.out.println("Brisanje studija (ne može se obrisati ukoliko je deo nekog snimanja");
		break;
		default: System.out.println("Povratak u glavni meni");
		break;
		}
	}	

}