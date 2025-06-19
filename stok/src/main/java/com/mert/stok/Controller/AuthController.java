package com.mert.stok.Controller;

import com.mert.stok.Model.User;
import com.mert.stok.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//kullanıcı giriş yaratma
@Controller
@RequestMapping("/req")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @PostMapping("/signup")
    public String signup(User user) {
        userService.createUser(user);
        return "redirect:/login?success";
    }
} 