package pentagon.flickrbean;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Description {
	public String _content;

	public String get_content() {
		if(_content.isEmpty() || _content  == null){
			return "This photo has no description";
		}
		Pattern p = Pattern.compile("<.*>");
		Matcher m = p.matcher(_content);
		
		if (m.find()) {
			return "This photo has no description";
		}
		if(_content.length() > 400){
			return _content.substring(0, 400)+"...";
		}
		return _content;
	}
}
