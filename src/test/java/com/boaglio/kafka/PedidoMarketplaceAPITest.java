package com.boaglio.kafka;

import com.boaglio.kafka.repository.PedidoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;

@SpringBootTest
@AutoConfigureMockMvc
class PedidoMarketplaceAPITest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PedidoRepository pedidoRepository;
    @BeforeEach
    void setup() {
        // Limpar o banco de dados antes de cada teste
        pedidoRepository.deleteAll();
    }

    @Test
    void getAllPedidos() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/pedidos")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void getPedido() throws Exception {
        Long pedidoId = 1L;

        mockMvc.perform(MockMvcRequestBuilders.get("/api/pedidos/{id}", pedidoId)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    void criarPedido() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/pedidos")
                .content("{}")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    void totalDePedidos() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/pedidos/total")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
