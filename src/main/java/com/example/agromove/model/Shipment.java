package com.example.agromove.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Shipment {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Produce produce;
    private String status;
    private String origin;
    private String destination;
    private LocalDateTime departure;
    private LocalDateTime arrival;
}
