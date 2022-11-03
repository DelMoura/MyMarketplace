package com.ads.MyMarketplace.Controller;

import com.ads.MyMarketplace.Model.Admin;
import com.ads.MyMarketplace.Service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    public final AdminService service;


    @PostMapping
    public void registerAdmin(@RequestBody Admin admin) {
        this.service.registerAdmin(admin);

    }

    @PostMapping("/loginAdmin")
    public String loginAdmin(@RequestBody Admin admin) {
        return this.service.loginAdmin(admin);


    }

}
