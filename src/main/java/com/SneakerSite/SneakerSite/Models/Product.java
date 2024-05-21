package com.SneakerSite.SneakerSite.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "product")
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique = true, nullable = false)
    private String productCode;
    private String name;
    private String productDetails;
    private Double price;
    private String priceUnit;
    private Double discount;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "product")
    private List<ProductSizeCount> productSizeCountList;


}
