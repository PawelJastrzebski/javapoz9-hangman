package com.jastrzab;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class HangmanResultService {

    private RisultRepository resultRepo;

    public HangmanResultService(RisultRepository resultRepo) {
        this.resultRepo = resultRepo;
    }

    public List<String> getResult(){
        final Map<String, List<String>> result = resultRepo.getResult();


        final List<String> collectRes = result.entrySet().stream().map(a -> mapObjectFromMap(a)).collect(Collectors.toList());
        return  collectRes;
    }

    private String mapObjectFromMap(Map.Entry<String, List<String>> a) {
        String name = a.getKey();
        String value = "1.1";
        return name + value;
    }

    public void save (String result){

    }
}
