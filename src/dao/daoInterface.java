package dao;

import java.util.List;
import java.util.Optional;

public interface daoInterface <T> {

	
	public Optional<T> vrati(T t);

	public void izmeni(T t);

	public void dodaj(T t);
	
	public void obrisi(T t);
	
	public List<T> vratiSve();
	
	
	
}
