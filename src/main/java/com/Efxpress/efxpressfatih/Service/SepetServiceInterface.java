package com.Efxpress.efxpressfatih.Service;
import com.Efxpress.efxpressfatih.dto.SepetDto;
import com.Efxpress.efxpressfatih.dto.SiparisDto;

import java.util.List;

public interface SepetServiceInterface {

    List<SepetDto> getAllSepetUrunleri();
    SepetDto getSepetUrunuById(Long id);
    SepetDto createSepetUrunu(SepetDto sepetDto);
    SepetDto updateSepetUrunu(Long id, SepetDto sepetDto);
    void deleteSepetUrunu(Long id);

    double getTotalPrice();
    double getTotalDiscount();
    void clearCart();
    boolean checkStock();

    SiparisDto getSiparisById(Long id);

    SiparisDto createSiparis(SiparisDto siparisDto);

    SiparisDto updateSiparis(Long id, SiparisDto siparisDto);

    void deleteSiparis(Long id);
}
