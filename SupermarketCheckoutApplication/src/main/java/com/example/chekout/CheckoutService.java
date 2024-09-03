package com.example.chekout;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class CheckoutService {
	
	private Map<String, Integer> scannedItems;
    private Map<String, Item> pricingRules;


    public CheckoutService(Map<String, Item> pricingRules2) {
    	 this.scannedItems = new HashMap<>();
         this.pricingRules = pricingRules;
	}

	public void scan(String name) {
        scannedItems.put(name, scannedItems.getOrDefault(name, 0) + 1);
    }

    public int total() {
        int total = 0;
        for (Map.Entry<String, Integer> entry : scannedItems.entrySet()) {
            String sku = entry.getKey();
            int quantity = entry.getValue();
            Item item = pricingRules.get(sku);

            if (item != null) {
                total += calculatePrice(item, quantity);
            }
        }
        return total;
    }
    
    private int calculatePrice(Item item, int quantity) {
        int total = 0;
        SpecialPrice specialPrice = item.getSpecialPrice();

        if (specialPrice != null && quantity >= specialPrice.getQuantity()) {
            int specialQuantity = quantity / specialPrice.getQuantity();
            int remainder = quantity % specialPrice.getQuantity();
            total += specialQuantity * specialPrice.getPrice() + remainder * item.getUnitPrice();
        } else {
            total += quantity * item.getUnitPrice();
        }

        return total;
    }
}
