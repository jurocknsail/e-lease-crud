package com.jberger.eleasecrud.repository;

import com.jberger.eleasecrud.model.Leaseholder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LeaseholderRepository extends JpaRepository<Leaseholder, Long> {
    List<Leaseholder> findByPro(boolean isPro);
    List<Leaseholder> findByNameContaining(String name);
}
