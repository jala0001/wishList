package com.example.wishlist.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WishListController {
    @Autowired
    private com.example.wishlist.Services.WishListService wishListService;

    @GetMapping("/addUser")
    public String addUser() {
        return "home/addUser";
    }

    @PostMapping("/addUser")
    public String addUser(@RequestParam String username, @RequestParam String userEmail) {
        wishListService.addUser(username, userEmail);
        return "redirect:/";
    }

    @GetMapping("/userWishList")
    public String pickUser(@RequestParam int id, Model model) {
        model.addAttribute(wishListService.getUser(id));
        return "home/wishList";
    }
}
