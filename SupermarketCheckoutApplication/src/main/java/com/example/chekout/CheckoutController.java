package com.example.chekout;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/checkout")
public class CheckoutController {
	 
	private final CheckoutService checkoutService;

    @Autowired
    public CheckoutController(Map<String, Item> pricingRules) {
        this.checkoutService = new CheckoutService(pricingRules);
    }

    @PostMapping("/scan/{name}")
    public void scanItem(@PathVariable String name) {
        checkoutService.scan(name);
    }

    @GetMapping("/total")
    public int getTotal() {
        return checkoutService.total();
    }
}
