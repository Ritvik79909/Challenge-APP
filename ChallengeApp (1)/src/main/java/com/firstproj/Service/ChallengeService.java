package com.firstproj.Service;

import com.firstproj.Challenge;
import com.firstproj.Repository.ChallengeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ChallengeService {
    //private List<Challenge> challenges = new ArrayList<>();

    private Long nextId = 1L;

    @Autowired
    ChallengeRepository challengeRepository;

    public ChallengeService(){
    }

    public List<Challenge> getAllChallnges(){
        return challengeRepository.findAll();
    }

    public boolean addChallenges(Challenge challenge){
        if(challenge != null){
            challenge.setId(nextId++);
            challengeRepository.save(challenge);
            return true;
        } else {
            return false;
        }
    }

    public Challenge getChallnges(String month) {
        Optional<Challenge> challenge = challengeRepository.findByMonthIgnoreCase(month);

        return challenge.orElse(null);
    }

    public boolean updateChallenge(Long id, Challenge updateChallenge) {
        Optional<Challenge> challenge = challengeRepository.findById(id);

        if(challenge.isPresent()){
            Challenge challengeToupdate = challenge.get();
            challengeToupdate.setMonth(updateChallenge.getMonth());
            challengeToupdate.setDescription(updateChallenge.getDescription());
            challengeRepository.save(challengeToupdate);
            return true;
        }
        return false;
    }

    public boolean deleteChallenge(Long id) {
        Optional<Challenge> challenge = challengeRepository.findById(id);

        if(challenge.isPresent()){
            challengeRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
