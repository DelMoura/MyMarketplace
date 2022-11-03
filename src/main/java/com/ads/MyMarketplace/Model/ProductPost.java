package com.ads.MyMarketplace.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductPost {
    private String name;
    private String tipo;
    private Double valor;
    private Integer estoque;
    private String key;
}
