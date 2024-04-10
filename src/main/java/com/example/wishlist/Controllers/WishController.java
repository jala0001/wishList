package com.example.wishlist.Controllers;

import com.example.wishlist.repositories.WishRepository;
import com.example.wishlist.services.WishService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.net.http.HttpClient;

@Controller
public class WishController {
@Autowired
    private WishService wishService;


    @GetMapping("/addUser")
    public String addUser() {
    return "home/addUser";
}

@PostMapping("/addUser")
    public String addUser(@RequestParam String username, @RequestParam String userEmail) {
    wishService.addUser(username, userEmail);
    return "redirect:/";
}

@GetMapping("/userWishList")
    public String pickUser(@RequestParam int id, Model model) {
    model.addAttribute(wishService.getUser(id));
    return "home/wishList";
}
}
