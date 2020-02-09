package dao;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

import domen.Korisnik;
import domen.OsnovnoSredstvo;
import enums.OSStatus;
import enums.OSType;
import exceptions.DataAlreadyExists;
import exceptions.DataNotFoundException;

public class DAOOsnovnaSredstvaImpl implements DaoInterface<OsnovnoSredstvo> {

	private static DAOOsnovnaSredstvaImpl INSTANCE = new DAOOsnovnaSredstvaImpl();
	private List<OsnovnoSredstvo> listaOS;
	
	private DAOOsnovnaSredstvaImpl(){
		listaOS = new ArrayList<OsnovnoSredstvo>();
	}
	
	
	@Override
	public void add(OsnovnoSredstvo t) throws DataAlreadyExists, IllegalArgumentException {
		if(t== null) {
			throw new IllegalArgumentException("Vrednost null");
		}
		Optional<OsnovnoSredstvo> optionalOs = returnOne(t.getInventarskiBroj());
		if(optionalOs.isPresent()) {
			throw new DataAlreadyExists("Vec postoji Osnovno Sredstvo sa tim inventarskim brojem!");
		}
		listaOS.add(t);
	}

	@Override
	public void delete(OsnovnoSredstvo t) throws DataNotFoundException {
		Optional<OsnovnoSredstvo> osOptional = returnOne(t.getInventarskiBroj());
		if(!osOptional.isPresent()) {
			throw new DataNotFoundException("Osnovno sredstvo ne postoji");
		}
		// treba da se doda uslov vezan za snimanje
		listaOS.remove(t);
		
	}

	@Override
	public void izmeni(OsnovnoSredstvo t) throws DataNotFoundException, IllegalArgumentException{
		if(t== null) {
			throw new IllegalArgumentException("Vrednost null");
		}
		Optional<OsnovnoSredstvo> optionalOS = returnOne(t);
		if(!optionalOS.isPresent()) {
			throw new DataNotFoundException();
		}
		OsnovnoSredstvo o = optionalOS.get();
		o.setDatumNabavke(t.getDatumNabavke());
		try {
			o.setInventarskiBroj(t.getInventarskiBroj());
		} catch (DataAlreadyExists e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
		o.setNaziv(t.getNaziv());
		o.setOpis(t.getOpis());
		o.setStatus(t.getStatus());
		o.setTip(t.getTip());
		
		

		
		
		
	}

	@Override
	public Optional<OsnovnoSredstvo> returnOne(OsnovnoSredstvo t) {
		return listaOS.parallelStream().filter(x -> x.equals(t)).findFirst();
	}
	public Optional<OsnovnoSredstvo> returnOne(String naziv) {
		return listaOS.parallelStream().filter(x -> x.getNaziv().equals(naziv)).findFirst();
	}
	public List<OsnovnoSredstvo> returnOne(OSType tip) {
		return listaOS.parallelStream().filter(x -> x.getTip().equals(tip)).collect(Collectors.toList());
	}
	public Optional<OsnovnoSredstvo> returnOne(long iBroj){
		return listaOS.stream().filter(x -> x.getInventarskiBroj() == iBroj).findFirst();
	}
	@Override
	public List<OsnovnoSredstvo> returnAll() {
		return listaOS;
	}

	@Override
	public void printAll() {
		listaOS.parallelStream().forEach(System.out::println);
	}
	
	public void sortByComparator(Comparator<OsnovnoSredstvo> c) {
		listaOS.stream().sorted(c).forEach(System.out::println);
	}


	public static DAOOsnovnaSredstvaImpl getINSTANCE() {
		return INSTANCE;
	}


	public List<OsnovnoSredstvo> getListaOS() {
		return listaOS;
	}


	public void setListaOS(List<OsnovnoSredstvo> listaOS) {
		this.listaOS = listaOS;
	}
	

	

}
