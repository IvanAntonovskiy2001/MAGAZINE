package com.example.magazin.controllers;

import com.example.magazin.models.Basket;
import com.example.magazin.models.Product;
import com.example.magazin.services.BasketService;
import com.example.magazin.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    private final BasketService basketService;

    @GetMapping("/")
    public String products(@RequestParam(name = "title", required = false) String title, Model model) {
        List<Basket> baskets = new ArrayList<>();
        baskets = basketService.listBasket(title);
        if(baskets.size() == 0){
            int temp = 0;
            int quantity = 0;
            model.addAttribute("products", productService.listProducts(title));
            model.addAttribute("price",temp);
            model.addAttribute("quantity",quantity);
            return "products";
        } else {
            model.addAttribute("products", productService.listProducts(title));
            int temp = 0;
            int quantity = 0;
            for (int i = 0; i<baskets.size(); i++){
                temp += baskets.get(i).getPrice();
                quantity += baskets.get(i).getQuantity();
            }
            model.addAttribute("price",temp);
            model.addAttribute("quantity",quantity);
            return "products";
        }
    }

    @GetMapping("/product/{id}")
    public String productInfo(@PathVariable Long id, Model model) {
        model.addAttribute("product", productService.getProductById(id));
        return "product-info";
    }

    @GetMapping("/product/create")
    public String productInfo() {
        return "product-create";
    }


    @PostMapping("/product/create")
    public String createProduct(Product product) {
        productService.saveProduct(product);
        return "redirect:/";
    }

    @PostMapping("/product/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return "redirect:/";
    }
}
