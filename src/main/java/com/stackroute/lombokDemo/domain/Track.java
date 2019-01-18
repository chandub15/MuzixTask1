package com.stackroute.lombokDemo.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

// if we use lombok plugin we can use plugins
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor //instead of getter,setter,allargs,noargs we can use @Data
public class Track {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String comment;

}
