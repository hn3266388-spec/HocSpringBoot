package Study.spring.boot.CauTrucChuan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Study.spring.boot.CauTrucChuan.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
