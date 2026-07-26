package Study.spring.boot.CauTrucChuan.repository;

import Study.spring.boot.CauTrucChuan.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Categoryrepository extends JpaRepository<Category,Long> {
}
