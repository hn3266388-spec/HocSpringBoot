package Study.spring.boot.CauTrucChuan.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "category")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @OneToMany(mappedBy = "category", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true)
    private List<Product> products= new ArrayList<>();
    //hepler method
    public void addProduct (Product p){
        products.add(p);
        p.setCategory(this);
    }
    public void remove(Product p){
        products.remove(p);
        p.setCategory(null);
    }
}