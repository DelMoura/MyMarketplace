package com.ads.MyMarketplace.Controller;

import com.ads.MyMarketplace.Model.Product;
import com.ads.MyMarketplace.Model.ProductPost;
import com.ads.MyMarketplace.Service.AdminService;
import com.ads.MyMarketplace.Service.ProductService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
@NoArgsConstructor
@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService service;


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
    public void saveProduct(@RequestBody ProductPost product) {
        service.saveProduct(product);
    }

    @DeleteMapping("/{id}/key/{chave}")
    @ResponseBody
    public void deletProduct(@PathVariable("id") Integer id, @PathVariable("chave") String key) {
        this.service.deletProduct(id, key);
    }

    @PutMapping("/{id}/newPrice/{price}/keyPass/{key}")
    @ResponseBody
    public void updatePrice(@PathVariable("id") Integer id, @PathVariable("price") Double price, @PathVariable("key") String keypass) {
        this.service.updatePrice(id, price, keypass);
    }
    @PutMapping("/{id}/newInventory/{inventory}/keyPass/{key}")
    @ResponseBody
    public void updateIventory(@PathVariable("id") Integer id, @PathVariable("inventory") Integer inventory, @PathVariable("key") String keypass) {
        this.service.updateInventory(id, inventory, keypass);
    }



}
