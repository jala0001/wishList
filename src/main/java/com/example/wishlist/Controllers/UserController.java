package com.example.wishlist.Controllers;

import com.example.wishlist.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    @Autowired
    private com.example.wishlist.services.UserService userService;

    @GetMapping("/addUser")
    public String addUser() {
        return "home/addUser";
    }

    @PostMapping("/addUser")
    public String addUser(@RequestParam String username, @RequestParam String userEmail, @RequestParam String password) {
        userService.addUser(username, userEmail, password);
        return "redirect:/";
    }

    @GetMapping("/verifyPassword")
    public String verifyPassword(@RequestParam int id, Model model) {
        model.addAttribute(userService.getUser(id));
        return "home/verifyPassword";
    }

    @PostMapping("/verifyPasswordAction")
    public String verifyPassword(@RequestParam String password, @RequestParam int id, Model model) {
        User user = userService.getUser(id);
        if (user.getPassword().equals(password)) {
            // Redirect til /userWishList med id som query parameter
            return "redirect:/userWishList?id=" + id;
        } else {
            model.addAttribute(userService.getUser(id));
            model.addAttribute("error", "forkert adgangskode");
            return "home/verifyPassword"; // Her ændres redirect til at vise samme side med fejlbeskeden
        }
    }

    @GetMapping("/userWishList")
    public String pickUser(@RequestParam int id, Model model) {
        model.addAttribute(userService.getUser(id));
        return "home/wishList";
    }

}
