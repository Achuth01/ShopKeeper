package application.inheritance;

import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.awt.print.Book;
import java.util.List;

@Repository
public class BookingRepositoryImpl extends SimpleJpaRepository<Booking,String> implements BookingRepository {
    private EntityManager entityManager;
    public BookingRepositoryImpl(EntityManager entityManager) {
        super(Booking.class, entityManager);
        this.entityManager=entityManager;
    }

    @Override
    public Booking getBookingbyId(String id) {
        return this.findOne(id);
    }

    @Override
    public List<Booking> getAllBookings() {
        return this.findAll();
    }

    @Override
    public Booking updateOrSaveBooking(Booking booking) {
        return this.saveAndFlush(booking);
    }

    @Override
    public void deleteBooking(String id) {
        this.delete(id);
        this.flush();
    }

    @Override
    public List<Booking> getByCriteria(Criteria criteria) {
        CriteriaBuilder criteriaBuilder=entityManager.getCriteriaBuilder();
        CriteriaQuery<Booking> criteriaQuery=criteriaBuilder.createQuery(Booking.class);
        Root<Booking> root=criteriaQuery.from(Booking.class);

        Predicate predicate=criteriaBuilder.equal(root.get("bookingRef"),criteria.getBookingRef());
        criteriaQuery.where(predicate);
        return entityManager.createQuery(criteriaQuery).getResultList();
    }
}
