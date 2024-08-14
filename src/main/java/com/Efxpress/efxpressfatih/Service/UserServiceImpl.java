package com.Efxpress.efxpressfatih.Service;

import com.Efxpress.efxpressfatih.dto.Userdto;
import com.Efxpress.efxpressfatih.repository.UserdtoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements Kullanıcı {

    @Autowired
    private UserdtoRepository userdtoRepository;

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public Optional<Userdto> kullaniciAdiIleBul(String kullaniciAdi) {
        return userdtoRepository.findByUsername(kullaniciAdi);
    }

    @Override
    public Optional<Userdto> kullaniciEmailIleBul(String email) {
        return userdtoRepository.findByEmail(email);
    }

    @Override
    public Userdto kullaniciEkle(Userdto kullanici) throws Exception {
        // Kullanıcı adının veya e-posta adresinin zaten alınıp alınmadığını kontrol et
        if (userdtoRepository.existsByUsername(kullanici.getUsername())) {
            throw new IllegalArgumentException("Kullanıcı adı zaten mevcut.");
        }
        if (userdtoRepository.existsByEmail(kullanici.getEmail())) {
            throw new IllegalArgumentException("E-posta adresi zaten mevcut.");
        }
        // Şifreyi hashle
        String hashedPassword = bCryptPasswordEncoder.encode(kullanici.getSifre());
        kullanici.setSifre(hashedPassword);
        // Kullanıcıyı veritabanına kaydet
        return userdtoRepository.save(kullanici);
    }

    @Override
    public Userdto kullaniciGuncelle(Userdto kullanici) throws Exception {
        // Kullanıcı alanlarını doğrula
        if (kullanici.getUsername() == null || kullanici.getUsername().isEmpty()) {
            throw new IllegalArgumentException("Kullanıcı adı boş olamaz.");
        }
        if (kullanici.getEmail() == null || kullanici.getEmail().isEmpty()) {
            throw new IllegalArgumentException("E-posta adresi boş olamaz.");
        }
        if (kullanici.getTelefonNumarası() == null || kullanici.getTelefonNumarası().isEmpty()) {
            throw new IllegalArgumentException("Telefon numarası boş olamaz.");
        }
        // Veritabanından mevcut kullanıcıyı al
        Userdto existingUser = userdtoRepository.findById(kullanici.getId())
                .orElseThrow(() -> new IllegalArgumentException("Kullanıcı bulunamadı."));
        // Kullanıcı alanlarını güncelle
        existingUser.setUsername(kullanici.getUsername());
        existingUser.setEmail(kullanici.getEmail());
        existingUser.setTelefonNumarası(kullanici.getTelefonNumarası());
        // Güncellenmiş kullanıcıyı veritabanına kaydet
        return userdtoRepository.save(existingUser);
    }

    @Override
    public void sifremiUnuttum(String email) throws Exception {
        // E-posta adresine göre kullanıcıyı bul
        Optional<Userdto> userOptional = kullaniciEmailIleBul(email);
        if (userOptional.isPresent()) {
            Userdto user = userOptional.get();
            // Rastgele bir şifre sıfırlama belirteci oluştur
            String resetToken = UUID.randomUUID().toString();
            // Kullanıcıya sıfırlama belirteci atama
            user.setResetToken(resetToken);
            // Sıfırlama belirteci ile kullanıcıyı kaydet
            kullaniciEkle(user);
            // Kullanıcıya şifre sıfırlama bağlantısını içeren e-posta gönder
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setTo(user.getEmail());
            mailMessage.setSubject("Şifre Sıfırlama");
            mailMessage.setText("Merhaba,\n\nŞifrenizi sıfırlamak için aşağıdaki linke tıklayınız: http://ornek.com/sifre-sifirla?token=" + resetToken);
            mailSender.send(mailMessage);
        } else {
            throw new IllegalArgumentException("Bu e-posta ile ilişkili kullanıcı bulunamadı.");
        }
    }

    @Override
    public void hashCode(Userdto user) {
        // Burada kullanıcının hash kodunu oluştur
    }

    @Override
    public boolean kullaniciGiris(String kullaniciAdi, String sifre) {
        Optional<Userdto> userOptional = kullaniciAdiIleBul(kullaniciAdi);
        if (userOptional.isPresent()) {
            Userdto user = userOptional.get();
            return bCryptPasswordEncoder.matches(sifre, user.getSifre());
        }
        return false;
    }

    public void sifremiUnuttum(String username, String email) {
    }
}
