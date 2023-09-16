package com.caneroksuz.urun;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UrunManager {
	
	public static void main(String[] args) {
		
		List<Urun> urunList = new ArrayList<>();
		
		Urun urun1 = new Urun("Elma",20);
		Urun urun2 = new Urun("Telefon",40000);
		Urun urun3 = new Urun("Bilgisayar",35000);
		Urun urun4 = new Urun("Kulaklık",25000);
		Urun urun5 = new Urun("Ayakkabı",2650);
		Urun urun6 = new Urun("Gözlük",5750);
		
		urunList.add(urun1);
		urunList.add(urun2);
		urunList.add(urun3);
		urunList.add(urun4);
		urunList.add(urun5);
		urunList.add(urun6);
		
		
		Map<String, Double> urunMap = new HashMap<>();
		
		
		urunMap = urunList.stream().filter(u->u.getFiyat()<20000 && u.getFiyat()>1000)
				.collect(Collectors.toMap(x->x.getAd(), y->y.getFiyat()));
		
		System.out.println("Fiyatı 20000 den düşük ve 1000 den büyük olaran ürünler ve fiyatları ==>>");
		urunMap.forEach((k,v) -> System.out.println(k+ "'nın Fiyatı ==" + v));
	}


	
	
}
