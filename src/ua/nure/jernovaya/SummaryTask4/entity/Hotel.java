package ua.nure.jernovaya.SummaryTask4.entity;
/**
 * 
 * @author Elmira Jernovaya.
 *
 */
public class Hotel {
	private int id;
	private String name;
	private String rate;
	private Nutrition nut;
	private String country;
	private String city;
	private String description;
	private String photosPath;

	public Hotel() {

	}

	/**
	 * @param name
	 * @param rate
	 * @param nut
	 * @param country
	 * @param city
	 * @param description
	 */
	public Hotel(String name, String rate, Nutrition nut, String country, String city, String description) {
		super();
		setName(name);
		setRate(rate);
		setNut(nut);
		setCountry(country);
		setCity(city);
		setDescription(description);
	}

	/**
	 * @return the id
	 */
	public final int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public final void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public final String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public final void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the rate
	 */
	public final String getRate() {
		return rate;
	}

	/**
	 * @param rate
	 *            the rate to set
	 */
	public final void setRate(String rate) {
		this.rate = rate;
	}

	/**
	 * @return the nut
	 */
	public final Nutrition getNut() {
		return nut;
	}

	/**
	 * @param nut
	 *            the nut to set
	 */
	public final void setNut(Nutrition nut) {
		this.nut = nut;
	}

	/**
	 * @return the country
	 */
	public final String getCountry() {
		return country;
	}

	/**
	 * @param country
	 *            the country to set
	 */
	public final void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return the city
	 */
	public final String getCity() {
		return city;
	}

	/**
	 * @param city
	 *            the city to set
	 */
	public final void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the description
	 */
	public final String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public final void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the photosPath
	 */
	public final String getPhotosPath() {
		return photosPath;
	}

	/**
	 * @param photosPath
	 *            the photosPath to set
	 */
	public final void setPhotosPath(String photosPath) {
		this.photosPath = photosPath;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((nut == null) ? 0 : nut.hashCode());
		result = prime * result + ((photosPath == null) ? 0 : photosPath.hashCode());
		result = prime * result + ((rate == null) ? 0 : rate.hashCode());
		return result;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hotel other = (Hotel) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (nut != other.nut)
			return false;
		if (photosPath == null) {
			if (other.photosPath != null)
				return false;
		} else if (!photosPath.equals(other.photosPath))
			return false;
		if (rate == null) {
			if (other.rate != null)
				return false;
		} else if (!rate.equals(other.rate))
			return false;
		return true;
	}

}
