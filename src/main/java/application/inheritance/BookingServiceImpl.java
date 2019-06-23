package application.inheritance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {
    @Autowired
    private BookingRepository bookingRepository;
    @Override
    public Booking getBookingbyId(String id) {
        return bookingRepository.getBookingbyId(id);
    }

    @Override
    public List<Booking> getAllBookings() {
        return bookingRepository.getAllBookings();
    }

    @Override
    public Booking updateOrSaveBooking(Booking booking) {
        booking.getProduct().stream().forEach(product -> product.setBooking(booking));
        return bookingRepository.updateOrSaveBooking(booking);
    }

    @Override
    public void deleteBooking(String id) {
bookingRepository.deleteBooking(id);
    }

    @Override
    public List<Booking> getByCriteria(Criteria criteria) {
        return bookingRepository.getByCriteria(criteria);
    }
}
