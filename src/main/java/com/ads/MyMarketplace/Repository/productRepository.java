package com.ads.MyMarketplace.Repository;

import com.ads.MyMarketplace.Model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface productRepository extends JpaRepository<Produto, Integer> {
}
