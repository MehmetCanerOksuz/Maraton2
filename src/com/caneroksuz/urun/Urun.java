package com.caneroksuz.urun;

public class Urun {
	

	private String ad;
	private double fiyat;
	
	public Urun(String ad, double fiyat) {
		super();
		this.ad = ad;
		this.fiyat = fiyat;
	}
	public String getAd() {
		return ad;
	}
	public void setAd(String ad) {
		this.ad = ad;
	}
	public double getFiyat() {
		return fiyat;
	}
	public void setFiyat(double fiyat) {
		this.fiyat = fiyat;
	}
	@Override
	public String toString() {
		return "Urun [ad=" + ad + ", fiyat=" + fiyat + "]";
	}
	
	
	

}
