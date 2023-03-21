package com.kaltz.galaxy.repository;

import com.kaltz.galaxy.config.AppConfig;
import com.kaltz.galaxy.domain.Album;
import com.kaltz.galaxy.domain.Book;
import com.kaltz.galaxy.domain.Item;
import com.kaltz.galaxy.domain.Movie;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ItemRepositoryImplTest {

    ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
    ItemRepository itemRepository = ac.getBean("itemRepository", ItemRepository.class);

    @BeforeEach
    void beforeEach() {
        itemRepository.clear();
    }

    @Test
    void save() {
        //given
        Book book = new Book();
        book.setAuthor("Goethe");
        book.setIsbn("15151");
        book.setName("Age of study");

        //when
        Item savedItem = itemRepository.save(book);
        Item findItem = itemRepository.findOne(savedItem.getId());

        //then
        assertThat(findItem).isNotNull();

    }

    @Test
    void findOne() {
        //given
        Movie movie = new Movie();
        movie.setActor("david");
        movie.setDirector("yarn");
        movie.setName("troy");

        //when
        Item savedItem = itemRepository.save(movie);
        Item findItem = itemRepository.findOne(savedItem.getId());

        //then
        assertThat(findItem).isEqualTo(movie);
    }

    @Test
    void findAll() {
        //given
        Movie movie = new Movie();
        Book book = new Book();
        Album album = new Album();

        itemRepository.save(movie);
        itemRepository.save(book);
        itemRepository.save(album);

        //when
        List<Item> result = itemRepository.findAll();

        //then
        assertThat(result.size()).isEqualTo(3);
    }
}