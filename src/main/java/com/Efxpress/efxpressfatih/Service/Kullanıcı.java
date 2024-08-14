package com.Efxpress.efxpressfatih.Service;

import com.Efxpress.efxpressfatih.dto.Userdto;
import org.springframework.stereotype.Service;

import java.util.Optional;
    @Service
    public interface Kullanıcı{

        Optional<Userdto> kullaniciAdiIleBul(String username);

        Optional<Userdto> kullaniciEmailIleBul(String email);

        Userdto kullaniciEkle(Userdto kullanici) throws Exception;

        Userdto kullaniciGuncelle(Userdto kullanici) throws Exception;

        void sifremiUnuttum(String email) throws Exception;

        void hashCode(Userdto user);

        boolean kullaniciGiris(String kullaniciAdi, String sifre);
    }
