package com.Efxpress.efxpressfatih.Service;
import com.Efxpress.efxpressfatih.dto.Menudto;
import com.Efxpress.efxpressfatih.dto.SepetDto;
import com.Efxpress.efxpressfatih.dto.SiparisDto;
import com.Efxpress.efxpressfatih.repository.SepetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
@Service
public class SepetServiceImpl implements SepetServiceInterface{
    @Autowired
    private SepetRepository sepetRepository;
    private List<SiparisDto> allSiparisler;
    @Override
    public List<SepetDto> getAllSepetUrunleri() {
        return sepetRepository.findAll();
    }
    @Override
    public SepetDto getSepetUrunuById(Long id) {
        Optional<SepetDto> optionalSepetUrunu = sepetRepository.findById(id);
        return optionalSepetUrunu.orElse(null);
    }
    @Override
    public SepetDto createSepetUrunu(SepetDto sepetDto) {
        sepetDto.setOlusturulmaTarihi(LocalDateTime.now());
        sepetDto.setDurum("Eklendi");
        return sepetRepository.save(sepetDto);
    }
    @Override
    public SepetDto updateSepetUrunu(Long id, SepetDto sepetDto) {
        Optional<SepetDto> optionalSepetUrunu = sepetRepository.findById(id);
        if (optionalSepetUrunu.isPresent()) {
            sepetDto.setId(id);
            sepetDto.setGuncellemeTarihi(LocalDateTime.now());
            return sepetRepository.save(sepetDto);
        } else {
            return null;}}
    @Override
    public void deleteSepetUrunu(Long id) {
        SepetDto sepetDto = getSepetUrunuById(id);
        if (sepetDto != null) {
            sepetDto.setDurum("Kaldırıldı");
            sepetRepository.save(sepetDto);
        }
    }
    @Override
    public double getTotalPrice() {
        List<SepetDto> sepetUrunleri = getAllSepetUrunleri();
        double totalPrice = 0;
        for (SepetDto sepetDto : sepetUrunleri) {
            totalPrice += sepetDto.getFiyat() * sepetDto.getMiktar();
        }
        return totalPrice;
    }
    @Override
    public double getTotalDiscount() {
        List<SepetDto> sepetUrunleri = getAllSepetUrunleri();
        double totalDiscount = 0;
        for (SepetDto sepetDto : sepetUrunleri) {
            totalDiscount += sepetDto.getIndirim();
        }
        return totalDiscount;
    }
    @Override
    public void clearCart() {
        List<SepetDto> sepetUrunleri = getAllSepetUrunleri();
        for (SepetDto sepetDto : sepetUrunleri) {
            sepetDto.setDurum("Kaldırıldı");
            sepetRepository.save(sepetDto);
        }
    }
    @Override
    public boolean checkStock() {
        List<SepetDto> sepetUrunleri = getAllSepetUrunleri();
        for (SepetDto sepetDto : sepetUrunleri) {
            Menudto menudto = new Menudto();
            sepetDto.getUrun().getStok(menudto);
            continue;
        }
        return true;
    }
    @Override
    public SiparisDto getSiparisById(Long id) {
        return null;
    }

    @Override
    public SiparisDto createSiparis(SiparisDto siparisDto) {
        return null;
    }

    @Override
    public SiparisDto updateSiparis(Long id, SiparisDto siparisDto) {
        return null;
    }

    @Override
    public void deleteSiparis(Long id) {

    }

    public List<SiparisDto> getAllSiparisler() {
        return allSiparisler;
    }
}
