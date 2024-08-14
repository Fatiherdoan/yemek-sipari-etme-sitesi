package com.Efxpress.efxpressfatih.dto;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Set;
@Entity
@Table(name = "Siparisler")
@Data
@Getter
@Setter
public class SiparisDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToMany(mappedBy = "siparis", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<SepetDto> sepetUrunleri;

    @Column(name = "MusteriAdi")
    private String musteriAdi;

    @Column(name = "MusteriAdresi")
    private String musteriAdresi;
}
