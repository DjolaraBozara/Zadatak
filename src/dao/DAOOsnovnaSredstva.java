package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import domen.OsnovnaSredstva;


public class DAOOsnovnaSredstva implements daoInterface<OsnovnaSredstva> {

	List<OsnovnaSredstva> listaSredstava = new ArrayList<>();

	private DAOOsnovnaSredstva(List<OsnovnaSredstva> listaSredstava) {
		super();
		this.listaSredstava = listaSredstava;
	}

	@Override
	public Optional<OsnovnaSredstva> vrati(OsnovnaSredstva t) {

		return this.listaSredstava.stream().filter(x -> x.getNaziv() == t.getNaziv()).findFirst();
	}

	@Override
	public void izmeni(OsnovnaSredstva t) {
		System.out.println("Unesite onsovno sredstvo:");
	Scanner = new Scanner(System.in);
		
	}

	@Override
	public void dodaj(OsnovnaSredstva t) {
		this.listaSredstava.add(t);
	}

	@Override
	public void obrisi(OsnovnaSredstva t) {
		this.listaSredstava.remove(t);
	}

	@Override
	public List<OsnovnaSredstva> vratiSve() {
		return this.listaSredstava;
	}
	


}
