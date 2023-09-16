package com.caneroksuz.ucakbileti;

import java.util.HashMap;
import java.util.Map;

public class EkonomiYolcu extends Yolcu{

private final int EKONOMOFIYAT = 100;
	
	private Map<EFirmaAdi, Integer> biletler = new HashMap<>();

	public EkonomiYolcu(long id, String ad, String soyad) {
		super(id, ad, soyad);
	}

	public Map<EFirmaAdi, Integer> getBiletler() {
		return biletler;
	}

	public void setBiletler(Map<EFirmaAdi, Integer> biletler) {
		this.biletler = biletler;
	}

	public int getEKONOMOFIYAT() {
		return EKONOMOFIYAT;
	}

	@Override
	public String toString() {
		return "EkonomiYolcu [EKONOMOFIYAT=" + EKONOMOFIYAT + ", biletler=" + biletler + ", getId()=" + getId()
				+ ", getAd()=" + getAd() + ", getSoyad()=" + getSoyad() + ", getKoltukNo()=" + getKoltukNo()
				+ ", isCheckin()=" + isCheckin() + "]";
	}

	@Override
	public void yolcuBilgileriniGetir() {

		System.out.println("Ekonomi Yolcusu " + getAd() + " Biletleri : " +getBiletler());
		
	}

	@Override
	public void biletAl(EFirmaAdi firmaAdi) {
		
		int biletFiyati=getBASEFIYAT()+EKONOMOFIYAT;
		if(biletler.containsKey(firmaAdi)) {
			int a =biletler.get(firmaAdi);
			biletler.replace(firmaAdi, a+biletFiyati);
			System.out.println(firmaAdi + " Adlı firmadan 1 Bilet daha alınmıştır.."+biletler);
			
		}else {
			biletler.put(firmaAdi, biletFiyati);
			
			System.out.println(getAd() + " Adlı yolcu" + firmaAdi + " için bilet almıştır. Biletleriniz -->>" + biletler);
		}
		
	}

	@Override
	public void checkinYap() {
		if(isCheckin()) {
			System.out.println(getAd()+" zaten checkin yapılmıştır, uçağa binebilirsiniz..");
		}else {
			setCheckin(true);
			System.out.println("Checkin yapılmıştır iyi uçuşlar..");
		}
		
		
	}

	@Override
	public void ucagaBin() {

		if(isCheckin()) {
			System.out.println(getAd() +" " +getSoyad() + "-" + getKoltukNo() + " numaralı koltukta uçağa binebilirsiniz.");
		}else {
			System.out.println("Uçağa binmek için lütfen önce checkin yapın.");
		}
		
	}

}
