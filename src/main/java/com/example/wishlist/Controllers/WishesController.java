package com.example.wishlist.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class WishesController {

    @GetMapping("/wishlistAdd")
    public String showWishList(Model model){
        return "home/wishlist";
    }
    @PostMapping("/wishlist/add/action")
    public String addWishList(@RequestParam String title, @RequestParam String link, @RequestParam String note ){
        return "redirect:/wishlist";
    }

}
