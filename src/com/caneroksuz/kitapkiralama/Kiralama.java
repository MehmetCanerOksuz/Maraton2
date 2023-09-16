package com.caneroksuz.kitapkiralama;

public class Kiralama {
	
	private int id;
	private Kasiyer kasiyer;
	private Kitap kitap;
	private Musteri musteri;
	private long date;
	
	
	public Kiralama(int id, Kasiyer kasiyer, Kitap kitap, Musteri musteri) {
		super();
		this.id = id;
		this.kasiyer = kasiyer;
		this.kitap = kitap;
		this.musteri = musteri;
		this.date = System.currentTimeMillis();
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Kasiyer getKasiyer() {
		return kasiyer;
	}


	public void setKasiyer(Kasiyer kasiyer) {
		this.kasiyer = kasiyer;
	}


	public Kitap getKitap() {
		return kitap;
	}


	public void setKitap(Kitap kitap) {
		this.kitap = kitap;
	}


	public Musteri getMusteri() {
		return musteri;
	}


	public void setMusteri(Musteri musteri) {
		this.musteri = musteri;
	}


	public long getDate() {
		return date;
	}


	public void setDate(long date) {
		this.date = date;
	}


	@Override
	public String toString() {
		return "Kiralama [id=" + id + ", kasiyer=" + kasiyer + ", kitap=" + kitap + ", musteri=" + musteri + ", date="
				+ date + "]";
	}
	

	
}
