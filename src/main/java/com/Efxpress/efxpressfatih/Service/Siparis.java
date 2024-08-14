package com.Efxpress.efxpressfatih.Service;
import com.Efxpress.efxpressfatih.dto.SiparisDto;

import java.util.List;

public interface Siparis {


        List<SiparisDto> getAllSiparisler();

        SiparisDto getSiparisById(Long id);

        SiparisDto createSiparis(SiparisDto siparisDto);

        SiparisDto updateSiparis(Long id, SiparisDto siparisDto);

        void deleteSiparis(Long id);
    }


