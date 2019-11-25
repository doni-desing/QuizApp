package com.example.lession.data.model;

import com.example.lession.data.IQuizRepository;
import com.example.lession.model.Global;

import java.util.List;
import java.util.Map;

public class GlobalRepository{

    private Global overall;
    private Map<String, Global> globals;

    public GlobalRepository(Global overall, Map<String, Global> globals) {
        this.overall = overall;
        this.globals = globals;
    }

    public Global getOverall() {
        return overall;
    }

    public void setOverall(Global overall) {
        this.overall = overall;
    }

    public Map<String, Global> getGlobals() {
        return globals;
    }

    public void setGlobals(Map<String, Global> globals) {
        this.globals = globals;
    }
}
