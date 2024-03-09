package com.jberger.eleasecrud.controller;

import com.jberger.eleasecrud.repository.LeaseholderRepository;
import com.jberger.eleasecrud.model.Leaseholder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class LeaseholderController {

    private final Logger log = LoggerFactory.getLogger(LeaseholderController.class);

    @Autowired
    LeaseholderRepository leaseholderRepository;

    @GetMapping("/leaseholders")
    public ResponseEntity<List<Leaseholder>> getAllLeaseholders(@RequestParam(required = false) String name) {
        try {
            List<Leaseholder> leaseholders = new ArrayList<Leaseholder>();

            if (name == null)
                leaseholderRepository.findAll().forEach(leaseholders::add);
            else
                leaseholderRepository.findByNameContaining(name).forEach(leaseholders::add);

            if (leaseholders.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(leaseholders, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/leaseholders/{id}")
    public ResponseEntity<Leaseholder> getLeaseholderById(@PathVariable("id") long id) {
        Optional<Leaseholder> leaseholderData = leaseholderRepository.findById(id);

        if (leaseholderData.isPresent()) {
            return new ResponseEntity<>(leaseholderData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/leaseholders")
    public ResponseEntity<Leaseholder> createLeaseholders(@RequestBody Leaseholder tutorial) {
        try {
            Leaseholder _tutorial = leaseholderRepository
                    .save(new Leaseholder(tutorial.getName(), tutorial.getDescription(), tutorial.getEmail(), tutorial.getPhone(), false));
            return new ResponseEntity<>(_tutorial, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/leaseholders/{id}")
    public ResponseEntity<Leaseholder> updateLeaseholder(@PathVariable("id") long id, @RequestBody Leaseholder leaseholder) {
        Optional<Leaseholder> leaseholderData = leaseholderRepository.findById(id);

        if (leaseholderData.isPresent()) {
            Leaseholder _leaseholder = leaseholderData.get();
            _leaseholder.setName(leaseholder.getName());
            _leaseholder.setDescription(leaseholder.getDescription());
            _leaseholder.setEmail(leaseholder.getEmail());
            _leaseholder.setPhone(leaseholder.getPhone());
            _leaseholder.setPro(leaseholder.isPro());
            return new ResponseEntity<>(leaseholderRepository.save(_leaseholder), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/leaseholders/{id}")
    public ResponseEntity<HttpStatus> deleteLeaseholder(@PathVariable("id") long id) {
        try {
            leaseholderRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/leaseholders")
    public ResponseEntity<HttpStatus> deleteAllLeaseholders() {
        try {
            leaseholderRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/leaseholders/pro")
    public ResponseEntity<List<Leaseholder>> findByPro() {
        try {
            List<Leaseholder> leaseholders = leaseholderRepository.findByPro(true);

            if (leaseholders.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(leaseholders, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
