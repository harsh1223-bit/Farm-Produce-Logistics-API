package com.example.agromove.dto;

import lombok.*;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class ProduceResponse {
    private Long id;
    private String name;
    private String type;
    private String description;
}
