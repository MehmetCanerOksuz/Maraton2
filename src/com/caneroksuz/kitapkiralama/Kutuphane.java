package com.caneroksuz.kitapkiralama;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Kutuphane implements IKutuphane {

	private static List<Kitap> kitaplar = new ArrayList<>();
	private static List<Musteri> musteriler = new ArrayList();
	private static List<Kasiyer> kasiyerler = new ArrayList();
	private static List<Kiralama> kiralamalar = new ArrayList();
	
	

	public Kutuphane() {
	}

	public static <T> void listeyeEkle(List<T> list, T object) {
		list.add(object);
	}

	public void musteriOlustur() {
		Musteri musteri1 = new Musteri(1, "Caner Oksuz");
		Musteri musteri2 = new Musteri(2, "Omer Oksuz");
		Musteri musteri3 = new Musteri(3, "Ender Oksuz");
		Musteri musteri4 = new Musteri(4, "Enes Oksuz");

		listeyeEkle(musteriler, musteri1);
		listeyeEkle(musteriler, musteri2);
		listeyeEkle(musteriler, musteri3);
		listeyeEkle(musteriler, musteri4);

	}

	public void kasiyerOlustur() {
		Kasiyer kasiyer1 = new Kasiyer(5, "Aslı Oksuz", 20000);
		Kasiyer kasiyer2 = new Kasiyer(6, "Mehmet Oksuz", 20000);

		listeyeEkle(kasiyerler, kasiyer1);
		listeyeEkle(kasiyerler, kasiyer2);
	}

	public static void kitapOlustur() {

		listeyeEkle(kitaplar, new Kitap("Esekarısı Fabrikası", 1));
		listeyeEkle(kitaplar, new Kitap("Suç ve Ceza", 2));
		listeyeEkle(kitaplar, new Kitap("Sefiller", 3));
		listeyeEkle(kitaplar, new Kitap("Vadideki Zambak", 4));
		listeyeEkle(kitaplar, new Kitap("Notre Dame'ın Kamburu", 5));
		listeyeEkle(kitaplar, new Kitap("Aşk ve Gurur", 6));
		listeyeEkle(kitaplar, new Kitap("İlahi Komedya", 7));
		listeyeEkle(kitaplar, new Kitap("Don Kişot", 8));
		listeyeEkle(kitaplar, new Kitap("Babalar ve Oğullar", 9));
		listeyeEkle(kitaplar, new Kitap("Bülbülü Öldürmek", 10));
	}

	public void kiralamaOlustur() {
		Kiralama kiralama1 = new Kiralama(1, kasiyerler.get(0), kitaplar.get(0), musteriler.get(0));
		kitaplar.get(0).setDurum(EDurum.KIRADA);
		Kiralama kiralama2 = new Kiralama(2, kasiyerler.get(0), kitaplar.get(1), musteriler.get(0));
		kitaplar.get(1).setDurum(EDurum.KIRADA);
		Kiralama kiralama3 = new Kiralama(3, kasiyerler.get(1), kitaplar.get(2), musteriler.get(1));
		kitaplar.get(2).setDurum(EDurum.KIRADA);
		Kiralama kiralama4 = new Kiralama(4, kasiyerler.get(1), kitaplar.get(3), musteriler.get(2));
		kitaplar.get(3).setDurum(EDurum.KIRADA);
		Kiralama kiralama5 = new Kiralama(5, kasiyerler.get(1), kitaplar.get(4), musteriler.get(3));
		kitaplar.get(4).setDurum(EDurum.KIRADA);
		Kiralama kiralama6 = new Kiralama(6, kasiyerler.get(0), kitaplar.get(5), musteriler.get(3));
		kitaplar.get(5).setDurum(EDurum.KIRADA);
		listeyeEkle(kiralamalar, kiralama1);
		listeyeEkle(kiralamalar, kiralama2);
		listeyeEkle(kiralamalar, kiralama3);
		listeyeEkle(kiralamalar, kiralama4);
		listeyeEkle(kiralamalar, kiralama5);
		listeyeEkle(kiralamalar, kiralama6);
	}

	@Override
	public boolean kiralamaYap() throws KutuphaneException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Lütfen müsteri id nizi giriniz");
		int musteriId = Integer.parseInt(scanner.nextLine());
		Musteri musteri = musteriler.get(musteriId - 1);
		System.out.println("Lütfen Kasiyer id nizi giriniz");
		int kasiyerId = Integer.parseInt(scanner.nextLine());
		Kasiyer kasiyer = kasiyerler.get(kasiyerId - 1);
		System.out.println("==== Kirada Olmayan Kitaplar ====");
		kitaplar.stream().filter((k) -> {
			return k.getDurum().equals(EDurum.KUTUPHANEDE);
		}).forEach((x) -> {
			System.out.println(x.getId() + "-" + x.getIsim());
		});
		System.out.println("Lütfen bir secim yapınız");
		int kitapId = Integer.parseInt(scanner.nextLine());
		Kitap kitap = kitaplar.get(kitapId - 1);
		if (kitap.getDurum().equals(EDurum.KIRADA)) {
			throw new KutuphaneException("Bu Kitap zaten Kiradadır -->>  kiralama işlemi başarısız");
		} else {
			Kiralama kiralama = new Kiralama(kiralamalar.size() + 1, kasiyer, kitap, musteri);
			kiralamalar.add(kiralama);
			System.out.println("Kiralama başarılı");
			return true;
		}
	}

	@Override
	public Kitap kitapAra() throws KutuphaneException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Lütfen  kitap ismi giriniz");
		String isim = scanner.nextLine();
		Optional<Kitap> kitap = kitaplar.stream().filter((k) -> {
			return k.getIsim().equalsIgnoreCase(isim);
		}).findFirst();
		if (kitap.isEmpty()) {
			throw new KutuphaneException("Böyle bir kitap bulunamadı");
		} else {
			return kitap.get();
		}
	}

	@Override
	public Musteri musteriAra() throws KutuphaneException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Lütfen  musteri ismi giriniz");
		String isim = scanner.nextLine();
		Optional<Musteri> musteri = musteriler.stream().filter((m) -> {
			return m.getIsim().equalsIgnoreCase(isim);
		}).findFirst();
		if (musteri.isEmpty()) {
			throw new KutuphaneException("Boyle bir müşteri bulunamadı");
		} else {
			return musteri.get();
		}
	}
	@Override
	public List<Kitap> kiralananKitaplar() throws KutuphaneException {
		List<Kitap> kiralananKitaplar = kitaplar.stream().filter((k) -> {
			return k.getDurum().equals(EDurum.KIRADA);
		}).collect(Collectors.toList());
		if (kiralananKitaplar.isEmpty()) {
			throw new KutuphaneException("Suanda kirada kitap bulunamamaktadır");
		} else {
			return kiralananKitaplar;
		}
	}


	public Musteri idVerilenKitabiSonKiralayan(int kitapId) throws KutuphaneException {
		List<Kiralama> kiralama = kiralamalar.stream().filter((k) -> {
			return k.getKitap().getId() == kitapId;
		}).collect(Collectors.toList());
		Musteri musteri = null;

		try {
			musteri = ((Kiralama) kiralama.get(kiralama.size() - 1)).getMusteri();
			return musteri;
		} catch (Exception var5) {
			throw new KutuphaneException("Bu kitap şuana kadar kiralanmamıştır..");
		}
	}

	public List<Musteri> kitabıDahaOnceKiralayanlar(String kitapAdı){
		List<Musteri> musteriList =kiralamalar.stream().filter((k) -> {
			return k.getKitap().getIsim().equalsIgnoreCase(kitapAdı);
		}).map((x) -> {
			return x.getMusteri();
		}).collect(Collectors.toList());
		return musteriList;
	}

	public List<Musteri> ahmIleBaslayanMusteriler(){
		List<Musteri> musteriList =musteriler.stream().filter((x) -> {
			return x.getIsim().startsWith("Ahm");
		}).collect(Collectors.toList());

		return musteriList;
	}

	public List<Kitap> idVerilenMusterininKiraladıgı(int musteriId){
		return kiralamalar.stream().filter((k) -> {
			return k.getMusteri().getId() == musteriId;
		}).map((x) -> {
			return x.getKitap();
		}).collect(Collectors.toList());
	}

	public static void main(String[] args) {
		Kutuphane kutuphane = new Kutuphane();
		kutuphane.musteriOlustur();
		kutuphane.kasiyerOlustur();
		kitapOlustur();
		kutuphane.kiralamaOlustur();

		try {
			System.out.println(kutuphane.kiralamaYap());
			System.out.println(kutuphane.kitapAra());
			System.out.println(kutuphane.musteriAra());
			System.out.println(kutuphane.kiralananKitaplar());
			System.out.println(kutuphane.idVerilenKitabiSonKiralayan(2));


		} catch (KutuphaneException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		System.out.println(kutuphane.kitabıDahaOnceKiralayanlar("dasd"));
		System.out.println(kutuphane.ahmIleBaslayanMusteriler());
		System.out.println(kutuphane.idVerilenMusterininKiraladıgı(1));

		

	}
}
