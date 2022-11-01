package com.ads.MyMarketplace.Repository;

import com.ads.MyMarketplace.Model.Product;
import com.mysql.cj.QueryResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {


    List<Product> findAllByName(String name);

}