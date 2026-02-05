package com.example.agromove.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class ProduceRequest {
    @NotBlank @Size(max=100)
    private String name;
    @NotBlank @Size(max=50)
    private String type;
    @Size(max=500)
    private String description;
}
