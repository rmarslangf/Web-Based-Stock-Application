package com.mert.stok.Controller;

import com.mert.stok.Model.User;
import com.mert.stok.Model.SaleLog;
import com.mert.stok.Repository.UserRepository;
import com.mert.stok.Repository.SaleLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class ContentController {
    private final UserRepository userRepository;
    private final SaleLogRepository saleLogRepository;

    @GetMapping("/login")
    public String login() {
        return "login";
    }
    @GetMapping("/req/signup")
    public String signup() {
        return "signup";
    }
    @GetMapping("/home")
    public String home(Model model, Principal principal) {
        User user = null;
        if (principal != null) {
            user = userRepository.findByUsername(principal.getName()).orElse(null);
        }
        model.addAttribute("user", user);
        List<SaleLog> lastSales = saleLogRepository.findAllOrderBySaleDateDesc().stream().limit(5).toList();
        model.addAttribute("lastSales", lastSales);
        return "home";
    }
    @GetMapping("/home/stock/add")
    public String addProduct() {
        return "add-product";
    }
    @GetMapping("/home/stock/remove")
    public String removeProduct() {
        return "remove-product";
    }
}
