package com.ads.MyMarketplace.Service;

import com.ads.MyMarketplace.Model.Product;
import com.ads.MyMarketplace.Model.ProductPost;
import com.ads.MyMarketplace.Repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@Service
@AllArgsConstructor
public class ProductService {


    private ProductRepository repository;
    private KeyAdminService key;


    public List<Product> listAllProduct() {
        return repository.findAll();
    }

    public List<Product> findProduct(String name, String tipo) {
        return repository.findByNameOrTipo(name, tipo);

    }

    public void saveProduct(ProductPost prod) {
        if (prod.getKey().equals(key.getKEY())) {
            var produtos = Product.builder().estoque(prod.getEstoque())
                    .name(prod.getName()).tipo(prod.getTipo()).valor(prod.getValor()).build();

            this.repository.save(produtos);

        } else {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        }
    }


    public void deletProduct(Integer id, String keyPass) {

        if (keyPass.equals(key.getKEY())) {
            this.repository.deleteById(id);
        } else {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        }


    }

    public void updatePrice(Integer id, Double price, String keyPass) {
        if (keyPass.equals(key.getKEY())) {
            Optional<Product> prod = this.repository.findById(id);

            if (prod.get().getId().equals(id)) {
                prod.get().setValor(price);
                this.repository.save(prod.get());


            }


        } else {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        }


    }

    public void updateInventory(Integer id, Integer inventory, String keyPass) {
        if (keyPass.equals(key.getKEY())) {
            Optional<Product> prod = this.repository.findById(id);

           
            if (prod.get().getId().equals(id)) {
                prod.get().setEstoque(inventory);
                this.repository.save(prod.get());


            }


        } else {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        }


    }


}
