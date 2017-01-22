/**
 * 
 */
package ua.nure.jernovaya.SummaryTask4.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.log4j.Logger;

/**
 * @author Elmira Jernovaya.
 *
 */
public class ConnectionProvider {
	private static DataSource datasource;
	/**
	 * Logger.
	 */
	private static final Logger LOGGER = Logger.getLogger(ConnectionProvider.class);

	private ConnectionProvider() {
	}

	public static Connection getConnection() {
		if (datasource == null) {
			Context initCtx;
			try {
				initCtx = new InitialContext();
				Context envCtx = (Context) initCtx.lookup("java:comp/env");
				datasource = (DataSource) envCtx.lookup("jdbc/ta");
			} catch (NamingException e) {
				LOGGER.error(e.getMessage());
			}
		}
		Connection connection = null;
		try {
			connection = datasource.getConnection();
		} catch (SQLException ex) {
			LOGGER.error(ex.getMessage());
		}
		return connection;

	}
}
