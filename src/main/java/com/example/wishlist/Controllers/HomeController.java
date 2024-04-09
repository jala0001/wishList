package com.example.wishlist.Controllers;

import com.example.wishlist.services.WishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
@Autowired
private WishService wishService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("users", wishService.getUsers());
        return "home/index";
    }
}
