package pentagon.flickrbean;

public class Title {
	public String _content;

	public String get_content() {
		if(_content.length()>35){
			return _content.substring(0, 35)+"...";
		}
		return _content;
	}
}
