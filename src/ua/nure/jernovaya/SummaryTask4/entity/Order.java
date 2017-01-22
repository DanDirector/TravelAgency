package ua.nure.jernovaya.SummaryTask4.entity;
/**
 * 
 * @author Elmira Jernovaya.
 *
 */
public class Order {
	private int id;
	private Tour tour;
	private User user;
	private Status status;
	private double discount;
	private double discountStep;
	private double maxDiscount;

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
	 * @return the tour
	 */
	public final Tour getTour() {
		return tour;
	}

	/**
	 * @param tour
	 *            the tour to set
	 */
	public final void setTour(Tour tour) {
		this.tour = tour;
	}

	/**
	 * @return the user
	 */
	public final User getUser() {
		return user;
	}

	/**
	 * @param user
	 *            the user to set
	 */
	public final void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the status
	 */
	public final Status getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public final void setStatus(Status status) {
		this.status = status;
	}

	/**
	 * @return the discount
	 */
	public final double getDiscount() {
		return discount;
	}

	/**
	 * @param discount
	 *            the discount to set
	 */
	public final void setDiscount(double discount) {
		this.discount = discount;
	}

	/**
	 * @return the discountStep
	 */
	public final double getDiscountStep() {
		return discountStep;
	}

	/**
	 * @param discountStep the discountStep to set
	 */
	public final void setDiscountStep(double discountStep) {
		this.discountStep = discountStep;
	}

	/**
	 * @return the maxDiscount
	 */
	public final double getMaxDiscount() {
		return maxDiscount;
	}

	/**
	 * @param maxDiscount the maxDiscount to set
	 */
	public final void setMaxDiscount(double maxDiscount) {
		this.maxDiscount = maxDiscount;
	}
	

}
