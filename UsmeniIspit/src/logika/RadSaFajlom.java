package logika;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RadSaFajlom {
	
	public static List<Pitanje> ucitavanjePitanja() throws IOException {
		 List<Pitanje> pitanja = new ArrayList<>();
	        
	        BufferedReader inFile = new BufferedReader(new FileReader("src\\dodatniResursi\\IspitnaPitanja.txt"));	       
	        try {
	        	String linija;
	        	int grupa=1;
				while((linija = inFile.readLine())!=null) {
					String tmp = linija.substring(0, grupa);
					int brojPitanja = Integer.parseInt(tmp);
					String pitanje = linija.substring(3);
					
					Pitanje p = new Pitanje(grupa, brojPitanja, pitanje);
					pitanja.add(p);        	
					
					if(brojPitanja == 9)
						grupa = 2;
					
				}
			} catch (NumberFormatException | IOException ex) {
				System.out.println("Nije uspelo ucitavanje pitanja");
				ex.printStackTrace();
			}finally{
				if(inFile!=null)
					inFile.close();
			}
	        
	        return pitanja;
	}
	
	public static List<Student> ucitavanjeStudenata() throws IOException{
		List<Student> studenti = new ArrayList<>();
		BufferedReader csvReader = new BufferedReader(new FileReader("src\\dodatniResursi\\MIS.csv"));
		csvReader.readLine();
		try {
        	String linija;
			while((linija = csvReader.readLine())!=null) {
				String[] tmp = linija.split(",");
				int bodovi = Integer.parseInt(tmp[3]);
				int ocena = Integer.parseInt(tmp[4]);
				
				Student s = new Student(tmp[0], tmp[1], tmp[2], bodovi, ocena);
				studenti.add(s);        	
			}
		} catch (NumberFormatException | IOException ex) {
			System.out.println("Nije uspelo ucitavanje studenata");
			ex.printStackTrace();
		}finally{
			if(csvReader!=null)
				csvReader.close();
		}
		
		return studenti;
	}
}