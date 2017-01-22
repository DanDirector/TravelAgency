/**
 * 
 */
package ua.nure.jernovaya.SummaryTask4.listeners;

import static org.junit.Assert.*;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;

import org.junit.Test;
import org.mockito.Mockito;

/**
 * @author Elmira
 *
 */
public class ContextListenerTest extends Mockito {

	/**
	 * Test method for {@link ua.nure.jernovaya.SummaryTask4.listeners.ContextListener#contextInitialized(javax.servlet.ServletContextEvent)}.
	 */
	@Test
	public void testContextInitialized() {
		ServletContextEvent event=mock(ServletContextEvent.class);
		ServletContext context=mock(ServletContext.class);
		when(event.getServletContext()).thenReturn(context);
		when(context.getRealPath(Mockito.anyString())).thenReturn("path");
		when(context.getInitParameter(Mockito.anyString())).thenReturn("str");
		new ContextListener().contextInitialized(event);
	}

}
