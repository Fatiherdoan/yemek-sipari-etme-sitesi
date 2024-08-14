package com.Efxpress.efxpressfatih.dto;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "kullanici")
@Data
public class Userdto {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

        @Column(unique = true, nullable = false)
        private String username;

        @Column(nullable = false)
        private String email;

        @Column(nullable = false)
        private String sifre;

        @Column(nullable = false)
        private String ad;

        @Column(nullable = false)
        private String soyad;

        @Column(nullable = false)
        private String adres;

        @Column(nullable = false)
        private String telefonNumarası;

        @OneToOne
        private ResetToken resetToken;
        public void setResetToken(String resetCode) {
        }

        public void getAuthorities() {
        }


    public enum Rol {
            USER,
            ADMIN,
            EDITOR
        }

        @Enumerated(EnumType.STRING)
        private Rol rol;


        // Getter ve setter metotları


        public void setSifre(String sifre) throws Exception {
            if (sifre.isEmpty()) {
                throw new Exception("Şifre boş olamaz.");
            }
            this.sifre = sifre;
        }

        public void setAd(String ad) throws Exception {
            if (ad.isEmpty()) {
                throw new Exception("Ad boş olamaz.");
            }
            this.ad = ad;
        }

        public void setSoyad(String soyad) throws Exception {
            if (soyad.isEmpty()) {
                throw new Exception("Soyad boş olamaz.");
            }
            this.soyad = soyad;
        }

        public void setEmail(String email) throws Exception {
            if (email.isEmpty()) {
                throw new Exception("Email boş olamaz.");
            }
            this.email = email;
        }

        public void setAdres(String adres) throws Exception {
            if (adres.isEmpty()) {
                throw new Exception("Adres boş olamaz.");
            }
            this.adres = adres;
        }


        public void setTelefonNumarası(String telefonNumarası) throws Exception {
            if (telefonNumarası.isEmpty()) {
                throw new Exception("Telefon numarası boş olamaz.");
            }
            this.telefonNumarası = telefonNumarası;
        }

        public void setKullanıcıID(Long id) throws Exception {
            if (id == null) {
                throw new Exception("Kullanıcı ID'si boş olamaz.");
            }
            this.id = id;
        }

        public void setRol(Rol rol) throws Exception {
            if (rol == null) {
                throw new Exception("Rol boş olamaz.");
            }
            this.rol = rol;
        }

        public void kullanıcıKaydet() throws Exception {
            setSifre(this.sifre);
            setAd(this.ad);
            setSoyad(this.soyad);
            setEmail(this.email);
            setAdres(this.adres);
            setTelefonNumarası(this.telefonNumarası);
            setKullanıcıID(this.id);
            setRol(this.rol);
        }


    }



