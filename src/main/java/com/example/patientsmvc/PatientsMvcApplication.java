package com.example.patientsmvc;

import com.example.patientsmvc.entities.Patient;
import com.example.patientsmvc.repositories.PatientRepository;
import com.example.patientsmvc.sec.service.SecurityService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class PatientsMvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(PatientsMvcApplication.class, args);
    }


    //@Bean
    CommandLineRunner commandLineRunner(PatientRepository patientRepository){
        return args -> {
            patientRepository.save(new Patient(null,"Ariana", new Date(),false,12));
            patientRepository.save(new Patient(null,"Julis", new Date(),true,321));
            patientRepository.save(new Patient(null,"Mai", new Date(),false,65));
            patientRepository.save(new Patient(null,"Anna", new Date(),false,32));


            patientRepository.findAll().forEach(p-> System.out.println(p.getNom()));
        };
    }

    @Bean
    CommandLineRunner saveUsers(SecurityService securityService){
        return args ->{
            securityService.saveNewUser("user1", "1234", "1234");
            securityService.saveNewUser("ariana", "1234", "1234");
            securityService.saveNewUser("alexis", "1234", "1234");

            securityService.saveNewRole("USER", "");
            securityService.saveNewRole("ADMIN", "");

            securityService.addRoleToUser("user1", "USER");
            securityService.addRoleToUser("alexis", "USER");
            securityService.addRoleToUser("ariana", "USER");
            securityService.addRoleToUser("ariana", "ADMIN");

        };
    }

}
