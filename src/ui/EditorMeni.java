package ui;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import javax.swing.text.DateFormatter;

import dao.DAOOsnovnaSredstvaImpl;
import domen.OsnovnoSredstvo;
import enums.OSStatus;
import enums.OSType;
import exceptions.DataAlreadyExists;
import exceptions.DataNotFoundException;

public class EditorMeni {

	private static Scanner scanner = new Scanner(System.in);
	
	
	
	
	
	
	
	public static void printMainMenu() {
		System.out.println("1. Administracija osnovnih sredstava");
		System.out.println("2. Administracija emisija");
		System.out.println("3. Administracija studija");
		System.out.println("4. Administracija snimanja");
		System.out.println("0. Back to login");
	}
	
	public static void printAdministracijaOsnovnihSredstava() {
		System.out.println("1. Unos");
		System.out.println("2. Prikaz svih osnovnih sredstava");
		System.out.println("3. Prikaz osnovnog sredstva");
		System.out.println("4. Izmena osnovnog sredstva");
		System.out.println("5. Brisanje osnovnog sredstva");
	}
	public static void printAdministracijaEmisija() {
		System.out.println("1. Unos");
		System.out.println("2. Prikaz svih emisija");
		System.out.println("3. Prikaz emisije");
		System.out.println("4. Izmena emisije");
		System.out.println("5. Brisanje emisije(ne moze se obrisati ukoliko je deo snimanja)");
	}
	public static void printAdministracijaStudija() {
		System.out.println("1. Unos");
		System.out.println("2. Prikaz svih emisija");
		System.out.println("3. Prikaz emisije");
		System.out.println("4. Izmena emisije");
		System.out.println("5. Brisanje emisije(ne moze se obrisati ukoliko je deo snimanja)");
	}
	public static void administracijaOsnovnihSredstavaIzbor() {
		while(true) {
			printAdministracijaOsnovnihSredstava();
		int izbor = scanner.nextInt();
		if(izbor == 0) {
			break;
		}
		switch (izbor) {
		case 1:
			unosOsnovnogSredstva();
			break;

		case 2:
			izborSorta();
			break;
		case 3:
			izborPretrage();
			break;		
		case 4:
			izmenaOsnovnogSredstva();
			break;
		case 5:
			brisanjeOsnovnogSredstva();
			break;
		default:
			System.out.println("Pogresna komanda");
		}
	}
	}
	public static void glavniMeni() {
		
		while(true) {
			printMainMenu();
		int izbor = scanner.nextInt();
		if(izbor == 0) {
			break;
		}
		switch (izbor) {
		case 1:
			administracijaOsnovnihSredstavaIzbor();
			break;

		case 2:
			
			break;
		case 3:
		
			break;		
		case 4:
			
			break;

		default:
			System.out.println("Pogresna komanda");
		}
		
	}
	}

	private static void brisanjeOsnovnogSredstva() {
		// TODO Auto-generated method stub
		
	}

	private static void izmenaOsnovnogSredstva() {
		OsnovnoSredstvo osnovnoSredstvo = null;
		try {
			 osnovnoSredstvo = napraviOs();
		} catch (DataAlreadyExists e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			DAOOsnovnaSredstvaImpl.getINSTANCE().izmeni(osnovnoSredstvo);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			System.out.println("Null vrednost");
		} catch (DataNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Data ne postoji");
		}
	}

	private static void izborPretrage() {
		System.out.println("1. Pretraga po nazivu: ");
		System.out.println("2. Pretraga po tipu");
		int izbor = scanner.nextInt();
		switch(izbor) {
			case 1:
				pretragaPoNazivu();
				break;
			case 2:
				pretragaPoTipu();
				break;
			default:
				System.out.println("Pogresna komanda!");
		}
		
	}

	private static void pretragaPoTipu() {
		OSType osType = osType();
		List<OsnovnoSredstvo> listaList = DAOOsnovnaSredstvaImpl.getINSTANCE().returnOne(osType);
		listaList.stream().forEach(System.out::println);
		
	}

	private static void pretragaPoNazivu() {
	String naziv = nazivOs();
	Optional<OsnovnoSredstvo> optional = DAOOsnovnaSredstvaImpl.getINSTANCE().returnOne(naziv);
	if(optional.isPresent()) {
		System.out.println(optional.get());
	} else {
		System.out.println("Ne postoji sa tim nazivom");
	}
		
	}

	private static void izborSorta() {
		System.out.println("1. Prikaz sortiran po datumu nabavke: ");
		System.out.println("2. Prikaz sortiran po nazivu");
		int izbor = scanner.nextInt();
		switch(izbor) {
			case 1:
				sortirajPoDatumu();
				break;
			case 2:
				sortirajPoNazivu();
				break;
			default:
				System.out.println("Pogresna komanda!");
		}
		
		
	}

	private static void sortirajPoNazivu() {
		DAOOsnovnaSredstvaImpl.getINSTANCE().sortByComparator((x, y) -> x.getNaziv().compareTo(y.getNaziv()));
		
	}

	private static void sortirajPoDatumu() {
		DAOOsnovnaSredstvaImpl.getINSTANCE().sortByComparator((x, y) -> x.getDatumNabavke().compareTo(y.getDatumNabavke())) ;
		
	}

	private static void unosOsnovnogSredstva() {
		OsnovnoSredstvo os = null;
		try {
			os = napraviOs();
		} catch (DataAlreadyExists e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			DAOOsnovnaSredstvaImpl.getINSTANCE().add(os);
		} catch (DataAlreadyExists e) {
			// TODO Auto-generated catch block
			
			System.out.println("Data vec postoji");
		} catch (NullPointerException e) {
			System.out.println(e);
		}
		
		
	}

	private static OsnovnoSredstvo napraviOs() throws DataAlreadyExists {
		String naziv = nazivOs();
		System.out.println("Opis os: ");
		String opis = scanner.next();
		OSType osType = osType();
		System.out.println("Status os(aktivno, otpisano, rashodovano): ");
		String status = scanner.next().toLowerCase();
		OSStatus osStatus = null;
		switch(status) {
			case "aktivno":
				osStatus = OSStatus.AKTIVNO;
				break;
			case "otpisano":
				osStatus = OSStatus.OTPISANO;
				break;
			case "rashodovano":
				osStatus = OSStatus.RASHODOVANO;
				break;	
			
		}
		System.out.println("Inventarski broj: ");
		long inventarskiBroj = scanner.nextLong();
		System.out.println("Datum u formatu(dd.MM.yyyy.):");
		String dateString = scanner.next();
		DateTimeFormatter df = DateTimeFormatter.ofPattern("dd.MM.yyyy.");
		LocalDate date = null;
		try {
		date = LocalDate.parse(dateString, df);
		} catch (DateTimeParseException e) {
			System.out.println(e);
		}
		OsnovnoSredstvo os = new OsnovnoSredstvo(naziv, opis, osType, osStatus, inventarskiBroj, date);
		return os;
	}

	private static String nazivOs() {
		System.out.println("Naziv os: ");
		String naziv = scanner.next();
		return naziv;
	}

	private static OSType osType() {
		System.out.println("Tip os(kamera, reflektor, stativ, objektiv): ");
		String tip = scanner.next().toLowerCase();
		OSType osType = null;
		switch(tip) {
			case "kamera":
				osType = OSType.Kamera;
				break;
			case "reflektor":
				osType = OSType.Reflektor;
				break;
			case "stativ":
				osType = OSType.Stativ;
				break;
			case "objektiv":
				osType = OSType.Objektiv;
				break;			
			
		}
		return osType;
	}
	
	
	
	
	
}
