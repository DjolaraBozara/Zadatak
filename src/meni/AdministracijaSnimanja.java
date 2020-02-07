package meni;

import java.util.Scanner;

public class AdministracijaSnimanja {

	public static void main(String[] args) {
		
		int a;
		Scanner sc = new Scanner(System.in);
		System.out.println("Administracija korisnika");
		a = sc.nextInt();
		switch(a) 
		{
		
		case 1 : System.out.println("Unos");
		break;
		case 2 : System.out.println("Prikaz svihsnimanja");
		break;
		case 3 : System.out.println("Prikaz snimanja (po šifri)");
		break;
		case 4 : System.out.println("Brisanje snimanja");
		break;
		default: System.out.println("Povratak u glavni meni");
		break;
		}
	}	

}
	