/**
 * 
 */
package ua.nure.jernovaya.SummaryTask4.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import ua.nure.jernovaya.SummaryTask4.entity.Role;
import ua.nure.jernovaya.SummaryTask4.entity.User;
import ua.nure.jernovaya.SummaryTask4.jdbc.ConnectionProvider;
import ua.nure.jernovaya.SummaryTask4.jdbc.Sqls;

/**
 * @author Elmira Jernovaya.
 *
 */
public class UserDAO implements DAO<User> {
	/**
	 * Logger.
	 */
	private static final Logger LOGGER = Logger.getLogger(UserDAO.class);
	private int userID;

	/**
	 * (non-Javadoc)
	 * 
	 * @see ua.nure.jernovaya.SummaryTask4.dao.DAO#create(ua.nure.jernovaya.SummaryTask4.entity.User)
	 */
	@Override
	public boolean create(User user) {
		boolean done = false;
		try (Connection con = ConnectionProvider.getConnection();
				PreparedStatement prs = con.prepareStatement(Sqls.CREATE_USER, Statement.RETURN_GENERATED_KEYS)) {
			prs.setString(1, Role.CLIENT.toString().toLowerCase());
			prs.setString(2, user.getName());
			prs.setString(3, user.getSecondName());
			prs.setString(4, user.getEmail());
			prs.setString(5, user.getLogin());
			prs.setString(6, user.getPasword());
			done = prs.execute();
			ResultSet rs = prs.getGeneratedKeys();
			if (rs.next()) {
				setUserID(rs.getInt(1));
			}
		} catch (SQLException e) {
			LOGGER.error(e.getMessage());
		}
		return done;
	}

	public int getUserID() {
		return this.userID;

	}

	public void setUserID(int id) {
		this.userID = id;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see ua.nure.jernovaya.SummaryTask4.dao.DAO#read(int)
	 */
	@Override
	public User read(int id) {
		User user = null;
		try (Connection con = ConnectionProvider.getConnection();
				PreparedStatement prs = con.prepareStatement(Sqls.SELECT_USER_BY_ID)) {
			prs.setInt(1, id);
			ResultSet resultSet = prs.executeQuery();
			if (resultSet.next()) {
				user = new User();
				user.setId(id);
				user.setEmail(resultSet.getString("email"));
				user.setSecondName(resultSet.getString("second_name"));
				user.setName(resultSet.getString("name"));
				user.setLogin(resultSet.getString("login"));
				user.setRole(Role.valueOf(resultSet.getString("role").toUpperCase()));
			}

		} catch (SQLException e) {
			LOGGER.error(e.getMessage());
		}
		return user;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see ua.nure.jernovaya.SummaryTask4.dao.DAO#read(int)
	 */
	public User read(String login, String password) {
		User user = null;
		try (Connection con = ConnectionProvider.getConnection();
				PreparedStatement prs = con.prepareStatement(Sqls.SELECT_USER_BY_LOGIN_PASSWORD)) {
			prs.setString(1, login);
			prs.setString(2, password);
			ResultSet resultSet = prs.executeQuery();
			if (resultSet.next()) {
				user = new User();
				user.setId(resultSet.getInt("id"));
				user.setRole(Role.valueOf(resultSet.getString("role").toUpperCase()));
				user.setName(resultSet.getString("name"));
				user.setSecondName(resultSet.getString("second_name"));
				user.setEmail(resultSet.getString("email"));
			}

		} catch (SQLException e) {
			LOGGER.error(e.getMessage());
		}
		return user;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see ua.nure.jernovaya.SummaryTask4.dao.DAO#update(ua.nure.jernovaya.SummaryTask4.entity.User,java.lang.String)
	 */
	@Override
	public boolean update(User user, String sql) {
		try (Connection con = ConnectionProvider.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setString(1, user.getRole().toString().toLowerCase());
			ps.setString(2, user.getName());
			ps.setString(4, user.getEmail());
			ps.setString(5, user.getLogin());
			ps.setInt(6, user.getId());
			ps.setString(3, user.getSecondName());
			return ps.executeUpdate() == 1;
		} catch (SQLException e) {
			LOGGER.error(e.getMessage());
		}
		return false;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see ua.nure.jernovaya.SummaryTask4.dao.DAO#delete(ua.nure.jernovaya.SummaryTask4.entity.User)
	 */
	@Override
	public boolean delete(User e) {
		throw new UnsupportedOperationException();
	}

	/**
	 * checks if user with {@code<login>} exists in table ta.users.
	 * 
	 * @param login
	 * @return
	 */
	public boolean userExists(String login) {
		try (Connection con = ConnectionProvider.getConnection();
				PreparedStatement prs = con.prepareStatement(Sqls.SELECT_USER_BY_LOGIN)) {
			prs.setString(1, login);
			ResultSet resultSet = prs.executeQuery();
			if (resultSet.next()) {
				return true;
			}

		} catch (SQLException e) {
			LOGGER.error(e.getMessage());
		}
		return false;
	}

	/**
	 * returns list with users which name and secondName are equals to {@code
	 * <name1,name2>}.
	 * 
	 * @param name1
	 * @param name2
	 * @return
	 */
	public List<User> getUserBySecondName(String name1, String name2) {
		List<User> list = new ArrayList<>();
		User user = null;
		try (Connection con = ConnectionProvider.getConnection();
				PreparedStatement prs = con.prepareStatement(Sqls.SELECT_USER_BY_SECOND_NAME)) {
			prs.setString(1, name1);
			prs.setString(2, name2);
			prs.setString(3, name1);
			prs.setString(4, name2);
			ResultSet resultSet = prs.executeQuery();
			while (resultSet.next()) {
				user = new User();
				user.setId(resultSet.getInt("id"));
				user.setRole(Role.valueOf(resultSet.getString("role").toUpperCase()));
				user.setName(resultSet.getString("name"));
				user.setSecondName(resultSet.getString("second_name"));
				user.setEmail(resultSet.getString("email"));
				list.add(user);
			}

		} catch (SQLException e) {
			LOGGER.error(e.getMessage());
		}
		return list;
	}

	/**
	 * returns a list with all elements of the table ta.users.
	 * 
	 * @return a list with all elements of the table ta.users.
	 */
	public List<User> getAllUsers() {
		List<User> list = new ArrayList<>();
		User user = null;
		try (Connection con = ConnectionProvider.getConnection();
				PreparedStatement prs = con.prepareStatement(Sqls.SELECT_ALL_USERS)) {
			ResultSet resultSet = prs.executeQuery();
			while (resultSet.next()) {
				user = new User();
				user.setId(resultSet.getInt("id"));
				user.setName(resultSet.getString("name"));
				user.setSecondName(resultSet.getString("second_name"));
				user.setEmail(resultSet.getString("email"));
				user.setLogin(resultSet.getString("login"));
				user.setRole(Role.valueOf(resultSet.getString("role").toUpperCase()));
				list.add(user);
			}
		} catch (SQLException e) {
			LOGGER.error(e.getMessage());
		}
		return list;
	}

}
