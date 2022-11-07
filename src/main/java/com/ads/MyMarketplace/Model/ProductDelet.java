package com.ads.MyMarketplace.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ProductDelet extends Product {

    private String key;


    public ProductDelet(Integer id, String name, String tipo, Double valor, Integer estoque, String key) {
    }
}
