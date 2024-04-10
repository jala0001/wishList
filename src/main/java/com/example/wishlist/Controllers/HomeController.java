package com.example.wishlist.Controllers;

import com.example.wishlist.Services.WishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
@Autowired
private WishListService wishListService;

    @GetMapping("/")

    public String index(Model model) {
        model.addAttribute("users", wishListService.getUsers());
        return "home/index";
    }
}
