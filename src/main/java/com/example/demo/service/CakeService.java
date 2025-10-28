package com.example.demo.service;

import com.example.demo.model.Cake;
import com.example.demo.repository.CakeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CakeService {
    @Autowired
    private CakeRepository cakeRepository;

    public List<Cake> getAllCakes() {
        return cakeRepository.findAll();
    }

    public Cake getCakeById(Long id) {
        return cakeRepository.findById(id).orElse(null);
    }

    public Cake saveCake(Cake cake) {
        return cakeRepository.save(cake);
    }
    public void deleteCake(Long id) {
        cakeRepository.deleteById(id);
    }
}

