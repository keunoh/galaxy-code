package com.kaltz.galaxy.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ItemTest {

    @Test
    void addStock() {
        //given
        Item item = new Book();

        item.addStock(10);
        //when
        int stockQuantity = item.getStockQuantity();

        //then
        assertThat(stockQuantity).isEqualTo(10);
    }

    @Test
    void removeStock() {
        //given
        Item item = new Book();
        item.setStockQuantity(100);

        //when
        item.removeStock(50);
        int stockQuantity = item.getStockQuantity();

        //then
        assertThat(stockQuantity).isEqualTo(50);
    }
}