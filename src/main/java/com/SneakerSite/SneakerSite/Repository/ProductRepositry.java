package com.SneakerSite.SneakerSite.Repository;

import com.SneakerSite.SneakerSite.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;

public interface ProductRepositry extends JpaRepository<Product, Long> {

    @Query(value = "SELECT po.* FROM (SELECT * FROM product LIMIT ?1 OFFSET ?2) AS po JOIN product_size_count c ON c.product_id = po.id", nativeQuery = true)
    Collection<Product> findProductWithPagination(int limit, int offset);

}
