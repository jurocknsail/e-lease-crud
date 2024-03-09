package com.jberger.eleasecrud.controller;

import com.jberger.eleasecrud.repository.LeaseRepository;
import com.jberger.eleasecrud.model.Lease;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class LeaseController {

    private final Logger log = LoggerFactory.getLogger(LeaseController.class);

    @Autowired
    LeaseRepository leaseRepository;

    @GetMapping("/leases")
    public ResponseEntity<List<Lease>> getAllLeases() {
        try {
            List<Lease> leases = new ArrayList<Lease>();

            leaseRepository.findAll().forEach(leases::add);

            if (leases.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(leases, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
