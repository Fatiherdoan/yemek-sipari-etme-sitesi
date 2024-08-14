package com.Efxpress.efxpressfatih.dto;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "menuler")
@Data
@Setter
@Getter
public class Menudto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ad;
    private String aciklama;
    private Double fiyat;
    public Menudto getStok(Menudto menudto) {
        Menudto stok;

        Menudto menudto1;
        menudto1 = menudto;
        return menudto1;
    }


    }

