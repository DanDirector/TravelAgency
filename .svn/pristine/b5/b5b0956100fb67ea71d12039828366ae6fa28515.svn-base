package ua.nure.jernovaya.SummaryTask4.dao;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import ua.nure.jernovaya.SummaryTask4.entity.Hotel;
import ua.nure.jernovaya.SummaryTask4.entity.Nutrition;
import ua.nure.jernovaya.SummaryTask4.jdbc.ConnectionProvider;
import ua.nure.jernovaya.SummaryTask4.jdbc.Sqls;
import ua.nure.jernovaya.SummaryTask4.tags.ImagePaths;

/**
 * 
 * @author Elmira Jernvaya.
 *
 */
public class HotelDAO implements DAO<Hotel> {
	/**
	 * Logger.
	 */
	final static Logger LOGGER = Logger.getLogger(HotelDAO.class);

	/**
	 * (non-Javadoc)
	 * 
	 * @see ua.nure.jernovaya.SummaryTask4.dao.DAO#create(ua.nure.jernovaya.SummaryTask4.entity.Hotel)
	 */
	@Override
	public boolean create(Hotel h) {
		boolean done = false;
		int id = 0;
		try (Connection con = ConnectionProvider.getConnection();
				PreparedStatement prs = con.prepareStatement(Sqls.CREATE_HOTEL, Statement.RETURN_GENERATED_KEYS)) {
			prs.setString(1, h.getName());
			prs.setString(2, h.getRate());
			prs.setString(3, h.getNut().toString());
			prs.setString(4, h.getCountry());
			prs.setString(5, h.getCity());
			prs.setString(6, h.getDescription());
			done = (prs.executeUpdate() == 1);
			ResultSet rs = prs.getGeneratedKeys();
			if (rs.next())
				id = rs.getInt(1);
		} catch (SQLException e) {
			LOGGER.error(e.getMessage());
		}
		h.setId(id);
		h.setPhotosPath("images/" + id);
		File file = new File(ImagePaths.parentPath + h.getPhotosPath());
		File file1 = new File("C:\\workspace\\WebContent\\" + h.getPhotosPath());
		file1.mkdir();
		file.mkdir();
		update(h, Sqls.UPDATE_HOTEL);
		return done;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see ua.nure.jernovaya.SummaryTask4.dao.DAO#read(int)
	 */
	@Override
	public Hotel read(int id) {
		Hotel hotel = null;
		try (Connection con = ConnectionProvider.getConnection();
				PreparedStatement prs = con.prepareStatement(Sqls.SELECT_HOTEL_BY_ID)) {
			prs.setInt(1, id);
			ResultSet resultSet = prs.executeQuery();
			if (resultSet.next()) {
				hotel = new Hotel();
				hotel.setId(id);
				hotel.setName(resultSet.getString("name"));
				hotel.setRate(resultSet.getString("rate"));
				hotel.setNut(Nutrition.valueOf(resultSet.getString("nutrition_type")));
				hotel.setCountry(resultSet.getString("country"));
				hotel.setCity(resultSet.getString("city"));
				hotel.setDescription(resultSet.getString("description"));
				hotel.setPhotosPath(resultSet.getString("photos_path"));

			}

		} catch (SQLException e) {
			LOGGER.error(e.getMessage());
		}
		return hotel;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see ua.nure.jernovaya.SummaryTask4.dao.DAO#update(ua.nure.jernovaya.SummaryTask4.entity.Hotel,java.lang.String)
	 */
	@Override
	public boolean update(Hotel h, String sql) {
		try (Connection con = ConnectionProvider.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setString(1, h.getPhotosPath());
			ps.setInt(2, h.getId());
			return ps.executeUpdate() == 1;
		} catch (SQLException e) {
			LOGGER.error(e.getMessage());
		}
		return false;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see ua.nure.jernovaya.SummaryTask4.dao.DAO#delete(ua.nure.jernovaya.SummaryTask4.entity.Hotel)
	 */
	@Override
	public boolean delete(Hotel h) {
		try (Connection con = ConnectionProvider.getConnection();
				PreparedStatement ps = con.prepareStatement(Sqls.DELETE_HOTEL)) {
			ps.setInt(1, h.getId());
			return ps.executeUpdate() == 1;
		} catch (SQLException e) {
			LOGGER.error(e.getMessage());
		}
		return false;
	}

	/**
	 * returns a list with all elements of the table ta.hotels.
	 * 
	 * @return a list with all elements of the table ta.hotels.
	 */
	public List<Hotel> getAllHotels() {
		List<Hotel> list = new ArrayList<>();
		Hotel hotel = null;
		try (Connection con = ConnectionProvider.getConnection();
				PreparedStatement prs = con.prepareStatement(Sqls.SELECT_ALL_HOTELS)) {
			ResultSet resultSet = prs.executeQuery();
			while (resultSet.next()) {
				hotel = new Hotel();
				hotel.setId(resultSet.getInt("id"));
				hotel.setName(resultSet.getString("name"));
				hotel.setCity(resultSet.getString("city"));
				hotel.setCountry(resultSet.getString("country"));
				hotel.setRate(resultSet.getString("rate"));
				hotel.setNut(Nutrition.valueOf(resultSet.getString("nutrition_type")));
				hotel.setDescription(resultSet.getString("description"));
				hotel.setPhotosPath(resultSet.getString("photos_path"));
				list.add(hotel);
			}
		} catch (SQLException e) {
			LOGGER.error(e.getMessage());
		}
		return list;
	}

	/**
	 * returns a list with all elements of the table ta.hotels where
	 * hotels.country is equals to {@param<country>}.
	 * 
	 * @return a list with all elements of the table ta.hotels. where
	 *         hotels.country is equals to {@param<country>}.
	 * @param country
	 */

	public List<Hotel> getHotelsByCountry(String country) {
		List<Hotel> list = new ArrayList<>();
		Hotel hotel = null;
		try (Connection con = ConnectionProvider.getConnection();
				PreparedStatement prs = con.prepareStatement(Sqls.SELECT_HOTELS_BY_COUNTRY)) {
			prs.setString(1, country);
			ResultSet resultSet = prs.executeQuery();
			while (resultSet.next()) {
				hotel = new Hotel();
				hotel.setId(resultSet.getInt("id"));
				hotel.setName(resultSet.getString("name"));
				hotel.setCity(resultSet.getString("city"));
				hotel.setCountry(country);
				hotel.setRate(resultSet.getString("rate"));
				hotel.setNut(Nutrition.valueOf(resultSet.getString("nutrition_type")));
				hotel.setDescription(resultSet.getString("description"));
				hotel.setPhotosPath(resultSet.getString("photos_path"));
				list.add(hotel);
			}
		} catch (SQLException e) {
			LOGGER.error(e.getMessage());
		}
		return list;
	}
}
