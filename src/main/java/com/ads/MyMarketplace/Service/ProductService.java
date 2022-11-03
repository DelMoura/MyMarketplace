package com.ads.MyMarketplace.Service;

import com.ads.MyMarketplace.Model.Product;
import com.ads.MyMarketplace.Model.ProductPost;
import com.ads.MyMarketplace.Repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

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

    public void deleteProduct(){
        
    }


}
