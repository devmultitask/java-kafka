package com.boaglio.kafka.repository;

import com.boaglio.kafka.domain.PedidoMarketplace;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository  extends JpaRepository<PedidoMarketplace,Long> {
}
