package Study.spring.boot.CauTrucChuan.repository;



import Study.spring.boot.CauTrucChuan.entity.Document;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepository extends JpaRepository<Document, Long> {
}
