package com.example.demo.controller;

import com.example.demo.model.Cake;
import com.example.demo.service.CakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/cakes")
@Tag(name = "Cakes", description = "Cake Management System")
public class CakeController {

    @Autowired
    private CakeService cakeService;

    @GetMapping
    @Operation(summary = "View a list of available cakes")
    public List<Cake> getAllCakes() {
        return cakeService.getAllCakes();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a cake by Id")
    public Cake getcakeById(@PathVariable Long id) {
        return cakeService.getCakeById(id);
    }

    @PostMapping
    @Operation(summary = "Add a new cake")
    public Cake createCake(@RequestBody Cake cake) {
        return cakeService.saveCake(cake);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update an existing cake")
    public Cake updateCake(@PathVariable Long id, @RequestBody Cake cake) {
        Cake existingCake = cakeService.getCakeById(id);
        if (existingCake != null) {
            existingCake.setTitle(cake.getTitle());
            existingCake.setAuthor(cake.getAuthor());
            return cakeService.saveCake(existingCake);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a cake")
    public void deleteCake(@PathVariable Long id) {
        cakeService.deleteCake(id);
    }
}

