package Study.spring.boot.CauTrucChuan.common;

import Study.spring.boot.CauTrucChuan.entity.Checkup;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class Example {
    @PersistenceContext
    EntityManager entitymanager;
//   Persistence Context
    public String findNameProduct(){
        entitymanager.find(Checkup.class,1);
        return "";
    }
}
