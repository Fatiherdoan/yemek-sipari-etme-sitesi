package com.Efxpress.efxpressfatih.dto;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;
@Entity
@Table(name = "SepetUrunleri")
@Data
@Setter
@Getter
public class SepetDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "SiparisId", referencedColumnName = "id", insertable = false, updatable = false)
    private SiparisDto siparis;
    @ManyToOne
    @JoinColumn(name = "UrunId", referencedColumnName = "id", insertable = false, updatable = false)
    private Menudto urun;
    @Column(name = "Miktar")
    private int miktar;
    @Column(name = "Fiyat")
    private double fiyat;
    public void setOlusturulmaTarihi(LocalDateTime now) {
    }
    public void setDurum(String eklendi) {
    }
    public void setGuncellemeTarihi(LocalDateTime now) {
    }
    public double getIndirim() {
        return 0;
    }
}
