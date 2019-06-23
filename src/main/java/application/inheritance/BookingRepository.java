package application.inheritance;

import java.util.List;

public interface BookingRepository {
    Booking getBookingbyId(String id);
    List<Booking> getAllBookings();
    Booking updateOrSaveBooking(Booking booking);
    void deleteBooking(String id);
    List<Booking> getByCriteria(Criteria criteria);
}
