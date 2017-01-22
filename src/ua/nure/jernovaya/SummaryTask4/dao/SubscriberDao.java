/**
 * 
 */
package ua.nure.jernovaya.SummaryTask4.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import ua.nure.jernovaya.SummaryTask4.entity.Subscriber;
import ua.nure.jernovaya.SummaryTask4.jdbc.ConnectionProvider;
import ua.nure.jernovaya.SummaryTask4.jdbc.Sqls;

/**
 * @author Elmira Jenovaya.
 *
 */
public class SubscriberDao implements DAO<Subscriber> {
/**
 * Logger.
 */
	private static final Logger LOGGER = Logger.getLogger(SubscriberDao.class);
	/**
	 * (non-Javadoc)
	 * 
	 * @see ua.nure.jernovaya.SummaryTask4.dao.DAO#create(ua.nure.jernovaya.SummaryTask4.entity.Subscriber)
	 */
	@Override
	public boolean create(Subscriber s) {
		boolean done = false;
		try (Connection con = ConnectionProvider.getConnection();
				PreparedStatement prs = con.prepareStatement(Sqls.CREATE_SUBSCRIBER)) {
			prs.setString(1, s.getEmail());
			done = prs.executeUpdate()==1;
			
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
	public Subscriber read(int id) {
		throw new UnsupportedOperationException();
	}
	/**
	 * (non-Javadoc)
	 * 
	 * @see ua.nure.jernovaya.SummaryTask4.dao.DAO#update(ua.nure.jernovaya.SummaryTask4.entity.Subscriber,java.lang.String)
	 */
	@Override
	public boolean update(Subscriber e, String sql) {
		throw new UnsupportedOperationException();
	}
	/**
	 * (non-Javadoc)
	 * 
	 * @see ua.nure.jernovaya.SummaryTask4.dao.DAO#delete(ua.nure.jernovaya.SummaryTask4.entity.Subscriber)
	 */
	@Override
	public boolean delete(Subscriber e) {
		throw new UnsupportedOperationException();
	}
	/**
	 * returns a list with all elements of the table ta.subscribers.
	 * 
	 * @return a list with all elements of the table ta.subscribers.
	 */
	public List<Subscriber> getAll() {
		List<Subscriber> list = new ArrayList<>();
		Subscriber ss = null;
		try (Connection con = ConnectionProvider.getConnection();
				PreparedStatement prs = con.prepareStatement(Sqls.SELECT_ALL_SUBSCRIBERS)) {
			ResultSet resultSet = prs.executeQuery();
			while (resultSet.next()) {
				ss = new Subscriber();
				ss.setId(resultSet.getInt("id"));
				ss.setEmail(resultSet.getString("email"));
				list.add(ss);
			}
		} catch (SQLException e) {
			LOGGER.error(e.getMessage());
		}
		return list;
	}

}
