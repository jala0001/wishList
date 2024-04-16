package com.example.wishlist.Controllers;

import com.example.wishlist.models.User;
import com.example.wishlist.models.WishList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private com.example.wishlist.services.UserService userService;

    @GetMapping("/")

    public String index(Model model) {
        model.addAttribute("users", userService.getUsers());
        return "home/index";
    }

}