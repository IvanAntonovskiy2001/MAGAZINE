package com.example.magazin.repositories;

import com.example.magazin.models.Basket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BasketRepository extends JpaRepository<Basket,Long> {
    List<Basket> findByTitle(String title);
}
