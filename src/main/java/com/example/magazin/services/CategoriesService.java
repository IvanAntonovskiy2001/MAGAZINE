package com.example.magazin.services;

import com.example.magazin.models.Categories;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CategoriesService {
    private List<Categories> categories = new ArrayList<>();
    private long ID = 0;
    {
        categories.add(new Categories(++ID,"Milk"));
        categories.add(new Categories(++ID,"Meet"));
        categories.add(new Categories(++ID,"Vegetables"));
        categories.add(new Categories(++ID,"Fruit"));
    }

    public List<Categories> listCategories(){return categories;}


}
