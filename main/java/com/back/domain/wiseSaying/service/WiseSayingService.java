package com.back.domain.wiseSaying.service;

import com.back.domain.wiseSaying.WiseSaying;

import java.util.ArrayList;
import java.util.List;

public class WiseSayingService {

    private int lastId = 0;
    private List<WiseSaying> wiseSayings = new ArrayList<>();

    public void modify(WiseSaying wiseSaying, String newSaying, String newAuthor) {
        wiseSaying.setSaying(newSaying);
        wiseSaying.setAuthor(newAuthor);
    }

    public boolean delete(int id){
        //for문으로 break를 거는게 성능은 더좋다
        //removeIf를 사용하는 이유는 가독성 때문
        return wiseSayings.removeIf(w -> w.getId() == id);
    }

    public WiseSaying write(String saying, String author){
        lastId++;
        WiseSaying wiseSaying = new WiseSaying(lastId,saying,author);
        wiseSayings.add(wiseSaying);
        return wiseSaying;
    }

    public WiseSaying findByIdOrNull(int id){
        return wiseSayings.stream()
                .filter(wiseSaying -> wiseSaying.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public List<WiseSaying> findListDesc(){

        return wiseSayings.reversed();
    }
}
