/**
 * 
 */
package ua.nure.jernovaya.SummaryTask4.commands;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

/**
 * @author Elmira Jernovaya.
 *
 */
public class Invoker implements Command {
	/**
	 * this map invoke keys and commands.
	 */
	public static Map<String, Command> map = new ConcurrentHashMap<String, Command>();
	/**
	 * Logger.
	 */
	final static Logger LOGGER = Logger.getLogger(Invoker.class); 
	private Command command;

	/**
	 * Constructor.
	 * 
	 * @param key
	 */
	public Invoker(String key) {
		if (key != null) {
			this.command = map.get(key);
		} else
			LOGGER.error("key == null");
	}

	/**
	 * default constructor.
	 */
	public Invoker() {
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see ua.nure.jernovaya.SummaryTask4.commands.Command#execute(javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) {
		if (command != null) {
			command.execute(req, res);
		} else
			LOGGER.error("command==null");
	}

}
