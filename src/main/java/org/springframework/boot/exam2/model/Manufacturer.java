package org.springframework.boot.exam2.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Manufacturer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;
    public String name;
    public String origin;
    public String description;
    @OneToMany(mappedBy = "manufacturer",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    List<Product>products;
}
