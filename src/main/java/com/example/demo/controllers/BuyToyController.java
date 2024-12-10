package com.example.demo.controllers;


import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class BuyToyController {

    @Autowired
    private ProductRepository  toyRepository;

    @PostMapping("/buyToy")
    public String buyToy(@RequestParam("toyID") Long theId, Model theModel) {
        // Retrieve the toy from the database using its ID
        Optional<Product> toyToBuy = toyRepository.findById(theId);

        // Check if the toy exists
        if (toyToBuy.isPresent()) {
            Product toy = toyToBuy.get();

            // Check if the toy has inventory available
            if (toy.getInv() > 0) {
                // Decrease inventory by 1
                toy.setInv(toy.getInv() - 1);
                toyRepository.save(toy); // Save the updated toy to the database

                // Redirect to success page if purchase was successful
                return "redirect:/purchaseSuccess";
            } else {
                // Redirect to failure page if toy is out of stock
                return "redirect:/purchaseFailure";
            }
        } else {
            // Redirect to failure page if the toy doesn't exist
            return "redirect:/purchaseFailure";
        }
    }
}

