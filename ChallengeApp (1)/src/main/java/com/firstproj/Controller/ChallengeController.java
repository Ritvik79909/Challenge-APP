package com.firstproj.Controller;

import com.firstproj.Challenge;
import com.firstproj.Service.ChallengeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
public class ChallengeController {
    private ChallengeService challengeService;

    public ChallengeController(ChallengeService challengeService){
        this.challengeService = challengeService;
    }

    @GetMapping("/challenges")
    public ResponseEntity<List<Challenge>> getAllChallenges(){
        return new ResponseEntity<>(challengeService.getAllChallnges(),HttpStatus.OK);
    }

    @PostMapping("/challenges")
    public ResponseEntity<String> addChallenges(@RequestBody Challenge challenge){
       boolean isChallengeAdded = challengeService.addChallenges(challenge);
       if(isChallengeAdded)
            return new ResponseEntity<>("Challenge added successfully",HttpStatus.OK);
       else
           return new ResponseEntity<>("Challenge not added",HttpStatus.NOT_FOUND);
    }

    @GetMapping("/challenges/{month}")
    public ResponseEntity<Challenge> getChallenges(@PathVariable String month){
        Challenge challenge = challengeService.getChallnges(month);
        if(challenge != null){
            return new ResponseEntity<>(challenge, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/challenges/{id}")
    public ResponseEntity<String> updateChallenge(@PathVariable Long id, @RequestBody Challenge updateChallenge){
        boolean isChallengeUpdated = challengeService.updateChallenge(id,updateChallenge);
        if(isChallengeUpdated)
            return new ResponseEntity<>("Challenge Updated successfully",HttpStatus.OK);
        else
            return new ResponseEntity<>("Challenge not Updated",HttpStatus.NOT_FOUND);

    }

    @DeleteMapping("/challenges/{id}")
    public ResponseEntity<String> deleteChallenge(@PathVariable Long id){
        boolean isChallengedeleted = challengeService.deleteChallenge(id);
        if(isChallengedeleted)
            return new ResponseEntity<>("Challenge Deleted successfully",HttpStatus.OK);
        else
            return new ResponseEntity<>("Challenge not Deleted",HttpStatus.NOT_FOUND);

    }
}
