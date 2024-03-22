package com.hanil.edubot.domain;

import lombok.Data;

import java.util.List;

@Data
public class CallResult {

    private int idx;
    private int scriptIdx;
    private String script;
    private String userId;
    private String wav;
    private int progress;
    private String EndDate;

    private int minScore;
    private int maxScore;


    private List<ScriptDetail> list;

}
