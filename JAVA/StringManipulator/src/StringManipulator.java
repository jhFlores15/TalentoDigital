
public class StringManipulator {
	
	public String trimAndConcat(String srtUno, String srtDos) {		
		return srtUno.trim().concat(srtDos.trim());
	}
	
	public int getIndexOrNull(String srt, char letter) {		
		return srt.indexOf(letter);
	}
	
	public int getIndexOrNull(String srtUno, String word) {		
		return srtUno.indexOf(word);
	}
	
	public String concatSubstring(String srtUno, int intUno, int intDos, String srtDos) {
		String a = Character.toString(srtUno.charAt(intUno));
		String b = Character.toString(srtUno.charAt(intDos));
		
		return a+b.concat(srtDos);
	}

}
