package com.ads.MyMarketplace.Controller;

import com.ads.MyMarketplace.Model.Product;
import com.ads.MyMarketplace.Service.AdminService;
import com.ads.MyMarketplace.Service.ProductService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@AllArgsConstructor
@NoArgsConstructor
@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService service;
    private AdminService serviceAdmin;

    @GetMapping
    public List<Product> listAllProduct() {
        return service.listAllProduct();
    }

    @GetMapping("/{name}")
    @ResponseBody
    public List<Product> findProduct(@PathVariable("name") String name, @PathVariable("name") String tipo) {
        List<Product> prod = service.findProduct(name, tipo);

        return prod;

    }

    @PostMapping
    @ResponseBody
    public void saveProdoct(Product product) {
        String username = "Admin123";
        String password = "321";
        serviceAdmin.saveProduct(username, password,product);
    }


}
