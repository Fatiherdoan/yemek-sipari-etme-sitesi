package com.Efxpress.efxpressfatih.Service;
import com.Efxpress.efxpressfatih.dto.Kategoridto;
import com.Efxpress.efxpressfatih.repository.KategoridtoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class KategoriServiceImpl implements kategori {
    @Autowired
    private KategoridtoRepository kategoriRepository;
    // Yeni bir kategori eklemek için kullanılan metod
    @Override
    public Kategoridto saveKategori(Kategoridto kategori) {
        return kategoriRepository.save(kategori);
    }
    // Tüm kategorileri almak için kullanılan metod
    @Override
    public List<Kategoridto> getAllKategoriler() {
        return kategoriRepository.findAll();
    }
    // Belirli bir kategoriyi ID'sine göre almak için kullanılan metod
    @Override
    public Kategoridto getKategoriById(Long id) {
        return kategoriRepository.findById(id).orElse(null);
    }

    // Belirli bir kategoriyi ID'sine göre silmek için kullanılan metod
    @Override
    public void deleteKategori(Long id) {
        kategoriRepository.deleteById(id);
    }
}
