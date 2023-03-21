package com.kaltz.galaxy.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Item {

    private Long id;
    private String name;
    private int price;
    private int stockQuantity;

    //==비즈니스 로직==//
    /**
     * stock 증가
     */
    public void addStock(int quantity) {
        this.stockQuantity += quantity;
    }

    /**
     * stock 감소
     */
    public void removeStock(int quantity) {
        int restStock = this.stockQuantity - quantity;
        if (restStock < 0) {
            throw new RuntimeException("need more stock");
        }
        this.stockQuantity = restStock;
    }
}
