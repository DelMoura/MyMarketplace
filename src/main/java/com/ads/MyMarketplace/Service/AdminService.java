package com.ads.MyMarketplace.Service;

import com.ads.MyMarketplace.Model.Product;
import com.ads.MyMarketplace.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    private ProductRepository repositoryProd;


    public List<Product> listAllProduct() {
        return repositoryProd.findAll();
    }

    public List<Product> findProduct(String name, String tipo) {
        return repositoryProd.findByNameOrTipo(name, tipo);

    }

    public void saveProduct(Product products) {
            repositoryProd.save(products);
    }


}
