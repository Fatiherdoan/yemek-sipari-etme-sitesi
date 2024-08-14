package com.Efxpress.efxpressfatih.controller;
import com.Efxpress.efxpressfatih.Service.MenuServiceInterface;
import com.Efxpress.efxpressfatih.dto.Menudto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/menu")
public class MenuController {
    @Autowired
    private MenuServiceInterface menuService;
    // Tüm menüleri getiren bir GET isteği işlenir.
    @GetMapping
    public ResponseEntity<List<Menudto>> getAllMenuler() {
        List<Menudto> menuler = menuService.getAllMenuler();
        return ResponseEntity.ok(menuler);}
    // Belirli bir menüyü ID'sine göre getiren bir GET isteği işlenir.
    @GetMapping("/{id}")
    public ResponseEntity<Menudto> getMenuById(@PathVariable Long id) {
        Menudto menu = menuService.getMenuById(id);
        if (menu != null) {
            return ResponseEntity.ok(menu);
        } else {
            return ResponseEntity.notFound().build();
        }}
    // Yeni bir menü oluşturan bir POST isteği işlenir.
    @PostMapping
    public ResponseEntity<Menudto> createMenu(@RequestBody Menudto menuDto) {
        Menudto createdMenu = menuService.createMenu(menuDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdMenu);}
    // Mevcut bir menüyü güncelleyen bir PUT isteği işlenir.
    @PutMapping("/{id}")
    public ResponseEntity<Menudto> updateMenu(@PathVariable Long id, @RequestBody Menudto menuDto) {
        Menudto updatedMenu = menuService.updateMenu(id, menuDto);
        if (updatedMenu != null) {
            return ResponseEntity.ok(updatedMenu);
        } else {
            return ResponseEntity.notFound().build();
        }}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMenu(@PathVariable Long id) {
        menuService.deleteMenu(id);
        return ResponseEntity.noContent().build();
    }}


