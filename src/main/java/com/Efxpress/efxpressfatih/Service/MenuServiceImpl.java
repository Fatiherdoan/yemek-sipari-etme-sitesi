package com.Efxpress.efxpressfatih.Service;
import com.Efxpress.efxpressfatih.dto.Menudto;
import com.Efxpress.efxpressfatih.repository.MenudtoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class MenuServiceImpl implements MenuServiceInterface {
    @Autowired
    private MenudtoRepository menuRepository;
    // Tüm menü öğelerini almak için kullanılan metod
    @Override
    public List<Menudto> getAllMenuler() {
        return menuRepository.findAll();
    }
    // Belirli bir menü öğesini ID'sine göre almak için kullanılan metod
    @Override
    public Menudto getMenuById(Long id) {
        Optional<Menudto> optionalMenu = menuRepository.findById(id);
        return optionalMenu.orElse(null);}
    // Yeni bir menü öğesi oluşturmak için kullanılan metod
    @Override
    public Menudto createMenu(Menudto menuDto) {
        return menuRepository.save(menuDto);}
    // Mevcut bir menü öğesini güncellemek için kullanılan metod
    @Override
    public Menudto updateMenu(Long id, Menudto menuDto) {
        Optional<Menudto> optionalMenu = menuRepository.findById(id);
        if (optionalMenu.isPresent()) {
            // Eğer menü öğesi bulunduysa, ID'sini ayarla
            menuDto.setId(id);
            // Güncellenen menü öğesini veritabanına kaydet ve kaydedilen öğeyi geri döndür
            return menuRepository.save(menuDto);
        } else {
            return null;
        }}
    // Bir menü öğesini ID'sine göre silmek için kullanılan metod
    @Override
    public void deleteMenu(Long id) {
        menuRepository.deleteById(id);
    }
}
