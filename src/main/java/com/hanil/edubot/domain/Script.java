package com.hanil.edubot.domain;

import lombok.Data;

import java.util.List;

@Data
public class Script {

    private int idx;
    private String script;
    private String delay;
    private int progress;
    private int callCount;
    private int completeCnt;
    private int incompleteCnt;
    private List<ScriptDetail> list;

}
