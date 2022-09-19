package ru.kata.spring.boot_security.demo.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.UserService;

@Controller
public class AdminController {
    @Autowired
    UserService userService;
    @GetMapping("/admin")
    public String getAllUsers(Model model) {
        model.addAttribute("messages", userService.usergtList(0L));
        model.addAttribute("user", new User());
        return  "admin";
    }
    @PostMapping("/save")
    public String createUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/admin";
    }
    @PostMapping("/update")
    public String updateUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);

        return "redirect:/admin";
    }
    @PostMapping("/delete")
    public String deleteUser(@RequestParam ("id_patch") Long id) {
        userService.deleteUser(id);
        return "redirect:/admin";
    }
}
