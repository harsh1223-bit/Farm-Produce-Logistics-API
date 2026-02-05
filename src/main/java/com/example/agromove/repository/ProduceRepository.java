package com.example.agromove.repository;

import com.example.agromove.model.Produce;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduceRepository extends JpaRepository<Produce, Long> {}
