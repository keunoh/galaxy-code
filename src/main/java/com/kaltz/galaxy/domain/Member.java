package com.kaltz.galaxy.domain;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Member {

    private Long id;
    private String name;

    public Member() {
    }

    public Member(String name) {
        this.name = name;
    }
}
