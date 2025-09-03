package odevv;
//Serife Nazli Unay
//23100011009
public class TeorikDers extends Ders{//kalitim
	private int dersID,dersKredi;
    private String durum;
    private static int syc=0; 
    
	public TeorikDers(int bolNo, String dersAd,int dersKredi) {
		super(bolNo, dersAd);
		this.dersID = ++syc;
		this.dersKredi = dersKredi;
		this.durum = "Pratik";
	}
	
	public int getDersID() {
		return dersID;
	}
	public void setDersID(int dersID) {
		this.dersID = dersID;
	}
	public int getDersKredi() {
		return dersKredi;
	}
	public void setDersKredi(int dersKredi) {
		this.dersKredi = dersKredi;
	}
	public String getDurum() {
		return durum;
	}
	public void setDurum(String durum) {
		this.durum = durum;
	}

}
