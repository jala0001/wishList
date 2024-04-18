package com.example.wishlist.Controllers;

import com.example.wishlist.models.User;
import com.example.wishlist.repositories.UserRepository;

import com.example.wishlist.models.WishList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



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
        model.addAttribute("wishLists", userService.getWishLists(id));
        model.addAttribute("sharedWishlists", userService.getSharedWishlists(id));
        return "home/wishList";
    }


    @GetMapping("/addWishList")
    public String addWishList(@RequestParam int id, Model model) {
        model.addAttribute(userService.getUser(id));
        return "home/addWishList";
    }

    @PostMapping("/addWishListAction")
    public String addWishListAction(@RequestParam String header, @RequestParam int id) {
        userService.addWishList(header, id);
        return "redirect:/userWishList?id=" + id;
    }

    @GetMapping("/chooseWishList")
    public String chooseWishList(@RequestParam int wishlistId, Model model) {
        model.addAttribute(userService.getWishList(wishlistId)); // netop tilføjet
        model.addAttribute("wishes", userService.getWishes(wishlistId)); // netop tilføjet
        return "home/chosenWishList";
    }

    @GetMapping("/updateWishList")
    public String updateWishList(@RequestParam int wishlistId, Model model){
        model.addAttribute(userService.getWishList(wishlistId));
        return "home/updateWishList";
    }

    @PostMapping("/editWishList")
    public String editWishList(@RequestParam String header, @RequestParam int wishlistId, @RequestParam int id){
        userService.editWishList(header, wishlistId);
        return "redirect:/userWishList?id=" + id;
    }

    @PostMapping("/deleteWishList")
    public String deleteWishList(@RequestParam int wishlistId, @RequestParam int id) {
        userService.deleteUser(wishlistId);
        return "redirect:/userWishList?id=" + id;
    }

    @PostMapping("/deleteWish")
    public String deleteWish(@RequestParam int wishId, int wishlistId) {
        userService.deleteWish(wishId);
        return "redirect:/chooseWishList?wishlistId=" + wishlistId;
    }

    @GetMapping("/addWish")
    public String addWish(@RequestParam int wishlistId, Model model) {
        model.addAttribute(userService.getWishList(wishlistId));
        return "home/addWish";
    }

    /* @PostMapping("/addWishAction")
    public String addWish(@RequestParam String header, @RequestParam String link,
                          @RequestParam double price, @RequestParam String note,
                          @RequestParam int wishlistId) {
        userService.addWish(header, link, price, note, wishlistId);
        return "redirect:/chooseWishList?wishlistId=" + wishlistId;
    }
     */

    @PostMapping("/addWishAction") // NYT EMILIA
    public String addWish(@RequestParam String header, @RequestParam String link,
                          @RequestParam double price, @RequestParam String note,
                          @RequestParam int wishlistId) {
        if (userService.isValidURL(link)) {
            userService.addWish(header, link, price, note, wishlistId);
            return "redirect:/chooseWishList?wishlistId=" + wishlistId;
        } else {
            return "redirect:/invalidURL"; // Omdiriger til en side, der viser en fejlbesked
        }
    }

    @GetMapping("/shareWishList")
    public String shareWishList(@RequestParam int wishlistId, @RequestParam int id, Model model) {
        model.addAttribute(userService.getWishList(wishlistId));
        model.addAttribute("users", userService.getUsers());
        return "home/shareWishList";
    }

    @GetMapping("/invalidURL") // NYT EMILIA
    public String showInvalidURLPage() {
        return "invalidURL";
    }

    @PostMapping("/shareWishListAction")
    public String shareWishList(@RequestParam int wishlistId, @RequestParam int userId) {
        userService.shareWithUser(wishlistId, userId);
        return "redirect:/chooseWishList?wishlistId=" + wishlistId;
    }

    @GetMapping("/pickSharedWishList")
    public String pickSharedWishList(@RequestParam int sharedWishLists, @RequestParam int id, Model model) {
        model.addAttribute(userService.getWishList(sharedWishLists)); // Overskriften på ønskelisten
        model.addAttribute("wishes", userService.getWishes(sharedWishLists)); // alle ønskerne i listen
        model.addAttribute("goBack", userService.getUser(id));
        return "home/sharedWishList";
    }

    @PostMapping("/reserveWish")
    public String reserveWish(@RequestParam int wishId, @RequestParam int sharedWishLists,
                              @RequestParam int id) {
        userService.reserveWish(wishId);
        return "redirect:/pickSharedWishList?sharedWishLists=" + sharedWishLists + "&id=" + id;
    }
}



