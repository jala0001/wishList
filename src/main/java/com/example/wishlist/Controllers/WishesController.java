package com.example.wishlist.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.wishlist.Models.WishList;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class WishesController {

    @GetMapping("/wishlistAdd")
    public String showWishList(Model model){
        return "home/wishes";
    }
    @PostMapping("/wishlist/add/action")
    public String addWishList(@RequestParam String title, @RequestParam String note, @RequestParam String link ){
        return "redirect:/wishlist";
    }

}
