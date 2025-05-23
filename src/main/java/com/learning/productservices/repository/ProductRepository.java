package com.learning.productservices.repository;

import com.learning.productservices.model.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "select * from product pd \n" +
            "JOIN product_Type ON pd.product_Type_id = product_Type.id \n" +
            "where pd.product_code = :product_code", nativeQuery = true)
    List<Product> queryProductCode(@Param("product_code") String productCode);

    @Query(value = "select * from product pd \n" +
            "JOIN product_Type ON pd.product_Type_id = product_Type.id \n" +
            "where pd.product_name = :product_name", nativeQuery = true)
    List<Product> queryProductName(@Param("product_name") String productName);

    @Query(value = "select * from product pd \n" +
            "JOIN product_Type ON pd.product_Type_id = product_Type.id \n" +
            "where pd.product_code = :product_code and pd.product_name = :product_name", nativeQuery = true)
    List<Product> queryProductCodeAndProductName(@Param("product_code") String productCode, @Param("product_name") String productName);

    @Query(value = "select pd.product_code from product pd \n" +
            "JOIN product_Type ON pd.product_Type_id = product_Type.id \n" +
            "where pd.product_code = :product_code", nativeQuery = true)
    List<Product> queryByProductCode(@Param("product_code") String productCode);

    Optional<Product> findByProductCode(String productCode);

}
