package com.wqa.exam.infrastructure.repository;

import com.wqa.exam.infrastructure.entity.Referencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReferenciaRepository extends JpaRepository<Referencia, Long> {
}
