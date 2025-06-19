package com.mert.stok.Controller;

import com.mert.stok.Model.SaleLog;
import com.mert.stok.Repository.SaleLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/home/sales")
@RequiredArgsConstructor
public class SaleLogController {
    
    private final SaleLogRepository saleLogRepository;

    @GetMapping
    public String getSaleLogs(Model model) {
        List<SaleLog> saleLogs = saleLogRepository.findAllOrderBySaleDateDesc();
        model.addAttribute("saleLogs", saleLogs);
        return "sale-logs";
    }
} 