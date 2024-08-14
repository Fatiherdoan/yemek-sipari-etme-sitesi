package com.Efxpress.efxpressfatih.controller;
import com.Efxpress.efxpressfatih.Service.SepetServiceImpl;
import com.Efxpress.efxpressfatih.dto.SiparisDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("api/siparis")
public class SipariController {
    @Autowired
    private SepetServiceImpl siparisService;
    // Tüm siparişleri getiren bir GET isteği işlenir.
    @GetMapping
    public ResponseEntity<List<SiparisDto>> getAllSiparisler() {
        List<SiparisDto> siparisler = siparisService.getAllSiparisler();
        return ResponseEntity.ok(siparisler);
    }
    // Belirli bir siparişi ID'sine göre getiren bir GET isteği işlenir.
    @GetMapping("/{id}")
    public ResponseEntity<SiparisDto> getSiparisById(@PathVariable Long id) {
        SiparisDto siparis = siparisService.getSiparisById(id);
        if (siparis != null) {
            return ResponseEntity.ok(siparis);
        } else {
            return ResponseEntity.notFound().build();}}
    // Yeni bir sipariş oluşturan bir POST isteği işlenir.
    @PostMapping
    public ResponseEntity<SiparisDto> createSiparis(@RequestBody SiparisDto siparisDto) {
        SiparisDto createdSiparis = siparisService.createSiparis(siparisDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdSiparis);
    }
    // Mevcut bir siparişi güncelleyen bir PUT isteği işlenir.
    @PutMapping("/{id}")
    public ResponseEntity<SiparisDto> updateSiparis(@PathVariable Long id, @RequestBody SiparisDto siparisDto) {
        SiparisDto updatedSiparis = siparisService.updateSiparis(id, siparisDto);
        if (updatedSiparis != null) {
            return ResponseEntity.ok(updatedSiparis);
        } else {
            return ResponseEntity.notFound().build();
        }}

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSiparis(@PathVariable Long id) {
        return ResponseEntity.noContent().build();
    }
}
