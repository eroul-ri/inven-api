package com.api.demo.inven.domain;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@Entity
public class Inven {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String prdNm;
    private String optnNm;

    private int prdQnty;

    @Builder
    public Inven(String prdNm, String optnNm, int prdQnty) {
        this.prdNm = prdNm;
        this.optnNm = optnNm;
        this.prdQnty = prdQnty;
    }
}
