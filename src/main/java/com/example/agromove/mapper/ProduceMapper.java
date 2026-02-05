package com.example.agromove.mapper;

import com.example.agromove.dto.ProduceRequest;
import com.example.agromove.dto.ProduceResponse;
import com.example.agromove.model.Produce;

public class ProduceMapper {
    public static Produce toEntity(ProduceRequest r){
        return Produce.builder()
                .name(r.getName())
                .type(r.getType())
                .description(r.getDescription())
                .build();
    }
    public static ProduceResponse toResponse(Produce p){
        return ProduceResponse.builder()
                .id(p.getId())
                .name(p.getName())
                .type(p.getType())
                .description(p.getDescription())
                .build();
    }
}
