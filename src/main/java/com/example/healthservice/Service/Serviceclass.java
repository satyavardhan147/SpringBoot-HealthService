package com.example.healthservice.Service;

import com.example.healthservice.DTO.PatientDTO;
import com.example.healthservice.Model.Patient;
import com.example.healthservice.Model.Token;
import com.example.healthservice.Repository.PatientRepository;
import com.example.healthservice.Repository.TokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.SimpleTimeZone;
import java.util.TimeZone;

@Service
public class Serviceclass {
    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private TokenRepository tokenRepository;
    public void add(PatientDTO patientDTO) {

        Patient patient = new Patient();
        patient.setAddress(patientDTO.getAddress());
        patient.setBirthdate(patientDTO.getBirthdate());
        patient.setCounterNo(patientDTO.getCounterNo());
        patient.setEmail(patientDTO.getEmail());
        patient.setHpid(patientDTO.getHpid());
        patient.setName(patientDTO.getName());
        patient.setGender(patientDTO.getGender());
        patient.setMobNo(patientDTO.getMobNo());
        Token token = new Token();
        token.setStatus(true);
        token.setPatient(patient);
        patient.setToken(token);
        patientRepository.save(patient);

    }

    @Scheduled(cron = "0 0 * * *")
    public void schedule()
    {
        LocalDate date = LocalDate.now().minusDays(1);
        List<Token> list = tokenRepository.findByGenerationTime(date);

        for(int i = 0 ; i < list.size(); i++)
        {
            Token token = list.get(i);
            token.setStatus(false);
            list.set(i,token);
        }

        tokenRepository.saveAll(list);
    }
}


