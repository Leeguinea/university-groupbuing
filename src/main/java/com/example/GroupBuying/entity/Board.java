package com.example.GroupBuying.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity
public class Board {

    @Id @GeneratedValue
    @Column(name = "board_id")
    private Long id;
    private String title;
    private String recruitment;
    private String item;
    private String content;
    private String category;

}
