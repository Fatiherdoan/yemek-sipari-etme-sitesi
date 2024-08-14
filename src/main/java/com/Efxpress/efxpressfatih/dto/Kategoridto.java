package com.Efxpress.efxpressfatih.dto;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "kategoriler")
@Data
public class Kategoridto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ad;

}
