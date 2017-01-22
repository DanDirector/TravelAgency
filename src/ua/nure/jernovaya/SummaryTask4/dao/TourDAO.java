package ua.nure.jernovaya.SummaryTask4.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import ua.nure.jernovaya.SummaryTask4.entity.Tour;
import ua.nure.jernovaya.SummaryTask4.entity.Type;
import ua.nure.jernovaya.SummaryTask4.jdbc.ConnectionProvider;
import ua.nure.jernovaya.SummaryTask4.jdbc.Sqls;
/**
 * 
 * @author Elmira Jernovaya.
 *
 */
public class TourDAO implements DAO<Tour> {
	private HotelDAO hotelDAO = new HotelDAO();
	/**
	 * Logger.
	 */
	final static Logger LOGGER = Logger.getLogger(TourDAO.class);
	/**
	 * (non-Javadoc)
	 * 
	 * @see ua.nure.jernovaya.SummaryTask4.dao.DAO#create(ua.nure.jernovaya.SummaryTask4.entity.Tour)
	 */
	@Override
	public boolean create(Tour tour) {
		boolean done = false;
		try (Connection con = ConnectionProvider.getConnection();
				PreparedStatement prs = con.prepareStatement(Sqls.CREATE_TOUR)) {
			prs.setString(1, tour.getImagePath());
			prs.setString(2, tour.getType().toString().toLowerCase());
			prs.setDouble(3, tour.getPrice());
			prs.setInt(4, tour.getPersonCount());
			prs.setInt(5, tour.getHotel().getId());
			prs.setInt(6, 1);
			prs.setDate(7, tour.getDepartureDate());
			prs.setString(9, tour.getDepartureCity());
			prs.setInt(8, tour.getNights());
			done = (prs.executeUpdate() == 1);
		} catch (SQLException e) {
			LOGGER.error(e.getMessage());
		}

		return done;
	} 
	/**
	 * (non-Javadoc)
	 * 
	 * @see ua.nure.jernovaya.SummaryTask4.dao.DAO#read(int)
	 */
	@Override
	public Tour read(int id) {
		Tour tour = null;
		try (Connection con = ConnectionProvider.getConnection();
				PreparedStatement prs = con.prepareStatement(Sqls.SELECT_TOUR_BY_ID)) {
			prs.setInt(1, id);
			ResultSet resultSet = prs.executeQuery();
			if (resultSet.next()) {
				tour = new Tour();
				tour.setId(id);
				tour.setImagePath(resultSet.getString("image_path"));
				tour.setType(Type.valueOf(resultSet.getString("type").toUpperCase()));
				tour.setPrice(resultSet.getDouble("price"));
				tour.setHotel(hotelDAO.read(resultSet.getInt("hotel_id")));
				tour.setIsHot(resultSet.getInt("is_hot"));
				tour.setDepartureCity(resultSet.getString("departure_city"));
				tour.setPersonCount(resultSet.getInt("person_count"));
				tour.setNights(resultSet.getInt("nights"));
				tour.setDepartureDate(resultSet.getDate("departure_date"));
			}

		} catch (SQLException e) {
			LOGGER.error(e.getMessage());
		}
		return tour;
	}
	/**
	 * (non-Javadoc)
	 * 
	 * @see ua.nure.jernovaya.SummaryTask4.dao.DAO#update(ua.nure.jernovaya.SummaryTask4.entity.Tour,java.lang.String)
	 */
	@Override
	public boolean update(Tour t, String sql) {
		try (Connection con = ConnectionProvider.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setInt(2, t.getId());
			if (t.getIsHot()) {
				ps.setInt(1, 0);
			} else {
				ps.setInt(1, 1);
			}

			return ps.executeUpdate() == 1;
		} catch (SQLException e) {
			LOGGER.error(e.getMessage());
		}
		return false;
	}
	/**
	 * (non-Javadoc)
	 * 
	 * @see ua.nure.jernovaya.SummaryTask4.dao.DAO#update(ua.nure.jernovaya.SummaryTask4.entity.Tour,java.lang.String)
	 */
	public boolean update(Tour tour) {
		try (Connection con = ConnectionProvider.getConnection();
				PreparedStatement ps = con.prepareStatement(Sqls.UPDATE_TOUR)) {
			ps.setString(1, tour.getImagePath());
			ps.setString(2, tour.getType().toString().toLowerCase());
			ps.setDouble(3, tour.getPrice());
			ps.setInt(4, tour.getPersonCount());
			ps.setInt(5, tour.getHotel().getId());
			ps.setDate(6, tour.getDepartureDate());
			ps.setInt(7, tour.getNights());
			ps.setString(8, tour.getDepartureCity());
			ps.setInt(9, tour.getId());
			return ps.executeUpdate() == 1;
		} catch (SQLException e) {
			LOGGER.error(e.getMessage());
		}
		return false;

	}
	/**
	 * (non-Javadoc)
	 * 
	 * @see ua.nure.jernovaya.SummaryTask4.dao.DAO#delete(ua.nure.jernovaya.SummaryTask4.entity.Tour)
	 */
	@Override
	public boolean delete(Tour t) {
		try (Connection con = ConnectionProvider.getConnection();
				PreparedStatement ps = con.prepareStatement(Sqls.DELETE_TOUR)) {
			ps.setInt(1, t.getId());
			return ps.executeUpdate() == 1;
		} catch (SQLException e) {
			LOGGER.error(e.getMessage());
		}
		return false;
	}
	/**
	 * returns a list with all elements of the table ta.tours.
	 * 
	 * @return a list with all elements of the table ta.tours.
	 */
	public List<Tour> getAllTours(String sql) {
		List<Tour> list = new ArrayList<>();
		Tour tour = null;
		try (Connection con = ConnectionProvider.getConnection(); PreparedStatement prs = con.prepareStatement(sql)) {
			ResultSet resultSet = prs.executeQuery();
			while (resultSet.next()) {
				tour = new Tour();
				tour.setId(resultSet.getInt("id"));
				tour.setImagePath(resultSet.getString("image_path"));
				tour.setType(Type.valueOf(resultSet.getString("type").toUpperCase()));
				tour.setPrice(resultSet.getDouble("price"));
				tour.setHotel(hotelDAO.read(resultSet.getInt("hotel_id")));
				tour.setIsHot(resultSet.getInt("is_hot"));
				tour.setDepartureCity(resultSet.getString("departure_city"));
				tour.setPersonCount(resultSet.getInt("person_count"));
				tour.setNights(resultSet.getInt("nights"));
				tour.setDepartureDate(resultSet.getDate("departure_date"));
				list.add(tour);
			}

		} catch (SQLException e) {
			LOGGER.error(e.getMessage());
		}
		return list;

	}
	/**
	 * returns a list with all elements of the table ta.tours with parameters.
	 * 
	 * @return a list with all elements of the table ta.tours with parameters.
	 */
	public List<Tour> getToursByParameters(String sql, Double double1, Double double2, int person_count, String type,
			String rate, String country, Date date) {
		List<Tour> list = new ArrayList<>();
		Tour tour = null;
		try (Connection con = ConnectionProvider.getConnection(); PreparedStatement prs = con.prepareStatement(sql)) {
			prs.setDouble(1, double1);
			prs.setDouble(2, double2);
			prs.setInt(3, person_count);
			prs.setString(4, type);
			prs.setString(5, rate);
			prs.setString(6, country);
			prs.setDate(7, date);
			ResultSet resultSet = prs.executeQuery();
			while (resultSet.next()) {
				tour = new Tour();
				tour.setId(resultSet.getInt("id"));
				tour.setImagePath(resultSet.getString("image_path"));
				tour.setType(Type.valueOf(resultSet.getString("type").toUpperCase()));
				tour.setPrice(resultSet.getDouble("price"));
				tour.setHotel(hotelDAO.read(resultSet.getInt("hotel_id")));
				tour.setIsHot(resultSet.getInt("is_hot"));
				tour.setDepartureCity(resultSet.getString("departure_city"));
				tour.setPersonCount(resultSet.getInt("person_count"));
				tour.setNights(resultSet.getInt("nights"));
				tour.setDepartureDate(resultSet.getDate("departure_date"));
				list.add(tour);
			}

		} catch (SQLException e) {
			LOGGER.error(e.getMessage());
		}
		return list;

	}
	/**
	 * returns a list with all elements of the table ta.tours where country is equals to {@code<country>}.
	 * 
	 * @return a list with all elements of the table ta.tours where country is equals to {@code<country>}.
	 */
	public List<Tour> getToursByCountry(String sql, String country) {
		List<Tour> list = new ArrayList<>();
		Tour tour = null;
		try (Connection con = ConnectionProvider.getConnection(); PreparedStatement prs = con.prepareStatement(sql)) {
			prs.setString(1, country);
			ResultSet resultSet = prs.executeQuery();
			while (resultSet.next()) {
				tour = new Tour();
				tour.setId(resultSet.getInt("id"));
				tour.setImagePath(resultSet.getString("image_path"));
				tour.setType(Type.valueOf(resultSet.getString("type").toUpperCase()));
				tour.setPrice(resultSet.getDouble("price"));
				tour.setHotel(hotelDAO.read(resultSet.getInt("hotel_id")));
				tour.setIsHot(resultSet.getInt("is_hot"));
				tour.setDepartureCity(resultSet.getString("departure_city"));
				tour.setPersonCount(resultSet.getInt("person_count"));
				tour.setNights(resultSet.getInt("nights"));
				tour.setDepartureDate(resultSet.getDate("departure_date"));
				list.add(tour);
			}

		} catch (SQLException e) {
			LOGGER.error(e.getMessage());
		}
		return list;

	}
	/**
	 * returns a list with all elements of the table by tours.hotel_id.
	 * 
	 * @return a list with all elements of the table tours.hotel_id.
	 */
	public List<Tour> getToursByHotelId(int hotelId) {
		List<Tour> list = new ArrayList<>();
		Tour tour = null;
		try (Connection con = ConnectionProvider.getConnection();
				PreparedStatement prs = con.prepareStatement(Sqls.SELECT_ALL_TOURS_BY_HOTEL_ID)) {
			prs.setInt(1, hotelId);
			ResultSet resultSet = prs.executeQuery();
			while (resultSet.next()) {
				tour = new Tour();
				tour.setId(resultSet.getInt("id"));
				tour.setImagePath(resultSet.getString("image_path"));
				tour.setType(Type.valueOf(resultSet.getString("type").toUpperCase()));
				tour.setPrice(resultSet.getDouble("price"));
				tour.setHotel(hotelDAO.read(resultSet.getInt("hotel_id")));
				tour.setIsHot(resultSet.getInt("is_hot"));
				tour.setDepartureCity(resultSet.getString("departure_city"));
				tour.setPersonCount(resultSet.getInt("person_count"));
				tour.setNights(resultSet.getInt("nights"));
				tour.setDepartureDate(resultSet.getDate("departure_date"));
				list.add(tour);
			}

		} catch (SQLException e) {
			LOGGER.error(e.getMessage());
		}
		return list;
	}

}
