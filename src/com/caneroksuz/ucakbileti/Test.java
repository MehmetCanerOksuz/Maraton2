package com.caneroksuz.ucakbileti;


public class Test {
	
	public static void main(String[] args) {
		
		Yolcu yolcu1 = new BusinessYolcu(5, "Caner", "Oksuz", false);
		Yolcu yolcu2 = new EkonomiYolcu(5, "Aslı", "Oksuz");
		Yolcu yolcu3 = new BusinessYolcu(5, "Mehmet", "Oksuz", true);
		
		System.out.println("*****Businnes VIP Yolcu*****");
		yolcu3.biletAl(EFirmaAdi.ADJ);
		yolcu3.biletAl(EFirmaAdi.THY);
		System.out.println("***");
		yolcu3.ucagaBin();
		yolcu3.ucagaBin();
		yolcu3.checkinYap();
		yolcu3.checkinYap();
		yolcu3.ucagaBin();
		yolcu3.yolcuBilgileriniGetir();
		
		System.out.println("*****Ekonomi Yolcu*******");
		yolcu2.biletAl(EFirmaAdi.ADJ);
		yolcu2.biletAl(EFirmaAdi.THY);
		yolcu2.biletAl(EFirmaAdi.THY);
		yolcu2.biletAl(EFirmaAdi.THY);
		System.out.println("*****");
		yolcu2.ucagaBin();
		yolcu2.ucagaBin();
		yolcu2.checkinYap();
		yolcu2.checkinYap();
		yolcu2.ucagaBin();
		yolcu2.yolcuBilgileriniGetir();
	}

}
