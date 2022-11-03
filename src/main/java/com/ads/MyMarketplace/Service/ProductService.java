package com.ads.MyMarketplace.Service;

import com.ads.MyMarketplace.Model.Product;
import com.ads.MyMarketplace.Repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {


    private ProductRepository repository;


    public List<Product> listAllProduct() {
        return repository.findAll();
    }

    public List<Product> findProduct(String name, String tipo) {
        return repository.findByNameOrTipo(name, tipo);

    }

    public void saveProduct(Product prod) {
        repository.save(prod);
    }


}
