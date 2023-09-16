package com.caneroksuz.ucakbileti;

import java.util.Random;


public abstract class Yolcu {
	
Random random = new Random();
	
	
	private long id;
	private String ad;
	private String soyad;
	private int koltukNo;
	private boolean checkin;
	private final int BASEFIYAT =100;
	
	public Yolcu(long id, String ad, String soyad) {
		super();
		this.id = id;
		this.ad = ad;
		this.soyad = soyad;
		this.koltukNo = random.nextInt(1,500);
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAd() {
		return ad;
	}

	public void setAd(String ad) {
		this.ad = ad;
	}

	public String getSoyad() {
		return soyad;
	}

	public void setSoyad(String soyad) {
		this.soyad = soyad;
	}

	public int getKoltukNo() {
		return koltukNo;
	}

	public void setKoltukNo(int koltukNo) {
		this.koltukNo = koltukNo;
	}

	public boolean isCheckin() {
		return checkin;
	}

	public void setCheckin(boolean checkin) {
		this.checkin = checkin;
	}

	public int getBASEFIYAT() {
		return BASEFIYAT;
	}

	@Override
	public String toString() {
		return "Yolcu [id=" + id + ", ad=" + ad + ", soyad=" + soyad + ", koltukNo=" + koltukNo + ", checkin=" + checkin
				+ ", BASEFIYAT=" + BASEFIYAT + "]";
	}
	
	
	public abstract void yolcuBilgileriniGetir();
	
	public abstract void biletAl(EFirmaAdi firmaAdi);
	
	public abstract void checkinYap();
	
	public abstract void ucagaBin();

}
