package application.oneToMany;

import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class FriendsRepo extends SimpleJpaRepository<Friends,Integer> {

    public FriendsRepo(EntityManager entityManager) {
        super(Friends.class, entityManager);
    }

    public Friends get(Integer id){
        return this.findOne(id);
    }

    public List<Friends> getAll(){
        return this.findAll();
    }

    public Friends saveorUpdate(Friends friends){
        return this.saveAndFlush(friends);
    }

    public void remove(Integer id){
        this.delete(id);
    }

}
