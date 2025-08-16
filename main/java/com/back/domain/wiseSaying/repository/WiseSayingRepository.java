package com.back.domain.wiseSaying.repository;

import com.back.domain.wiseSaying.WiseSaying;

import java.util.ArrayList;
import java.util.List;

public class WiseSayingRepository {


    private int lastId = 0;

    private List<WiseSaying> wiseSayings = new ArrayList<>();

    public WiseSaying findByIdOrNull(int id){
        return wiseSayings.stream()
                .filter(wiseSaying -> wiseSaying.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public boolean delete(int id){
        //for문으로 break를 거는게 성능은 더좋다
        //removeIf를 사용하는 이유는 가독성 때문
        return wiseSayings.removeIf(w -> w.getId() == id);
    }

    public WiseSaying  save(WiseSaying wiseSaying){

        if(wiseSaying.isNew()){ //wiseSaying이 새로운 객체인 경우
            lastId++;
            wiseSaying.setId(lastId);
            wiseSaying.setCreatedDate(java.time.LocalDateTime.now());
            wiseSaying.setModifiedDate(java.time.LocalDateTime.now());
            wiseSayings.add(wiseSaying);
        }
        else{
            wiseSaying.setModifiedDate(java.time.LocalDateTime.now());
        }

        return wiseSaying;
    }

    public List<WiseSaying> findListDesc(){
        return wiseSayings.reversed();
    }
}
