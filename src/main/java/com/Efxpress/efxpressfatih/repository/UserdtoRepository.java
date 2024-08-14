package com.Efxpress.efxpressfatih.repository;

import com.Efxpress.efxpressfatih.dto.Userdto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserdtoRepository extends JpaRepository<Userdto,Long> {
    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

    @Query("SELECT u FROM Userdto u WHERE u.username = :username")
    Optional<Userdto> findByUsername();

    Optional<Userdto> findByEmail(String email);

    Optional<Userdto> findByUsername(String username);
}
