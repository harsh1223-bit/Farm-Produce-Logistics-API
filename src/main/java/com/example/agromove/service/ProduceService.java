package com.example.agromove.service;

import com.example.agromove.model.Produce;
import com.example.agromove.repository.ProduceRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProduceService {
    private final ProduceRepository repo;
    public ProduceService(ProduceRepository repo){this.repo = repo;}

    public Page<Produce> list(Pageable pageable){ return repo.findAll(pageable); }
    public Produce create(Produce p){return repo.save(p);}
    public Produce get(Long id){return repo.findById(id).orElseThrow();}
    public Produce update(Long id, Produce p){p.setId(id); return repo.save(p);}
    public void delete(Long id){repo.deleteById(id);}
}
