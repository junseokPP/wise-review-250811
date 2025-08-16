package com.back.domain.wiseSaying.service;

import com.back.domain.wiseSaying.WiseSaying;
import com.back.domain.wiseSaying.repository.WiseSayingRepository;

import java.util.ArrayList;
import java.util.List;

public class WiseSayingService {

    private int lastId = 0;
    WiseSayingRepository wiseSayingRepository = new WiseSayingRepository();

    public void modify(WiseSaying wiseSaying, String newSaying, String newAuthor) {
        wiseSaying.setSaying(newSaying);
        wiseSaying.setAuthor(newAuthor);
    }

    public WiseSaying write(String saying, String author){

        lastId++;
        WiseSaying wiseSaying = new WiseSaying(lastId,saying,author);
        wiseSayingRepository.save(wiseSaying);

        return wiseSaying;
    }

    public List<WiseSaying> findListDesc(){
        return wiseSayingRepository.findListDesc();
    }

    public WiseSaying getByIdOrNull(int id){
        return wiseSayingRepository.findByIdOrNull(id);
    }

    public boolean delete(int id){
        return wiseSayingRepository.delete(id);
    }
}
