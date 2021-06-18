		import java.util.HashMap;
import java.util.Set;
public class hashmatique {

	public static void main(String[] args) {

		HashMap<String, String> trackList  = new HashMap<String, String>();
		
		trackList.put("cancion 1", "letra cancion 1");
		trackList.put("cancion 2", "letra cancion 2");
		trackList.put("cancion 3", "letra cancion 3");
        
        // get the keys by using the keySet method
        Set<String> keys = trackList.keySet();
        for(String key : keys) {
            System.out.println(key +": " +  trackList.get(key));    
        }
	}

}
