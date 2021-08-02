package com.tutuman.inventoryservice.web;

import com.tutuman.inventoryservice.model.Inventory;
import com.tutuman.inventoryservice.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/inventory")
public class InventoryController {

    private final InventoryRepository inventory;
    @GetMapping
    public Boolean isInStock(@PathVariable String skuCode){

        Inventory inv= inventory.findBySkuCode(skuCode).orElseThrow(()-> new RuntimeException(""));
        return inv.getStock()>0;

    }
}
