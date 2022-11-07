package com.ads.MyMarketplace.Controller;

import com.ads.MyMarketplace.Model.Admin;
import com.ads.MyMarketplace.Service.AdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/admin")
@Api(value = "API REST do MyMarketplace")
@CrossOrigin(origins = "*")
public class AdminController {

    @Autowired
    public final AdminService service;


    @PostMapping
    @ApiOperation(value = "Esse método cadastra um novo ADMIn")
    public void registerAdmin(@RequestBody Admin admin) {
        this.service.registerAdmin(admin);

    }

    @PostMapping("/loginAdmin")
    @ApiOperation(value = "Esse método irá fazer GERAR UMA CHAVE ADMIN")
    public String loginAdmin(@RequestBody Admin admin) {
        return this.service.loginAdmin(admin);


    }


}
