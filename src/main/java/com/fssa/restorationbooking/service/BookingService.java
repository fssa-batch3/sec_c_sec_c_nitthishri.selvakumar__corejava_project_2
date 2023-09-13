package com.fssa.restorationbooking.service;

import java.sql.SQLException;
import java.util.List;

import com.fssa.restorationbooking.dao.BookingDao;
import com.fssa.restorationbooking.dao.DAOException;
import com.fssa.restorationbooking.model.BookingRequest;
import com.fssa.restorationbooking.validation.BookingValidation;

public class BookingService {

	private BookingValidation bookingValidation;
	private BookingDao bookingDao;

	public BookingService(BookingValidation bookingValidation, BookingDao bookingDao) {
		this.bookingValidation = bookingValidation;
		this.bookingDao = bookingDao;

	}

	public BookingService() {

	}

	public boolean addBooking(BookingRequest booking) throws DAOException, SQLException {
		if (BookingValidation.validateBookingDetails(booking)) {
			return BookingDao.addBooking(booking);
		} else {
			return false;
		}
	}

	public boolean updateBooking(BookingRequest booking) throws DAOException, SQLException {
		if (BookingValidation.validateBookingDetails(booking)) {
			return BookingDao.updateBooking(booking);
		} else {
			return false;
		}
	}

	public boolean deleteBooking(int bookingId) throws DAOException, SQLException {
		// BookingValidation bookingValidate = new BookingValidation();
		if (BookingValidation.bookingIdValidator(bookingId)) {
			return bookingDao.deleteBooking(bookingId);

		} else {
			return false;
		}
	}

	public List<BookingRequest> getParticularBooking(int bookingId) throws DAOException, SQLException {
		BookingDao bookingDao = new BookingDao();
		return BookingDao.getSelectedBookings(bookingId);

	}

	public static List<BookingRequest> getFullBooking() throws DAOException, SQLException {
		BookingDao bookingDao1 = new BookingDao();
		return BookingDao.getAllBookings();
	}
	public static List<BookingRequest> getThroughEmail(String userEmail) throws DAOException, SQLException {
		return BookingDao.getThroughEmail(userEmail);

	}

//	public static void main(String[] args) throws DAOException, SQLException {
////		BookingDao book = new BookingDao();
////		BookingValidation validBooking = new BookingValidation();
////		BookingService service = new BookingService(validBooking, book);
////		BookingRequest booking1 = new BookingRequest("nitth@gmail.com", "antique clock", "6380628123", true,
////				"https://iili.io/HZ8lwOX.png", "nitthu", LocalDateTime.of(2023, 8, 3, 21, 0), CategoryOfItem.CAMERA, 34,76);
////		boolean data = service.addBooking(booking1);
////		if (data) {
////			System.out.println("success");
////		} else {
////			System.out.println("failure");
////		}
//		List<BookingRequest> arr = getFullBooking();
//		for (BookingRequest e : arr) {
//			System.out.println(e.getBookingUserName() + e.getImageUrl() + e.getPhoneNumber());
//		}
//
//	}
}
