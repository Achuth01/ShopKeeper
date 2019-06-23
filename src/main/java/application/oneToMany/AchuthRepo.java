package application.oneToMany;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Repository
public class AchuthRepo extends SimpleJpaRepository<Achuth,Integer> {

    public AchuthRepo(EntityManager entityManager) {
        super(Achuth.class, entityManager);
    }

    public Achuth get(Integer id){
        return this.findOne(id);
    }

    public List<Achuth> getAll(){
        return this.findAll();
    }

    public Achuth saveorUpdate(Achuth achuth){
        return this.saveAndFlush(achuth);
    }

    public void remove(Integer id){
        this.delete(id);
        this.flush();
    }

}
