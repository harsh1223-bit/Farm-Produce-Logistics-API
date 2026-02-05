package com.example.agromove.repository;

import com.example.agromove.model.Shipment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShipmentRepository extends JpaRepository<Shipment, Long> {}
