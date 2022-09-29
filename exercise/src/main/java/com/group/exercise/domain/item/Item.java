package com.group.exercise.domain.item;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Item {

    private Long id;
    private String itemName;
    private Integer price;
    private Integer quantity;

    public Item() {
    }

    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public void update(Item updateParam) {
        itemName = updateParam.getItemName();
        price = updateParam.getPrice();
        quantity = updateParam.getQuantity();
    }
}
