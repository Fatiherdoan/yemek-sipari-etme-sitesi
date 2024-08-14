package com.Efxpress.efxpressfatih.Service;
// Gerekli bağımlılıkları içe aktarıyoruz
import com.Efxpress.efxpressfatih.dto.SiparisDto;
import com.Efxpress.efxpressfatih.repository.SiparisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class SiparisServiceImpl implements Siparis {
    @Autowired
    private SiparisRepository siparisRepository;
    // Veritabanından tüm siparişleri almak için kullanılan metod
    @Override
    public List<SiparisDto> getAllSiparisler() {
        return siparisRepository.findAll();}
    // Belirli bir siparişi ID'sine göre almak için kullanılan metod
    @Override
    public SiparisDto getSiparisById(Long id) {
        Optional<SiparisDto> optionalSiparis = siparisRepository.findById(id);
        return optionalSiparis.orElse(null); }
    // Yeni bir sipariş oluşturmak için kullanılan metod
    @Override
    public SiparisDto createSiparis(SiparisDto siparisDto) {
        return siparisRepository.save(siparisDto);
    }
    // Mevcut bir siparişi güncellemek için kullanılan metod
    @Override
    public SiparisDto updateSiparis(Long id, SiparisDto siparisDto) {
        Optional<SiparisDto> optionalSiparis = siparisRepository.findById(id);
        if (optionalSiparis.isPresent()) {
            siparisDto.setId(id);
            return siparisRepository.save(siparisDto);
        } else {
            return null;
        }}
    // Belirli bir siparişi silmek için kullanılan metod
    @Override
    public void deleteSiparis(Long id) {
        siparisRepository.deleteById(id);
    }
}
