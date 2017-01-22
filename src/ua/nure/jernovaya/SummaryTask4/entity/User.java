package ua.nure.jernovaya.SummaryTask4.entity;

/**
 * 
 * @author Elmira Jernovaya.
 *
 */
public class User {
	private int id;
	private Role role;
	private String name;
	private String secondName;
	private String email;
	private String login;
	private String pasword;

	/**
	 * default constructor.
	 */
	public User() {

	}

	/**
	 * The constructor with parameters.
	 * 
	 * @param name
	 * @param secName
	 * @param email
	 * @param login
	 * @param password
	 */
	public User(String name, String secName, String email, String login, String password) {
		setEmail(email);
		setLogin(login);
		setName(name);
		setPasword(password);
		setSecondName(secName);
		setRole(Role.CLIENT);
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
	 * @return the role
	 */
	public final Role getRole() {
		return role;
	}

	/**
	 * @param role
	 *            the role to set
	 */
	public final void setRole(Role role) {
		this.role = role;
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
	 * @return the secondName
	 */
	public final String getSecondName() {
		return secondName;
	}

	/**
	 * @param secondName
	 *            the secondName to set
	 */
	public final void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	/**
	 * @return the email
	 */
	public final String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public final void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the login
	 */
	public final String getLogin() {
		return login;
	}

	/**
	 * @param login
	 *            the login to set
	 */
	public final void setLogin(String login) {
		this.login = login;
	}

	/**
	 * @return the pasword
	 */
	public final String getPasword() {
		return pasword;
	}

	/**
	 * @param pasword
	 *            the pasword to set
	 */
	public final void setPasword(String pasword) {
		this.pasword = pasword;
	}

}
