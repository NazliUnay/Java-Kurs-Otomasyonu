package odevv;
//Serife Nazli Unay
//23100011009
public class Ders {
	private int bolNo;
	private String dersAd;
	
	public Ders(int bolNo, String dersAd) {
		this.bolNo = bolNo;//dersin olusturuldugu bolumun numarasi
		this.dersAd = dersAd;
	}
	
	public int getBolNo() {
		return bolNo;
	}
	public void setBolNo(int bolNo) {
		this.bolNo = bolNo;
	}
	public String getDersAd() {
		return dersAd;
	}
	public void setDersAd(String dersAd) {
		this.dersAd = dersAd;
	}
	
}
