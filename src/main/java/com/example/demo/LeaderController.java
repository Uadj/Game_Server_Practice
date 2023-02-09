package com.example.demo;

import com.example.demo.dto.ScoreRequest;
import com.example.demo.dto.ScoreResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class LeaderController {

    private final ScoreService scoreService;
    private final ScoreRepository scoreRepository;
    @PostMapping("/upload")
    public String request(@RequestBody ScoreRequest score){
        if(scoreRepository.findByUsername(score.getUsername())==null){
            scoreRepository.save(score.toEntity());
        }
        else{
            scoreService.update(score);
        }
        return "Saved";
    }
    @GetMapping("/download")
    public List<ScoreResponse> scores(){
        return scoreService.scores();
    }
}
