package com.ads.MyMarketplace.Controller;

import com.ads.MyMarketplace.Model.Product;
import com.ads.MyMarketplace.Model.ProductPost;
import com.ads.MyMarketplace.Service.AdminService;
import com.ads.MyMarketplace.Service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@RequestMapping("/api")
@Api(value = "API REST do MyMarketplace")
@CrossOrigin(origins = "*")
public class ProductController {

    @Autowired
    private ProductService service;


    @GetMapping("/products")
    @ApiOperation(value = "Retorna toda a lista de produtos cadastrados no banco")
    public List<Product> listAllProduct() {
        return service.listAllProduct();
    }

    @GetMapping("/products/{name}")
    @ApiOperation(value = "Retorna um produto específico, digitando o nome do produto ou o tipo do produto")
    public List<Product> findProduct(@PathVariable("name") String name, @PathVariable("name") String tipo) {
        List<Product> prod = service.findProduct(name, tipo);

        return prod;

    }

    @PostMapping
    @ApiOperation(value = "Salva no banco um produto novo, sendo administrador.")
    public void saveProduct(@RequestBody ProductPost product) {
        service.saveProduct(product);
    }

    @DeleteMapping("/{id}/key/{chave}")
    @ApiOperation(value = "Esse método irá deletar um produto, colocando o ID e a Chave ADMIN no corpo da requisição")
    public void deletProduct(@PathVariable("id") Integer id, @PathVariable("chave") String key) {
        this.service.deletProduct(id, key);
    }

    @PutMapping("/{id}/newPrice/{price}/keyPass/{key}")
    @ApiOperation(value = "Esse método irá atualizar o preço de um Produto, colocando o ID do produto, o novo VALOR e a CHAVE ADMIN")
    public void updatePrice(@PathVariable("id") Integer id, @PathVariable("price") Double price, @PathVariable("key") String keypass) {
        this.service.updatePrice(id, price, keypass);
    }

    @PutMapping("/{id}/newInventory/{inventory}/keyPass/{key}")
    @ApiOperation(value = "Esse método irá atualizar o estoque de um Produto, colocando o ID do produto, o novo ESTOQUE e a CHAVE ADMIN")
    public void updateIventory(@PathVariable("id") Integer id, @PathVariable("inventory") Integer inventory, @PathVariable("key") String keypass) {
        this.service.updateInventory(id, inventory, keypass);
    }


}
