package com.example.chekout;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SupermarketCheckoutApplicationTests {

	private CheckoutService checkoutService;

    @BeforeEach
    public void setUp() {
        Map<String, Item> pricingRules = new HashMap<>();
        pricingRules.put("A", new Item("A", 50, new SpecialPrice(3, 130)));
        pricingRules.put("B", new Item("B", 30, new SpecialPrice(2, 45)));
        pricingRules.put("C", new Item("C", 20, null));
        pricingRules.put("D", new Item("D", 15, null));

        checkoutService = new CheckoutService(pricingRules);
    }

    @Test
    public void testScanSingleItem() {
        checkoutService.scan("A");
        assertEquals(50, checkoutService.total());
    }

    @Test
    public void testScanMultipleItems_NoSpecialPrice() {
        checkoutService.scan("A");
        checkoutService.scan("C");
        assertEquals(70, checkoutService.total());
    }

    @Test
    public void testScanMultipleItems_WithSpecialPrice() {
        checkoutService.scan("A");
        checkoutService.scan("A");
        checkoutService.scan("A");
        assertEquals(130, checkoutService.total());
    }

    @Test
    public void testScanDifferentItems_WithSpecialPrice() {
        checkoutService.scan("A");
        checkoutService.scan("A");
        checkoutService.scan("A");
        checkoutService.scan("B");
        checkoutService.scan("B");
        assertEquals(175, checkoutService.total());
    }

    @Test
    public void testScanMultipleItems_MixedSpecialAndRegular() {
        checkoutService.scan("A");
        checkoutService.scan("A");
        checkoutService.scan("B");
        checkoutService.scan("B");
        checkoutService.scan("D");
        assertEquals(160, checkoutService.total());
    }

    @Test
    public void testScanNoItems() {
        assertEquals(0, checkoutService.total());
    }
}
