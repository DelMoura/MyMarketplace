package com.ads.MyMarketplace.Repository;

import com.ads.MyMarketplace.Model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Integer> {

    Admin findByUsername(String username);

}
