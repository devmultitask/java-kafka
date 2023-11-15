package com.boaglio.kafka.api;

import com.boaglio.kafka.domain.PedidoMarketplace;
import com.boaglio.kafka.repository.PedidoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoMarketplaceAPI {

    private final PedidoRepository pedidoRepository;

    public PedidoMarketplaceAPI(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    @GetMapping
    public ResponseEntity<List<PedidoMarketplace>> getAllPedidos() {
        var pedidos = pedidoRepository.findAll();
        return ResponseEntity.ok(pedidos);
    }

    @GetMapping("{id}")
    public ResponseEntity<PedidoMarketplace> getPedido(@PathVariable Long id ) {
        Optional<PedidoMarketplace> pedido = pedidoRepository.findById(id);
        if (pedido.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(pedido.get());
    }

    @PostMapping
    public ResponseEntity<PedidoMarketplace> criarPedido(@RequestBody PedidoMarketplace pedido) {
        var pedidoGravado = pedidoRepository.save(pedido);
        URI location = URI.create("/api/pedidos/" + pedidoGravado.getId());
        return ResponseEntity.created(location).body(pedidoGravado);
    }

    @GetMapping("/total")
    public Long totalDePedidos() {
        return pedidoRepository.count();
    }

}