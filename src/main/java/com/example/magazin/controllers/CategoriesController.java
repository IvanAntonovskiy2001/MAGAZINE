package com.example.magazin.controllers;

import com.example.magazin.models.Product;
import com.example.magazin.services.CategoriesService;
import com.example.magazin.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class CategoriesController {
    private final CategoriesService categoriesService;
    private final ProductService productService;

    @GetMapping("/categories")
    public String getCategories(Model model){
        model.addAttribute("categories", categoriesService.listCategories());
        return "categories";
    }

    @GetMapping("/categories/{title}")
    public String getCategoriesProduct(@PathVariable String title, Model model){
        List<Product> products = productService.listProducts(title);
        model.addAttribute("categories",products );
        return "categories-product";
    }


}
