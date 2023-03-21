package com.kaltz.galaxy.repository;

import com.kaltz.galaxy.domain.Item;

import java.util.List;

public interface ItemRepository {

    Item save(Item item);

    Item findOne(Long id);

    List<Item> findAll();

    void clear();
}
