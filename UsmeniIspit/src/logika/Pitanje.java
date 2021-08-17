package logika;

import java.io.IOException;
import java.util.List;
import java.util.Random;

public class Pitanje {
		int grupa;
		int redniBroj;
		String naziv;
				
		public Pitanje(int grupa, int redniBroj, String naziv) {
			super();
			this.grupa = grupa;
			this.redniBroj = redniBroj;
			this.naziv = naziv;
		}

		public int getGrupa() {
			return grupa;
		}

		public void setGrupa(int grupa) {
			this.grupa = grupa;
		}

		public int getRedniBroj() {
			return redniBroj;
		}

		public void setRedniBroj(int redniBroj) {
			this.redniBroj = redniBroj;
		}

		public String getNaziv() {
			return naziv;
		}

		public void setNaziv(String naziv) {
			this.naziv = naziv;
		}

		@Override
		public String toString() {
			return redniBroj + "."+ naziv;
		}
		
		public static List<Pitanje> getPitanja() throws IOException{
			List<Pitanje> pitanja = RadSaFajlom.ucitavanjePitanja();
			return pitanja;
		}
		
		public static Pitanje izvuciPitanje(int grupa) {
			try {
				List<Pitanje> pitanja = getPitanja();
				
				int broj=0;
				Random random = new Random();
				
				if(grupa == 1) 
					broj = random.nextInt(11)+1;
				else 
					broj = random.nextInt(10)+12;
				
				return pitanja.get(broj-1);

			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
			
		}
		
	}
