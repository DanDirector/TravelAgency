package ua.nure.jernovaya.SummaryTask4.jdbc;
/**
 * 
 * @author Elmira Jernovaya.
 *
 */
public class Sqls {
	
public static final String SELECT_ALL_SIMPLE_TOURS="SELECT * FROM ta.tours WHERE is_hot=1";
public static final String SELECT_ALL_HOT_TOURS="SELECT * FROM ta.tours WHERE is_hot=0";
public static final String SELECT_HOTEL_BY_ID="SELECT * FROM ta.hotels WHERE id=?";
public static final String SELECT_TOUR_BY_ID="SELECT * FROM ta.tours WHERE id=?";
public static final String SELECT_SIMPLE_TOURS_BY_PARAMETERS="SELECT * FROM ta.tours WHERE price between ? and ? AND is_hot=1"
		+ " and person_count =? AND `type` LIKE ? AND hotel_id IN (SELECT distinct id from ta.hotels WHERE rate LIKE ? AND country LIKE ?) AND departure_date>=?";
public static final String SELECT_HOT_TOURS_BY_PARAMETERS="SELECT * FROM ta.tours WHERE price between ? AND ? AND is_hot=0"
		+ " and person_count =? and `type` LIKE ? and hotel_id IN (SELECT distinct id from ta.hotels where rate LIKE ? and country LIKE ?) AND departure_date>=?";
public static final String SELECT_SIMPLE_TOURS_BY_COUNTRY="SELECT * FROM ta.tours WHERE hotel_id IN (SELECT distinct id from ta.hotels where country LIKE ?) AND is_hot=1";
public static final String SELECT_HOT_TOURS_BY_COUNTRY="SELECT * FROM ta.tours WHERE hotel_id IN (SELECT distinct id from ta.hotels where country LIKE ?) AND is_hot=0";
public static final String CREATE_ORDER="INSERT INTO `ta`.`orders` (`tour_id`, `user_id`, `status`) VALUES (?, ?, ?)";
public static final String SELECT_ORDER_BY_USER="SELECT * FROM ta.orders WHERE user_id=?";
public static final String SELECT_USER_BY_LOGIN_PASSWORD = "SELECT * FROM ta.users WHERE `login`=? AND `password`=?";
public static final String SELECT_COUNT_OF_USERS = "SELECT COUNT(user_id) FROM ta.orders WHERE user_id=? and status='payed'";
public static final String SELECT_USER_BY_LOGIN = "SELECT * FROM ta.users WHERE login=?";
public static final String CREATE_USER = "INSERT INTO `ta`.`users` (`role`, `name`, `second_name`, `email`, `login`, `password`) VALUES (?, ?, ?, ?, ?, ?)";
public static final String SELECT_ALL_ORDERS = "SELECT * FROM ta.orders ORDER BY ID DESC";
public static final String SELECT_USER_BY_ID = "SELECT * FROM ta.users WHERE id=?";
public static final String SET_ORDER_PAYED = "UPDATE `ta`.`orders` SET `status`='payed' WHERE `id`=?";
public static final String SET_ORDER_CANCELED = "UPDATE `ta`.`orders` SET `status`='canceled' WHERE `id`=?";
public static final String SELECT_ORDER_BY_ID = "SELECT * FROM ta.orders WHERE id=?";
public static final String SELECT_USER_BY_SECOND_NAME = "SELECT * FROM ta.users where name=? or name=? or second_name=? or second_name=?";
public static final String UPDATE_TOUR_BY_IS_HOT = "UPDATE `ta`.`tours` SET `is_hot`=? WHERE `id`=?";
public static final String SELECT_ALL_TOURS = "SELECT * FROM ta.tours ORDER BY ID DESC";
public static final String SELECT_ALL_HOTELS = "SELECT * FROM ta.hotels ORDER BY ID DESC";
public static final String UPDATE_TOUR = "UPDATE `ta`.`tours` SET `image_path`=?, `type`=?, `price`=?, `person_count`=?, `hotel_id`=?, `departure_date`=?, `nights`=?, `departure_city`=? WHERE `id`=?";
public static final String DELETE_TOUR = "DELETE FROM `ta`.`tours` WHERE `id`=?";
public static final String SELECT_All_TOURS_BY_PARAMETERS = "SELECT * FROM ta.tours WHERE price between ? and ? and person_count =? AND `type` LIKE ? AND hotel_id IN (SELECT distinct id from ta.hotels WHERE rate LIKE ? AND country LIKE ?) AND departure_date>=? ORDER BY ID DESC";
public static final String SELECT_HOTELS_BY_COUNTRY ="SELECT * FROM ta.hotels WHERE country=?" ;
public static final String SELECT_ALL_TOURS_BY_HOTEL_ID = "SELECT * FROM ta.tours WHERE hotel_id=? ORDER BY ID DESC";
public static final String CREATE_HOTEL = "INSERT INTO `ta`.`hotels` (`name`, `rate`, `nutrition_type`, `country`, `city`, `description`) VALUES (?, ?, ?, ?, ?, ?)";
public static final String UPDATE_HOTEL = "UPDATE `ta`.`hotels` SET `photos_path`=? WHERE `id`=?";
public static final String DELETE_HOTEL = "DELETE FROM `ta`.`hotels` WHERE `id`=?";
public static final String SELECT_ALL_USERS = "SELECT * FROM ta.users";
public static final String UPDATE_USER = "UPDATE `ta`.`users` SET `role`=?, `name`=?, `second_name`=?, `email`=?, `login`=? WHERE `id`=?";
public static final String CREATE_TOUR = "INSERT INTO `ta`.`tours` (`image_path`, `type`, `price`, `person_count`, `hotel_id`, `is_hot`, `departure_date`, `nights`, `departure_city`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
public static final String CREATE_SUBSCRIBER = "INSERT INTO `ta`.`subscribers` (`email`) VALUES (?)";
public static final String SELECT_ALL_SUBSCRIBERS = "SELECT * FROM ta.subscribers";
public static final String SELECT_CURRENT_ORDERS ="SELECT * FROM ta.orders WHERE tour_id IN (SELECT distinct id from ta.tours where departure_date BETWEEN ? AND ?)";


}