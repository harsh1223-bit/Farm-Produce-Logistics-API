package com.example.agromove.controller;

import com.example.agromove.dto.ProduceRequest;
import com.example.agromove.dto.ProduceResponse;
import com.example.agromove.mapper.ProduceMapper;
import com.example.agromove.model.Produce;
import com.example.agromove.service.ProduceService;
import org.springframework.data.domain.*;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/produce")
@Validated
public class ProduceController {
    private final ProduceService service;
    public ProduceController(ProduceService service){this.service = service;}

    @GetMapping
    public ResponseEntity<?> list(Pageable pageable){
        var page = service.list(pageable).map(ProduceMapper::toResponse);
        return ResponseEntity.ok(page);
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ProduceResponse> create(@Valid @RequestBody ProduceRequest req){
        Produce p = ProduceMapper.toEntity(req);
        Produce saved = service.create(p);
        return ResponseEntity.ok(ProduceMapper.toResponse(saved));
    }

    @GetMapping("/{id}") public ResponseEntity<ProduceResponse> get(@PathVariable Long id){
        Produce p = service.get(id);
        return ResponseEntity.ok(ProduceMapper.toResponse(p));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ProduceResponse> update(@PathVariable Long id, @Valid @RequestBody ProduceRequest req){
        Produce p = ProduceMapper.toEntity(req);
        Produce updated = service.update(id, p);
        return ResponseEntity.ok(ProduceMapper.toResponse(updated));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
