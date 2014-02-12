package pentagon.model;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class TestCh {
	public static void main(String[] args) throws UnsupportedEncodingException {
		String s = "~!@#$%^&*()_+{}|:\"<>?`1234567890-=[]\\;',./'汉字";
		System.out.println(s);
		String[] code = { "UTF-8", "ISO-8859-1", "US-ASCII" };
		for (String cd : code) {
			String s1 = URLEncoder.encode(s, cd);
			System.out.println(s1);
		}
	}
}
