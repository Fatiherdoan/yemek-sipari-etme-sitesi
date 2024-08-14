package com.Efxpress.efxpressfatih.Service;

import com.Efxpress.efxpressfatih.dto.Kategoridto;

import java.util.List;

public interface kategori {
    Kategoridto saveKategori(Kategoridto kategori);
    List<Kategoridto> getAllKategoriler();
    Kategoridto getKategoriById(Long id);
    void deleteKategori(Long id);
}
