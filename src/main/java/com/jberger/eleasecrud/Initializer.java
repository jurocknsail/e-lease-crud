package com.jberger.eleasecrud;

import com.jberger.eleasecrud.model.Lease;
import com.jberger.eleasecrud.model.Leaseholder;
import com.jberger.eleasecrud.repository.LeaseRepository;
import com.jberger.eleasecrud.repository.LeaseholderRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Component
public class Initializer implements CommandLineRunner {

    private final LeaseholderRepository leaseholderRepository;
    private final LeaseRepository leaseRepository;

    public Initializer(LeaseholderRepository tutorialRepository, LeaseRepository leaseRepository) {
        this.leaseholderRepository = tutorialRepository;
        this.leaseRepository = leaseRepository;
    }

    @Override
    public void run(String... args) {

        if (leaseholderRepository.findAll().size() == 0) {
            Stream.of("John", "Julie", "Jennifer", "Helen", "Rachel").forEach(name -> {
                Leaseholder leaseholder = new Leaseholder(name, "A leasholder", name.toLowerCase() + "@domain.com", "0611223344", true);
                leaseholderRepository.save(leaseholder);
                Lease lease = new Lease(leaseholder, "Lease", "descr", 1, 2.0f, 3.0f);
                leaseRepository.save(lease);
            });
            leaseholderRepository.findAll().forEach(System.out::println);
        } else {
            System.out.println("Data already populated !");
        }
    }

}
