package com.api.demo.inven.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(
                name = "UNIQ_PRD_NM_OPTN_NM",
                columnNames = {"prdNm", "optnNm"}
        )
})
public class Inven {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String prdNm;
    @Column(nullable = false, length = 100)
    private String optnNm;

    private int prdQnty;

    @Builder
    public Inven(String prdNm, String optnNm, int prdQnty) {
        this.prdNm = prdNm;
        this.optnNm = optnNm;
        this.prdQnty = prdQnty;
    }
}
