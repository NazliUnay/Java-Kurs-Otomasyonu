package odevv;

import java.util.Scanner;

//Serife Nazli Unay
//23100011009

public class Anasayfa {
	public static void main(String[] args) {
		System.out.println("===============================================");
		System.out.println("=  SPOR AKADEMİSİ OTOMASYONUUNA HOS GELDINIZ  =");
		System.out.println("===============================================");

		Scanner scann = new Scanner(System.in);
		int ogrenci_sys = 0, teorik_sys = 0, pratik_sys = 0, ogr_sinif;
		System.out.print(">>>>>Bolum sayisi giriniz:");
		int bolum_sys = scann.nextInt();

		Bolum[] bolum = new Bolum[bolum_sys];// bolum dizisi olustur
		for (int i = 0; i < bolum_sys; i++) {
			scann.nextLine();
			System.out.println("\n===========================================");
			System.out.print("------------->" + (i + 1) + ".bolumun no giriniz:");
			int bolum_no = scann.nextInt();
			System.out.print("------------->" + (i + 1) + ".bolumun adini giriniz:");
			String bolum_adi = scann.next();

			bolum[i] = new Bolum(bolum_no, bolum_adi);// bolum dizisinin i.elemanı doldur(bolum classini kullanarak)

			System.out.print("....." + (i + 1) + ".bolumun ogrenci sayisini giriniz:");
			ogrenci_sys = scann.nextInt();

			bolum[i].ogrenciler = new Ogrenci[ogrenci_sys];// bolum dizisinin i.elemaninin ogrenci dizisini olustur

			for (int j = 0; j < ogrenci_sys; j++) {
				System.out.print("=>" + (j + 1) + ".ogrencinin adi giriniz:");
				String ogr_adi = scann.next();

				System.out.print("=>" + (j + 1) + ".ogrencinin soyadi giriniz:");
				String ogr_soyadi = scann.next();

				while (true) {
					scann.nextLine();
					System.out.print("=>" + (j + 1) + ".ogrencinin sinifini giriniz:");
					ogr_sinif = scann.nextInt();
					if (ogr_sinif <= 4 && ogr_sinif > 0) {
						break;
					}
					System.out.println("\n!!!lutfen 1,2,3 ve 4 degerlerini giriniz!!!");
					// sinif degerlerimiz 1.,2.,3.ve 4.sınıf olabilir(lisans)
				}
				bolum[i].ogrenciler[j] = new Ogrenci(ogr_adi, ogr_soyadi, ogr_sinif, bolum[i].getBolNo());
				// bolum dizisinin i.elemaninin ogrenci dizisini doldur(ogrenciler clasi
				// kullanarak)
				System.out.println("...........................................");

			}

			System.out.print("....." + (i + 1) + ".bolumun teorik ders sayisini giriniz:");
			teorik_sys = scann.nextInt();
			bolum[i].teorikdersler = new TeorikDers[teorik_sys];// bolum dizisinin i.elemaninin teorik dizisini olustur
			int ders_kredi = 0;
			for (int j = 0; j < teorik_sys; j++) {
				System.out.print("=>Ders adi giriniz:");
				String ders_adi = scann.next();

				System.out.print("=>Ders kredi giriniz:");
				ders_kredi = scann.nextInt();

				bolum[i].teorikdersler[j] = new TeorikDers(bolum[i].getBolNo(), ders_adi, ders_kredi);// bolum dizisinin
				// i.elemaninin teorikdersler dizisini doldur (TeorikDers clasi kullanarak)
				System.out.println("...........................................");
			}

			System.out.print("....." + (i + 1) + ".bolumun pratik ders sayisini giriniz:");
			pratik_sys = scann.nextInt();
			bolum[i].pratikdersler = new PratikDers[pratik_sys];// bolum dizisinin i.elemaninin pratik dizisini olustur
			for (int j = 0; j < pratik_sys; j++) {
				System.out.print("=>Ders adi giriniz:");
				String ders_adi = scann.next();

				System.out.print("=>Ders kredi giriniz:");
				ders_kredi = scann.nextInt();

				bolum[i].pratikdersler[j] = new PratikDers(bolum[i].getBolNo(), ders_adi, ders_kredi);
				// bolum dizisinin i.elemaninin pratikdersler dizisini doldur (PratikDers
				// classini kullanarak)
				System.out.println("...........................................");
			}
		}
		int kontrol = 0;
		while (kontrol != 1) {
			menu();
			kontrol = 0;
			System.out.print("\n=>LUTFEN YAPMAK ISTEDIGINIZ ISLEMI GIRINIZ:");
			int islem = scann.nextInt();
			switch (islem) {
			case 1:
				tumListele(bolum, bolum_sys);
				break;
			case 2:
				ogrenciListele(bolum, bolum_sys);
				break;
			case 3:
				teorikListele(bolum, bolum_sys);
				break;
			case 4:
				pratikListele(bolum, bolum_sys);
				break;
			case 5:
				aramaYap(bolum, bolum_sys);
				break;
			case 6:
				System.out.print("CIKIS YAPILIYOR");
				kontrol = 0;
				break;
			default:
				System.out.println("HATALI TERCİH");
				break;
			}
		}
	}

