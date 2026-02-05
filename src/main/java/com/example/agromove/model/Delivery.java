package com.example.agromove.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Delivery {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Shipment shipment;
    private LocalDateTime scheduledTime;
    private LocalDateTime actualTime;
    private String status;
}
