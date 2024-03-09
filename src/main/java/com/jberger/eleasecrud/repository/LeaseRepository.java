package com.jberger.eleasecrud.repository;

import com.jberger.eleasecrud.model.Lease;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeaseRepository extends JpaRepository<Lease, Long> {

}
