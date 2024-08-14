package com.Efxpress.efxpressfatih.controller;
import com.Efxpress.efxpressfatih.Service.SepetServiceImpl;
import com.Efxpress.efxpressfatih.dto.SepetDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("api/sepet")
public class SepetController {
    @Autowired
    private SepetServiceImpl sepetService;
    @GetMapping("/urunler")
    public String getAllSepetUrunleri(Model model) {
        List<SepetDto> sepetUrunleri = sepetService.getAllSepetUrunleri();
        model.addAttribute("sepetUrunleri", sepetUrunleri);
        return "sepet-urunleri";}
    @GetMapping("/urun/{id}")
    public String getSepetUrunuById(@PathVariable Long id, Model model) {
        SepetDto sepetUrunu = sepetService.getSepetUrunuById(id);
        if (sepetUrunu == null) {
            // Handle not found scenario
            return "redirect:/sepet/urunler";}
        model.addAttribute("sepetUrunu", sepetUrunu);
        return "sepet-urun-detay";}
    @PostMapping("/urun-ekle")
    public String createSepetUrunu(@ModelAttribute SepetDto sepetDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            // Handle validation errors
            return "sepet-urun-ekle"; }
        sepetService.createSepetUrunu(sepetDto);
        return "redirect:/sepet/urunler";}
    @PutMapping("/urun-guncelle/{id}")
    public String updateSepetUrunu(@PathVariable Long id, @ModelAttribute SepetDto sepetDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            // Handle validation errors
            return "sepet-urun-guncelle";}
        sepetService.updateSepetUrunu(id, sepetDto);
        return "redirect:/sepet/urunler";}
    @DeleteMapping("/urun-sil/{id}")
    public String deleteSepetUrunu(@PathVariable Long id) {
        sepetService.deleteSepetUrunu(id);
        return "redirect:/sepet/urunler";
    }
}