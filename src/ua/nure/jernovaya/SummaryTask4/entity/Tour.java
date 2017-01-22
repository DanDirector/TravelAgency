/**
 * 
 */
package ua.nure.jernovaya.SummaryTask4.entity;

import java.sql.Date;

/**
 * @author Elmira Jernovaya.
 *
 */
public class Tour {
	private int id;
	private String imagePath;
	private Type type;
	private double price;
	private int personCount;
	private Hotel hotel;
	private boolean isHot;
	private Date departureDate;
	private int nights;
	private String departureCity;

	/**
	 * @param imagePath
	 * @param type
	 * @param price
	 * @param personCount
	 * @param hotel
	 * @param isHot
	 * @param departureDate
	 * @param nights
	 * @param departureCity
	 */
	public Tour(String imagePath, Type type, double price, int personCount, Hotel hotel, Date departureDate, int nights,
			String departureCity) {
		super();
		setImagePath(imagePath);
		setType(type);
		setPrice(price);
		setPersonCount(personCount);
		setHotel(hotel);
		setIsHot(1);
		setDepartureDate(departureDate);
		setNights(nights);
		setDepartureCity(departureCity);
	}

	/**
	 * the default constructor.
	 */
	public Tour() {
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
	 * @return the imagePath
	 */
	public final String getImagePath() {
		return imagePath;
	}

	/**
	 * @param imagePath
	 *            the imagePath to set
	 */
	public final void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	/**
	 * @return the type
	 */
	public final Type getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public final void setType(Type type) {
		this.type = type;
	}

	/**
	 * @return the price
	 */
	public final double getPrice() {
		return price;
	}

	/**
	 * @param price
	 *            the price to set
	 */
	public final void setPrice(double price) {
		this.price = price;
	}

	/**
	 * @return the personCount
	 */
	public final int getPersonCount() {
		return personCount;
	}

	/**
	 * @param personCount
	 *            the personCount to set
	 */
	public final void setPersonCount(int personCount) {
		this.personCount = personCount;
	}

	/**
	 * @return the hotel
	 */
	public final Hotel getHotel() {
		return hotel;
	}

	/**
	 * @param hotel
	 *            the hotel to set
	 */
	public final void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	/**
	 * @return the isHot
	 */
	public final boolean getIsHot() {
		return isHot;
	}

	/**
	 * @param isHot
	 *            the isHot to set
	 */
	public final void setIsHot(int isHot) {
		if (isHot == 0) {
			this.isHot = true;
		} else {
			this.isHot = false;
		}

	}

	/**
	 * @return the departureDate
	 */
	public final Date getDepartureDate() {
		return departureDate;
	}

	/**
	 * @param departureDate
	 *            the departureDate to set
	 */
	public final void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}

	/**
	 * @return the nights
	 */
	public final int getNights() {
		return nights;
	}

	/**
	 * @param nights
	 *            the nights to set
	 */
	public final void setNights(int nights) {
		this.nights = nights;
	}

	/**
	 * @return the departure_city
	 */
	public final String getDepartureCity() {
		return departureCity;
	}

	/**
	 * @param departure_city
	 *            the departure_city to set
	 */
	public final void setDepartureCity(String departure_city) {
		this.departureCity = departure_city;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((departureCity == null) ? 0 : departureCity.hashCode());
		result = prime * result + ((departureDate == null) ? 0 : departureDate.hashCode());
		result = prime * result + ((hotel == null) ? 0 : hotel.hashCode());
		result = prime * result + id;
		result = prime * result + ((imagePath == null) ? 0 : imagePath.hashCode());
		result = prime * result + (isHot ? 1231 : 1237);
		result = prime * result + nights;
		result = prime * result + personCount;
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	/*
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
		Tour other = (Tour) obj;
		if (departureCity == null) {
			if (other.departureCity != null)
				return false;
		} else if (!departureCity.equals(other.departureCity))
			return false;
		if (departureDate == null) {
			if (other.departureDate != null)
				return false;
		} else if (!departureDate.equals(other.departureDate))
			return false;
		if (hotel == null) {
			if (other.hotel != null)
				return false;
		} else if (!hotel.equals(other.hotel))
			return false;
		if (id != other.id)
			return false;
		if (imagePath == null) {
			if (other.imagePath != null)
				return false;
		} else if (!imagePath.equals(other.imagePath))
			return false;
		if (isHot != other.isHot)
			return false;
		if (nights != other.nights)
			return false;
		if (personCount != other.personCount)
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (type != other.type)
			return false;
		return true;
	}

}
