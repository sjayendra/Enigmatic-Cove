package com.jay.crud1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.util.List;

@Service
public class PrabhvnaService {
    @Autowired
    private PrabhvnaRepository repo;
    private PrabhvnaRepository repo1;
    private PrabhvnaRepository repo2;
    //private PrabhvnaRepository;

    public List<Prabhvna> listAll(String keyword) {
        if (keyword != null) {
            return repo.search(keyword);
        }
        return repo.findAll();
    }

    public Prabhvna get(String ecn) {
        return repo.findById(ecn).get();
    }

    public void save(Prabhvna prabhvna) {

        repo.save(prabhvna);
    }


    //public Prabhvna get(String ecn) { return repo.findAllById(id).get();}


    //public void delete(Long id) {
    //    repo.deleteById(ecn);
    //}
}
