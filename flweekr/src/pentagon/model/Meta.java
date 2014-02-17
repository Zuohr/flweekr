package pentagon.model;

public class Meta {
	public static final String domain = "http://localhost:8080/flweekr/"; 
	
	public static String replaceSpecial(String text) {
		text = text.replace("+", "%20");
		text = text.replace("*", "%2A");
		text = text.replace("_", "%5F");
		text = text.replace(".", "%2E");
		text = text.replace("-", "%2D");
		return text;
	}
}
