package com.caneroksuz.ucakbileti;

import java.util.HashMap;
import java.util.Map;



public class BusinessYolcu extends Yolcu{

	
	private final int BUSINNESFIYAT=200;
	private final int BUSINNESVIPFIYAT=150;
	private boolean VıpMı;
	
	
	private Map<EFirmaAdi, Integer> biletler= new HashMap<>();



	public BusinessYolcu(long id, String ad, String soyad, boolean vıpMı) {
		super(id, ad, soyad);
		this.VıpMı = vıpMı;
		
	}
	
	

	public boolean isVıpMı() {
		return VıpMı;
	}



	public void setVıpMı(boolean vıpMı) {
		VıpMı = vıpMı;
	}



	public Map<EFirmaAdi, Integer> getBiletler() {
		return biletler;
	}



	public void setBiletler(Map<EFirmaAdi, Integer> biletler) {
		this.biletler = biletler;
	}
	

	public int getBUSINNESFIYAT() {
		return BUSINNESFIYAT;
	}



	public int getBUSINNESVIPFIYAT() {
		return BUSINNESVIPFIYAT;
	}




	@Override
	public String toString() {
		return "BusinessYolcu [BUSINNESFIYAT=" + BUSINNESFIYAT + ", BUSINNESVIPFIYAT=" + BUSINNESVIPFIYAT + ", VıpMı="
				+ VıpMı + ", biletler=" + biletler + ", getId()=" + getId() + ", getAd()=" + getAd() + ", getSoyad()="
				+ getSoyad() + ", getKoltukNo()=" + getKoltukNo() + ", isCheckin()=" + isCheckin() + "]";
	}



	@Override
	public void yolcuBilgileriniGetir() {

		System.out.println("Business Yolcusu " + getAd() + " Biletleri : " +getBiletler());
		
	}

	@Override
	public void biletAl(EFirmaAdi firmaAdi) {
		
		int biletFiyati;
		if(VıpMı) {
			biletFiyati =getBASEFIYAT()+BUSINNESFIYAT+BUSINNESVIPFIYAT;
			biletler.put(firmaAdi, biletFiyati);
			System.out.println(getAd() + " Adlı yolcu" + firmaAdi + " için VIP bilet almıştır. Biletleriniz -->>" + biletler);
		}else {
			biletFiyati = getBASEFIYAT()+BUSINNESFIYAT;
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
