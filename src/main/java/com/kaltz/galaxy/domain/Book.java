package com.kaltz.galaxy.domain;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Book extends Item {

    private String author;
    private String isbn;
}
