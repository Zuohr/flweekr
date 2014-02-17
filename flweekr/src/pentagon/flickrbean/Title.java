package pentagon.flickrbean;

public class Title {
	public String _content;

	public String get_content() {
		if(_content.length() > 40){
			return _content.substring(0, 35)+"...";
		}
		return _content;
	}
}
