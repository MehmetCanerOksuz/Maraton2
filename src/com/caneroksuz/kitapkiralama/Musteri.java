package com.caneroksuz.kitapkiralama;

import java.util.ArrayList;
import java.util.List;

public class Musteri extends Kisi{
	
	private List<Kitap> kiralananKitaplar = new ArrayList<>();
	
	public Musteri(int id, String isim) {
		super(id, isim);
		
	}

	public List<Kitap> getKiralananKitaplar() {
		return kiralananKitaplar;
	}

	public void setKiralananKitaplar(List<Kitap> kiralananKitaplar) {
		this.kiralananKitaplar = kiralananKitaplar;
	}

	@Override
	public String toString() {
		return "Musteri [getId()=" + getId() + ", getIsim()=" + getIsim() + "]";
	}

	
	
	

}
