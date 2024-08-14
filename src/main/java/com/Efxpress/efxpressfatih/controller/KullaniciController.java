package com.Efxpress.efxpressfatih.controller;
import com.Efxpress.efxpressfatih.Service.UserServiceImpl;
import com.Efxpress.efxpressfatih.dto.Userdto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
@Controller
@RequestMapping("/kullanici")
public class KullaniciController {
    @Autowired
    private UserServiceImpl userService;
    @RequestMapping(value = "/kayit", method = RequestMethod.GET)
    public String kayitForm(org.springframework.ui.Model model) {
        // Yeni bir Userdto nesnesi oluşturarak yeni kullanıcıyı temsil eder.
        model.addAttribute("kullanici", new Userdto());
        return "kayit-form";}
    @PostMapping("/kayit")
    public String kayit(@ModelAttribute("kullanici") Userdto kullanici, BindingResult bindingResult, org.springframework.ui.Model model) {
        // Form verilerinde doğrulama hatası var mı kontrol eder.
        if (bindingResult.hasErrors()) {
            return "kayit-form";}
        try {
            // UserServiceImpl kullanarak yeni kullanıcıyı kaydetmeye çalışır.
            userService.kullaniciEkle(kullanici);
            // Kayıt başarılıysa, bir başarı mesajı model'e eklenir.
            model.addAttribute("mesaj", "Kayıt işlemi başarıyla tamamlandı! Şimdi giriş yapabilirsiniz.");
            // Kullanıcıyı giriş sayfasına yönlendirir ("/kullanici/giris").
            return "redirect:/kullanici/giris";
        } catch (Exception e) {
            model.addAttribute("hataMesaj", "Kayıt işlemi sırasında bir hata oluştu: " + e.getMessage());
            return "redirect:/kullanici/kayit";}}
    @GetMapping("/giris")
    public String girisForm(org.springframework.ui.Model model) {
        // Yeni bir Userdto nesnesi oluşturarak giriş kimliklerini temsil eder.
        model.addAttribute("kullanici", new Userdto());
        // Giriş formu görünümünün adını döndürür ("giris-form").
        return "giris-form";
    }
    @PostMapping("/giris")
    public String girisPost(@ModelAttribute("kullanici") Userdto kullanici, org.springframework.ui.Model model) {
        // UserServiceImpl kullanarak kullanıcı girişini dener.
        if (userService.kullaniciGiris(kullanici.getUsername(), kullanici.getSifre())) {
            // Giriş başarılıysa, bir başarı mesajı model'e eklenir.
            model.addAttribute("mesaj", "Giriş başarılı!");
            // Kullanıcıyı ana sayfaya yönlendirir ("/anasayfa.html").
            return "redirect:/anasayfa.html";
        } else {
            // Giriş başarısızsa, bir hata mesajı model'e eklenir.
            model.addAttribute("hataMesaj", "Kullanıcı adı veya şifre yanlış!");
            return "redirect:/kullanici/giris";
        }
    }
    @GetMapping("/sifremi-unuttum")
    public String sifremiUnuttumForm(org.springframework.ui.Model model) {
        // Yeni bir Userdto nesnesi oluşturarak e-postayı temsil eder.
        model.addAttribute("kullanici", new Userdto());
        // Şifre sıfırlama formu görünümünün adını döndürür ("sifremi-unuttum-form").
        return "sifremi-unuttum-form";}
    @PostMapping("/sifremi-unuttum")
    public String sifremiUnuttum(@ModelAttribute("kullanici") Userdto kullanici, org.springframework.ui.Model model) {
        try {
            // UserServiceImpl kullanarak kullanıcının şifresini sıfırlamaya çalışır.
            userService.sifremiUnuttum(kullanici.getEmail());
            // Şifre sıfırlama başarılıysa, bir başarı mesajı model'e eklenir.
            model.addAttribute("mesaj", "Şifreniz sıfırlandı! Yeni şifrenizi kontrol edin.");
            // Kullanıcıyı giriş sayfasına yönlendirir ("/kullanici/giris").
            return "redirect:/kullanici/giris";
        } catch (Exception e) {
            // Şifre sıfırlama sırasında bir hata oluşursa, bir hata mesajı model'e eklenir.
            model.addAttribute("hataMesaj", "Şifre sıfırlama işlemi sırasında bir hata oluştu: " + e.getMessage());
            // Kullanıcıyı tekrar şifre sıfırlama formuna yönlendirir ("/kullanici/sifremi-unuttum").
            return "redirect:/kullanici/sifremi-unuttum";
        }
    }
}