	public static void menu() { // menu
		System.out.println("\n=================================================");
		System.out.println("==\t\tMENU                           ==");
		System.out.println("==\t1.Tum Bolum Bilgilerini Listele        ==");
		System.out.println("==\t2.Ogrencileri Listele                  ==");
		System.out.println("==\t3.Teorik Dersleri Listele              ==");
		System.out.println("==\t4.Pratik Dersleri Listele              ==");
		System.out.println("==\t5.Arama Yap                            ==");
		System.out.println("==\t6.Cikis                                ==");
		System.out.println("=================================================");
	}

	public static void tumListele(Bolum[] bolum, int bolum_sys) {
		System.out.println("\n....TUM BOLUMUN OGRENCILERI LISTELENIYOR");

		for (int i = 0; i < bolum_sys; i++) {
			System.out.println("===================================================");
			System.out.println("                BOLUM NO:" + bolum[i].getBolNo());
			System.out.println("                BOLUM ADI:" + bolum[i].getBolAd());
			System.out.println("...........................................");
			System.out.println("OGRENCİLER\n");
			for (int j = 0; j < bolum[i].ogrenciler.length; j++) {
				System.out.println("----------------------------");
				System.out.println((j + 1) + ".Ogrencinin bilgileri:");
				System.out.println("-->ID:" + bolum[i].ogrenciler[j].getOgrID());
				System.out.println("-->Ad-Soyad:" + bolum[i].ogrenciler[j].getOgrAd() + " "
						+ bolum[i].ogrenciler[j].getOgrSoyad());
				System.out.println("-->Sınıf:" + bolum[i].ogrenciler[j].getOgrSinif());
			}
			System.out.println("...........................................");
			System.out.println("TEORİK DERSLER\n");
			for (int j = 0; j < bolum[i].teorikdersler.length; j++) {
				System.out.println("----------------------------");
				System.out.println((j + 1) + ".Teorik dersin bilgileri:");
				System.out.println("-->Ders ID:" + bolum[i].teorikdersler[j].getDersID());
				System.out.println("-->Ders ad:" + bolum[i].teorikdersler[j].getDersAd());
				System.out.println("-->Ders kredi:" + bolum[i].teorikdersler[j].getDersKredi());
			}
			System.out.println("...........................................");
			System.out.println("PRATİK DERSLER\n");
			for (int j = 0; j < bolum[i].pratikdersler.length; j++) {
				System.out.println("----------------------------");
				System.out.println((j + 1) + ".Pratik dersin bilgileri:");
				System.out.println("-->Ders ID:" + bolum[i].pratikdersler[j].getDersID());
				System.out.println("-->Ders ad:" + bolum[i].pratikdersler[j].getDersAd());
				System.out.println("-->Ders kredi:" + bolum[i].pratikdersler[j].getDersKredi());
			}

		}
	}

	public static void ogrenciListele(Bolum[] bolum, int bolum_sys) {
		System.out.println("\n\n....OGRENCILERE GORE LISTELENIYOR");
		System.out.println("\nTUM BOLUMDEKI OGRENCİLER");
		for (int t = 1; t <= 4; t++) {
			System.out.println("===================================================");
			System.out.println(t + ".SINIF OGRENCILER");
			for (int i = 0; i < bolum_sys; i++) {
				for (int j = 0; j < bolum[i].ogrenciler.length; j++) {
					if (bolum[i].ogrenciler[j].getOgrSinif() == t) {
						System.out.println("----------------------------");
						System.out.println("-->ID:" + bolum[i].ogrenciler[j].getOgrID());
						System.out.println("-->Ad-Soyad:" + bolum[i].ogrenciler[j].getOgrAd() + " "
								+ bolum[i].ogrenciler[j].getOgrSoyad());
						System.out.println("-->Sınıf:" + bolum[i].ogrenciler[j].getOgrSinif());
					}
				}
			}

		}
	}

	public static void teorikListele(Bolum[] bolum, int bolum_sys) {
		System.out.println("\nTUM BOLUMLERDEKI TEORIK DERSLER");
		int temp, en_buyuk = 0;
		for (int i = 0; i < bolum_sys; i++) { // en buyuk degeri bul
			for (int j = 0; j < bolum[i].teorikdersler.length; j++) {
				if (en_buyuk < bolum[i].teorikdersler[j].getDersKredi()) {
					en_buyuk = bolum[i].teorikdersler[j].getDersKredi();
				}
			}
		}
		for (int t = 1; t <= en_buyuk; t++) {
			temp = 0;
			for (int i = 0; i < bolum_sys; i++) {
				for (int j = 0; j < bolum[i].teorikdersler.length; j++) {
					if (temp == 0 && bolum[i].teorikdersler[j].getDersKredi() == t) { // bir kere yazmak icin
						System.out.println("===================================================");
						System.out.println(t + " KREDILIK DERSLER");
					}
					if (bolum[i].teorikdersler[j].getDersKredi() == t) {
						System.out.println("----------------------------");
						System.out.println("-->Ders ID:" + bolum[i].teorikdersler[j].getDersID());
						System.out.println("-->Ders ad:" + bolum[i].teorikdersler[j].getDersAd());
						System.out.println("-->Ders kredi:" + bolum[i].teorikdersler[j].getDersKredi());
						temp = 1;
					}
				}
			}
		}
	}

