package hello.itemservice.domain.item;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Member;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class ItemRepositoryTest {

    ItemRepository itemRepository = new ItemRepository();

    @AfterEach
    void afterEach() {
        itemRepository.clearStore();
    }

    @Test
    public void save() throws Exception {
        //given
        Item item = Item.builder()
                .itemName("itemA")
                .price(10000)
                .quantity(10)
                .build();

        //when
        Item saveItem = itemRepository.save(item);

        //then
        Item findItem = itemRepository.findById(item.getId());
        assertThat(findItem).isEqualTo(findItem);

    }

    
    @Test
    public void findAll() throws Exception {
        //given
        Item itemA = Item.builder()
                .itemName("itemA")
                .price(10000)
                .quantity(10)
                .build();

        Item itemB = Item.builder()
                .itemName("itemB")
                .price(20000)
                .quantity(20)
                .build();

        itemRepository.save(itemA);
        itemRepository.save(itemB);

        //when
        List<Item> items = itemRepository.findAll();

        //then
        assertThat(items).contains(itemA, itemB);
      
    }

    @Test
    public void updateItem() throws Exception {
        //given
        Item itemA = Item.builder()
                .itemName("itemA")
                .price(10000)
                .quantity(10)
                .build();
        itemRepository.save(itemA);

        //when
        Item updateParam = Item.builder()
                .itemName("changeName")
                .price(30000)
                .quantity(30)
                .build();

        itemRepository.update(itemA.getId(), updateParam);

        //then
        Item findItem = itemRepository.findById(itemA.getId());
        assertThat(findItem.getItemName()).isEqualTo(updateParam.getItemName());
        assertThat(findItem.getPrice()).isEqualTo(updateParam.getPrice());
        assertThat(findItem.getQuantity()).isEqualTo(updateParam.getQuantity());

    }

    
    


}