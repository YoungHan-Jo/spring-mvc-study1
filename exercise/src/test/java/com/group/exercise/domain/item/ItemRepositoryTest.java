package com.group.exercise.domain.item;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ItemRepositoryTest {

    ItemRepository itemRepository = new ItemRepository();

    @AfterEach
    void afterEach() {
        itemRepository.clear();
    }

    @Test
    public void save() throws Exception {
        //given
        Item item = new Item("item", 10000, 10);

        //when
        Item savedItem = itemRepository.save(item);

        //then
        Item findItem = itemRepository.findById(savedItem.getId());
        assertThat(findItem.getItemName()).isEqualTo(item.getItemName());
        assertThat(findItem.getPrice()).isEqualTo(item.getPrice());
        assertThat(findItem.getQuantity()).isEqualTo(item.getQuantity());
    }


    @Test
    public void findAll() throws Exception {
        //given
        Item itemA = new Item("itemA", 10000, 10);
        Item itemB = new Item("itemB", 20000, 20);

        itemRepository.save(itemA);
        itemRepository.save(itemB);

        //when
        List<Item> items = itemRepository.findAll();

        //then
        assertThat(items.size()).isEqualTo(2);
        assertThat(items).contains(itemA, itemB);

    }

    @Test
    public void update() throws Exception {
        //given
        Item itemA = new Item("itemA", 10000, 10);
        itemRepository.save(itemA);

        Item updateParam = new Item("newItem", 5000, 50);

        //when
        itemRepository.update(itemA.getId(), updateParam);

        //then
        Item findItem = itemRepository.findById(itemA.getId());
        assertThat(findItem.getItemName()).isEqualTo(itemA.getItemName());
        assertThat(findItem.getPrice()).isEqualTo(itemA.getPrice());
        assertThat(findItem.getQuantity()).isEqualTo(itemA.getQuantity());

    }








}