	public static void pratikListele(Bolum[] bolum, int bolum_sys) {
		System.out.println("\nTUM BOLUMLERDEKI PRATIK DERSLER");
		int temp, en_buyuk = 0;
		for (int i = 0; i < bolum_sys; i++) {
			for (int j = 0; j < bolum[i].pratikdersler.length; j++) {
				if (en_buyuk < bolum[i].pratikdersler[j].getDersKredi()) {
					en_buyuk = bolum[i].pratikdersler[j].getDersKredi();
				}
			}
		}
		for (int t = 1; t <= en_buyuk; t++) {
			temp = 0;
			for (int i = 0; i < bolum_sys; i++) {
				for (int j = 0; j < bolum[i].pratikdersler.length; j++) {
					if (temp == 0 && bolum[i].pratikdersler[j].getDersKredi() == t) {
						System.out.println("===================================================");
						System.out.println(t + " KREDILIK DERSLER");
					}
					if (bolum[i].pratikdersler[j].getDersKredi() == t) {
						System.out.println("----------------------------");
						System.out.println("-->Ders ID:" + bolum[i].pratikdersler[j].getDersID());
						System.out.println("-->Ders ad:" + bolum[i].pratikdersler[j].getDersAd());
						System.out.println("-->Ders kredi:" + bolum[i].pratikdersler[j].getDersKredi());
						temp = 1;
					}
				}
			}
		}
	}

	public static void aramaYap(Bolum[] bolum, int bolum_sys) {
		Scanner scann = new Scanner(System.in);
		System.out.println("\n\n....ARAMA YAPILIYOR");
		System.out.print("=>Kelime giriniz:");
		String kelime = scann.next();
		System.out.println("========================================");
		System.out.println("Ogrenci Arama");
		int kontrol = 0;
		for (int i = 0; i < bolum_sys; i++) {
			for (int j = 0; j < bolum[i].ogrenciler.length; j++) {
				if (bolum[i].ogrenciler[j].getOgrAd().equals(kelime)
						|| bolum[i].ogrenciler[j].getOgrSoyad().equals(kelime)) {
					System.out.println("----------------------------");
					System.out.println("-->Bolumu:" + bolum[i].ogrenciler[j].getBolNo());
					System.out.println("-->ID:" + bolum[i].ogrenciler[j].getOgrID());
					System.out.println("-->Ad-Soyad:" + bolum[i].ogrenciler[j].getOgrAd() + " "
							+ bolum[i].ogrenciler[j].getOgrSoyad());
					System.out.println("-->Sınıf:" + bolum[i].ogrenciler[j].getOgrSinif());
					kontrol = 1;
				}
			}
		}
		if (kontrol == 0) {
			System.out.println("----------------------------");
			System.out.println("!!!Bu isimde ogrenci bulunamadi");
		}
		kontrol = 0;
		System.out.println("========================================");
		System.out.println("Teorik Arama");
		for (int i = 0; i < bolum_sys; i++) {
			for (int j = 0; j < bolum[i].pratikdersler.length; j++) {
				if (bolum[i].pratikdersler[j].getDersAd().equals(kelime)) {
					System.out.println("----------------------------");
					System.out.println("-->Dersin bolumu:" + bolum[i].pratikdersler[j].getBolNo());
					System.out.println("-->Ders ID:" + bolum[i].pratikdersler[j].getDersID());
					System.out.println("-->Ders ad:" + bolum[i].pratikdersler[j].getDersAd());
					System.out.println("-->Ders kredi:" + bolum[i].pratikdersler[j].getDersKredi());
					kontrol = 1;
				}
			}
		}
		if (kontrol == 0) {
			System.out.println("----------------------------");
			System.out.println("!!!Bu isimde teorik ders bulunamadi");
		}
		kontrol = 0;
		System.out.println("========================================");
		System.out.println("Pratik Arama");
		for (int i = 0; i < bolum_sys; i++) {
			for (int j = 0; j < bolum[i].teorikdersler.length; j++) {
				if (bolum[i].teorikdersler[j].getDersAd().equals(kelime)) {
					System.out.println("----------------------------");
					System.out.println("-->Dersin bolumu:" + bolum[i].teorikdersler[j].getBolNo());
					System.out.println("-->Ders ID:" + bolum[i].teorikdersler[j].getDersID());
					System.out.println("-->Ders ad:" + bolum[i].teorikdersler[j].getDersAd());
					System.out.println("-->Ders kredi:" + bolum[i].teorikdersler[j].getDersKredi());
					kontrol = 1;
				}
			}
		}
		if (kontrol == 0) {
			System.out.println("----------------------------");
			System.out.println("!!!Bu isimde pratik ders bulunamadi");
		}
	}
}
