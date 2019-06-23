package application.inheritance;

import application.employee.Employee;
import application.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @GetMapping(value = "booking/get/{id}")
    public Booking getBooking(@PathVariable String id){
        return bookingService.getBookingbyId(id);
    }

    @GetMapping(value = "booking/get/all")
    public List<Booking> getAllbookings(){ return bookingService.getAllBookings(); }

    @RequestMapping(value ="booking/add",method = RequestMethod.POST)
    public Booking addBooking(@RequestBody Booking booking){
        return bookingService.updateOrSaveBooking(booking);
    }

   @PostMapping(value = "/booking/getByCriteria")
    public List<Booking> getByCriteria(@RequestBody Criteria criteria){
        return bookingService.getByCriteria(criteria);
    }

    @DeleteMapping(value = "booking/delete/{id}")
    public void deleteBooking(@PathVariable String id){
        bookingService.deleteBooking(id);
    }

}
