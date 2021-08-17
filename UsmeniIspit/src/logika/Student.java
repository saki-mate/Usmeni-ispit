package logika;

import java.io.IOException;
import java.util.List;

public class Student {
	String bri;
	String ime;
	String prezime;
	int bodovi;
	int ocena;
	
	public Student(String bri, String ime, String prezime, int bodovi, int ocena) {
		this.bri = bri;
		this.ime = ime;
		this.prezime = prezime;
		this.bodovi = bodovi;
		this.ocena = ocena;
	}
	public String getBri() {
		return bri;
	}
	public void setBri(String bri) {
		this.bri = bri;
	}
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public String getPrezime() {
		return prezime;
	}
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	public int getBodovi() {
		return bodovi;
	}
	public void setBodovi(int bodovi) {
		this.bodovi = bodovi;
	}
	public int getOcena() {
		return ocena;
	}
	public void setOcena(int ocena) {
		this.ocena = ocena;
	}
	@Override
	public String toString() {
		return "Student [bri=" + bri + ", ime=" + ime + ", prezime=" + prezime + ", bodovi=" + bodovi + ", ocena="
				+ ocena + "]";
	}
	public static List<Student> studenti = getStudenti();
	
	public static List<Student> getStudenti(){
		try {
			studenti = RadSaFajlom.ucitavanjeStudenata();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return studenti;
	}
	
	public static Student getStudent(String bri) {
		
		for(Student s: studenti)
			if(s.getBri().equals(bri))
				return s;
		return null;
	}
}
