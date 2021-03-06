/**
 * 
 */
package ua.nure.jernovaya.SummaryTask4;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.mockito.Mockito;

import ua.nure.jernovaya.SummaryTask4.commands.AddHotelCommandTest;
import ua.nure.jernovaya.SummaryTask4.commands.AdminCommandTest;
import ua.nure.jernovaya.SummaryTask4.commands.AllToursCommandTest;
import ua.nure.jernovaya.SummaryTask4.commands.ClientsSearchCommandTest;
import ua.nure.jernovaya.SummaryTask4.commands.CountriesCommandTest;
import ua.nure.jernovaya.SummaryTask4.commands.DeleteHotelCommandTest;
import ua.nure.jernovaya.SummaryTask4.commands.DeleteTourCommandTest;
import ua.nure.jernovaya.SummaryTask4.commands.HotTourCommandTest;
import ua.nure.jernovaya.SummaryTask4.commands.InvokerTest;
import ua.nure.jernovaya.SummaryTask4.commands.LogInCommandTest;
import ua.nure.jernovaya.SummaryTask4.commands.LogOutCommandTest;
import ua.nure.jernovaya.SummaryTask4.commands.ManagerCommandTest;
import ua.nure.jernovaya.SummaryTask4.commands.MyAccountCommandTest;
import ua.nure.jernovaya.SummaryTask4.commands.NewTourCommandTest;
import ua.nure.jernovaya.SummaryTask4.commands.NextPageCommandTest;
import ua.nure.jernovaya.SummaryTask4.commands.PreviousPageCommandTest;
import ua.nure.jernovaya.SummaryTask4.commands.RegCommandTest;
import ua.nure.jernovaya.SummaryTask4.commands.ReserveCommandTest;
import ua.nure.jernovaya.SummaryTask4.commands.SearchHotelsCommandTest;
import ua.nure.jernovaya.SummaryTask4.commands.SelectOrdersCommandTest;
import ua.nure.jernovaya.SummaryTask4.commands.SelectToursCommandTest;
import ua.nure.jernovaya.SummaryTask4.commands.SendMailCommandTest;
import ua.nure.jernovaya.SummaryTask4.commands.SortCommandTest;
import ua.nure.jernovaya.SummaryTask4.commands.SubscribeCommandTest;
import ua.nure.jernovaya.SummaryTask4.commands.UpdateCommandTest;
import ua.nure.jernovaya.SummaryTask4.commands.UpdateTourCommandTest;
import ua.nure.jernovaya.SummaryTask4.commands.UsersCommandTest;
import ua.nure.jernovaya.SummaryTask4.commands.UsersSearchCommandTest;
import ua.nure.jernovaya.SummaryTask4.commands.UsersUpdateCommandTest;
import ua.nure.jernovaya.SummaryTask4.controller.ControllerTest;
import ua.nure.jernovaya.SummaryTask4.filters.AuthoriziedFilterTest;
import ua.nure.jernovaya.SummaryTask4.filters.EncodingFilter;
import ua.nure.jernovaya.SummaryTask4.filters.EncodingFilterTest;
/**
 * 
 * @author Elmira Jernovaya.
 *
 */
import ua.nure.jernovaya.SummaryTask4.filters.RoleFilterTest;
import ua.nure.jernovaya.SummaryTask4.listeners.ContextListenerTest;
import ua.nure.jernovaya.SummaryTask4.tags.ImagePathsTest;
@RunWith(Suite.class)
@SuiteClasses({ AddHotelCommandTest.class, AdminCommandTest.class, AllToursCommandTest.class,AuthoriziedFilterTest.class,
		ClientsSearchCommandTest.class,ContextListenerTest.class, CountriesCommandTest.class, DeleteHotelCommandTest.class,
		DeleteTourCommandTest.class, EncodingFilterTest.class,HotTourCommandTest.class, InvokerTest.class,ImagePathsTest.class,
		LogInCommandTest.class, LogOutCommandTest.class, ManagerCommandTest.class, MyAccountCommandTest.class,
		NewTourCommandTest.class, NextPageCommandTest.class, PreviousPageCommandTest.class,RegCommandTest.class, ReserveCommandTest.class,
		SearchHotelsCommandTest.class, SelectOrdersCommandTest.class, SelectToursCommandTest.class,
		RoleFilterTest.class,
		SendMailCommandTest.class, SortCommandTest.class, SubscribeCommandTest.class, UpdateCommandTest.class,
		UpdateTourCommandTest.class, UsersCommandTest.class, UsersSearchCommandTest.class,ControllerTest.class,
		UsersUpdateCommandTest.class })
public class AllTests extends Mockito{
}
