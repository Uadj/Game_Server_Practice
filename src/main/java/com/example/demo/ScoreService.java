package com.example.demo;

import com.example.demo.dto.ScoreRequest;
import com.example.demo.dto.ScoreResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ScoreService {

    private final ScoreRepository scoreRepository;

    @Transactional
    public List<ScoreResponse> scores(){
        List<Score> scores = scoreRepository.findAllOrderByScoreDesc();
        List<ScoreResponse> responses = scores.stream().map(m -> new ScoreResponse(m.getUsername(), m.getScore()))
                .collect(Collectors.toList());
        return responses;
    }
    @Transactional
    public Long update(ScoreRequest scoreReq){
        Score score = scoreRepository.findByUsername(scoreReq.getUsername());
        score.score = scoreReq.getScore();
        return score.id;
    }

}
