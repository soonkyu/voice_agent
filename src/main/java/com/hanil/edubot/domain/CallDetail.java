package com.hanil.edubot.domain;

import lombok.Data;

@Data
public class CallDetail {

    private int idx;
    private int callIdx;
    private String contents;
    private int score;

}
