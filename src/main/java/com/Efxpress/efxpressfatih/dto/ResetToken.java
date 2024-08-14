package com.Efxpress.efxpressfatih.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.security.core.userdetails.User;
import java.time.LocalDateTime;
@Entity
public class ResetToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Birincil anahtar alanı

    private String token;
    private LocalDateTime gecerlilikSuresi;
    private User kullanici;
    // Getter ve setter metotları
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public LocalDateTime getGecerlilikSuresi() {
        return gecerlilikSuresi;
    }

    public void setGecerlilikSuresi(LocalDateTime gecerlilikSuresi) {
        this.gecerlilikSuresi = gecerlilikSuresi;
    }

    public User getKullanici() {
        return kullanici;
    }

    public void setKullanici(User kullanici) {
        this.kullanici = kullanici;
    }

    // Kurucu metot
    public ResetToken(String token, LocalDateTime gecerlilikSuresi, User kullanici) {
        this.token = token;
        ResetToken his;
        his = null;
        his.kullanici = kullanici;
    }

}
