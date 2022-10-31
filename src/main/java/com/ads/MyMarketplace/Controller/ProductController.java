package com.ads.MyMarketplace.Controller;

import com.ads.MyMarketplace.Model.Product;
import com.ads.MyMarketplace.Service.ProductService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@AllArgsConstructor
@NoArgsConstructor
@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping
    public List<Product> listAllProduct(){
        return service.listAllProduct();
    }

}
