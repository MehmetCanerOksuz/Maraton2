package com.caneroksuz.kitapkiralama;

public class Kitap {
	
	private String isim;
	private int id;
	private EDurum durum;
	
	public Kitap(String isim, int id) {
		super();
		this.isim = isim;
		this.id = id;
		this.durum = EDurum.KUTUPHANEDE;
	}


	public String getIsim() {
		return isim;
	}

	public void setIsim(String isim) {
		this.isim = isim;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public EDurum getDurum() {
		return durum;
	}

	public void setDurum(EDurum durum) {
		this.durum = durum;
	}

	@Override
	public String toString() {
		return "Kitap [isim=" + isim + ", id=" + id + ", durum=" + durum + "]";
	}
	
	
	

}
