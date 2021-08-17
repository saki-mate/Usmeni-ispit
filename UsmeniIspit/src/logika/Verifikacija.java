package logika;

	import java.io.IOException;
	import java.util.List;
	import java.util.regex.Matcher;
	import java.util.regex.Pattern;

	public class Verifikacija {
		
	    public static boolean verifikujPodatke(String bri) throws IOException {
	        List<Student> studenti = Student.getStudenti();

	        for(Student s: studenti) {
	        	if(s.getBri().equals(bri)) 
	        		return true;
	        }
	        return false;
	    }

	    public static boolean verifikujPredispitne(String bri) {
	    	Student s = Student.getStudent(bri);
	    	if(s.getBodovi()<40)
	    		return false;
	    	return true;
	    }
	    public static boolean verifikujIndeks(String string) {
	        String regexIndeks = "IT(?<brojIndeksa>[3-5][0-9]{2})\\/(?<godinaUpisa>(([0-1][0-9])|(2[0-1])))";
	        //String tekst = "IT305/20, IT324/19, iT415/18";
	        Pattern pattern = Pattern.compile(regexIndeks);
	        Matcher matcher = pattern.matcher(string);
	        return matcher.lookingAt();
	}
	}
