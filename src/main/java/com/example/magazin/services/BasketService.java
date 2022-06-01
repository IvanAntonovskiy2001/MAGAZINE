package com.example.magazin.services;

import com.example.magazin.models.Basket;
import com.example.magazin.repositories.BasketRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
@Data
public class BasketService {
    private final BasketRepository basketRepository;

    public List<Basket> listBasket(String title) {
        List<Basket> products = basketRepository.findAll();
        if(title != null) basketRepository.findByTitle(title);
        return products;
    }


    public void saveBasket(Basket product) {
        log.info("Saving ne {}",product);
        basketRepository.save(product);
    }

    public void deleteBasket(Long id) {
        basketRepository.deleteById(id);
    }

    public void deleteAllBasket() {
        basketRepository.deleteAll();
    }

    public Basket getBasketById(Long id)  {
        return basketRepository.findById(id).orElse(null);
    }


}
