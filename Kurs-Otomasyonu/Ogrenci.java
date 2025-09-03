package odevv;
//Serife Nazli Unay
//23100011009
public class Ogrenci {
	private String ogrAd, ogrSoyad;
	private int ogrSinif, bolNo,ogrID;
	private static int ogr_sayisi = 0;// kulllanicidan alinmaz
    //statiğe ulaşmak icin kullanilan fonksiyonda statik olmali
	
	public Ogrenci(String ogrAd, String ogrSoyad, int ogrSinif, int bolNo) {
		this.ogrAd = ogrAd;
		this.ogrSoyad = ogrSoyad;
		this.ogrSinif = ogrSinif;
		this.bolNo = bolNo;//ogrencinin olusturuldugu bolumun no
		ogrID =++ogr_sayisi;
	}
	
	public String getOgrAd() {
		return ogrAd;
	}
	public void setOgrAd(String ogrAd) {
		this.ogrAd = ogrAd;
	}
	public String getOgrSoyad() {
		return ogrSoyad;
	}
	public void setOgrSoyad(String ogrSoyad) {
		this.ogrSoyad = ogrSoyad;
	}
	public int getOgrSinif() {
		return ogrSinif;
	}
	public void setOgrSinif(int ogrSinif) {
		this.ogrSinif = ogrSinif;
	}
	public int getBolNo() {
		return bolNo;
	}
	public void setBolNo(int bolNo) {
		this.bolNo = bolNo;
	}
	public int getOgrID() {
		return ogrID;
	}
	public void setOgrID(int ogrID) {
		this.ogrID = ogrID;
	}
	
}