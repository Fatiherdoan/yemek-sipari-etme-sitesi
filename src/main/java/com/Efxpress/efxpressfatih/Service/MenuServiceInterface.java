package com.Efxpress.efxpressfatih.Service;
import com.Efxpress.efxpressfatih.dto.Menudto;

import java.util.List;

public interface MenuServiceInterface {

    List<Menudto> getAllMenuler();

    Menudto getMenuById(Long id);

    Menudto createMenu(Menudto menuDto);

    Menudto updateMenu(Long id, Menudto menuDto);

    void deleteMenu(Long id);
}
