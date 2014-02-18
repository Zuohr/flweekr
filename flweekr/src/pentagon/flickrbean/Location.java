package pentagon.flickrbean;

public class Location {
	public String latitude;
	public String longitude;
	public Country country;
	public Region region;
	public Locality locality;
	public Locality getLocality() {
		return locality;
	}
	public Region getRegion() {
		return region;
	}
	public Country getCountry() {
		return country;
	}
	public String getLatitude() {
		return latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	
}
