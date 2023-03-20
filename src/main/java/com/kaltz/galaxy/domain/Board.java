package com.kaltz.galaxy.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class Board {

    Long id;
    String name;

    public Board() {
    }

    public Board(String name) {
        this.name = name;
    }


}
