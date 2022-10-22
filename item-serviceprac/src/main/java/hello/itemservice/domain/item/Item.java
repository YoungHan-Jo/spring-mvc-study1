package hello.itemservice.domain.item;

import lombok.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Item {

    private Long id;
    private String itemName;
    private Integer price;
    private Integer quantity;

    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void update(Item param) {
        this.itemName = param.getItemName();
        this.price = param.getPrice();
        this.quantity = param.getQuantity();
    }
}
