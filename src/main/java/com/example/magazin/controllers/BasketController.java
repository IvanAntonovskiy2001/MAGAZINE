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
public class BasketController {

    private final BasketService basketService;
    private final ProductService productService;
    @PostMapping("/basket/create")
    public String createbacket(Basket basket) {
        basketService.saveBasket(basket);
        return "redirect:/";
    }
    @PostMapping("/basket/delete")//удаляет товар
    public String deleteBasket() {
        basketService.deleteAllBasket();
        return "redirect:/";
    }

    @GetMapping("/basket")
    public String basket(@RequestParam(name = "title", required = false) String title, Model model) {
        model.addAttribute("baskets", basketService.listBasket(title));
        List<Basket> baskets = new ArrayList<>();
        baskets = basketService.listBasket(title);
        int temp = 0;
        int quantity = 0;
        for (int i = 0; i<baskets.size(); i++){
            temp += baskets.get(i).getPrice();
            quantity += baskets.get(i).getQuantity();
        }
        model.addAttribute("price",temp);
        model.addAttribute("quantity",quantity);

        return "basket";
    }

    @GetMapping("/cart/{title}")// получает информацию о странице
    public String productInfo(@PathVariable String title, Model model) {
        List<Product> baskets = new ArrayList<>();
        baskets = productService.listProducts(title);
        for (int i = 0 ; i < baskets.size();i++){
            Basket bask = new Basket();
            bask.setId(baskets.get(i).getId());
            bask.setTitle(baskets.get(i).getTitle());
            bask.setName(baskets.get(i).getName());
            bask.setDescription(baskets.get(i).getDescription());
            bask.setPrice(baskets.get(i).getPrice());
            bask.setMagazine(baskets.get(i).getMagazine());
            bask.setQuantity(1);
            basketService.saveBasket(bask);
        }
        return "redirect:/";
    }



    @PostMapping("/cartPlus/{title}")// получает информацию о странице
    public String produc(@PathVariable String title, Model model) {
        List<Basket> baskets = new ArrayList<>();
        baskets = basketService.listBasket(title);
        for (int i = 0 ; i < baskets.size();i++){
            Basket bask = new Basket();
            bask.setId(baskets.get(i).getId()+1);
            bask.setTitle(baskets.get(i).getTitle());
            bask.setName(baskets.get(i).getName());
            bask.setDescription(baskets.get(i).getDescription());
            bask.setPrice(baskets.get(i).getPrice());
            bask.setMagazine(baskets.get(i).getMagazine());
            bask.setQuantity(1);
            basketService.saveBasket(bask);
        }
        return "redirect:/basket";
    }


    @GetMapping("/cartMinus/{id}")// получает информацию о странице
    public String productMinus(@PathVariable Long id) {
        basketService.deleteBasket(id);
        return "redirect:/basket";
    }



}
