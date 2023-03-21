package com.kaltz.galaxy.domain;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Movie extends Item {

    private String director;
    private String actor;
}
