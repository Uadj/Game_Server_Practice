package com.example.demo.dto;

import com.example.demo.Score;
import lombok.Getter;

@Getter
public class ScoreRequest {

    String username;
    Integer score;

    public Score toEntity(){
        return Score.builder()
                .username(username)
                .score(score)
                .build();
    }
}
