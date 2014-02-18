package pentagon.flickrbean;

public class Description {
	public String _content;

	public String get_content() {
		if(_content.length()>350){
			return _content.substring(0, 350)+"...";
		}
		return _content;
	}
}
