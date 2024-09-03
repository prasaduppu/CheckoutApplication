package com.example.chekout;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SupermarketCheckoutApplication {

	public static void main(String[] args) {
		SpringApplication.run(SupermarketCheckoutApplication.class, args);
	}

	@Bean
    public Map<String, Item> pricingRules() {
        Map<String, Item> pricingRules = new HashMap<>();
        pricingRules.put("A", new Item("A", 50, new SpecialPrice(3, 130)));
        pricingRules.put("B", new Item("B", 30, new SpecialPrice(2, 45)));
        pricingRules.put("C", new Item("C", 20, null));
        pricingRules.put("D", new Item("D", 15, null));
        return pricingRules;
    }
}
