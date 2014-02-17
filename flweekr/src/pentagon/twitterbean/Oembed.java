package pentagon.twitterbean;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Oembed {
	private String html;

	public String getHtml() {
		return html;
	}

	public void setHtml(String html) {
		this.html = html;
	}

	public Oembed strip() {
		if (html != null) {
			Pattern p = Pattern.compile("<p>.*</a>");
			Matcher m = p.matcher(html);
			if (m.find()) {
				html = m.group();
			}
			return this;
		} else {
			return null;
		}
	}

}
