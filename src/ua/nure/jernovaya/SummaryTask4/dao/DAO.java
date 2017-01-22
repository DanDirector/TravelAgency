/**
 * 
 */
package ua.nure.jernovaya.SummaryTask4.dao;

/**
 * @author Elmira Jernovaya.
 *
 */
public interface DAO<E> {
	/**
	 * creates element in the table of the database.
	 * 
	 * @param e
	 * @return
	 */
	boolean create(E e);

	/**
	 * reads the element from the table of the database by id.
	 * 
	 * @param id
	 * @return
	 */
	E read(int id);

	/**
	 * updates an element in the table of the database.
	 * 
	 * @param e
	 * @param sql
	 * @return
	 */
	boolean update(E e, String sql);

	/**
	 * deletes an element in te table of the database.
	 * 
	 * @param e
	 * @return
	 */
	boolean delete(E e);
}
