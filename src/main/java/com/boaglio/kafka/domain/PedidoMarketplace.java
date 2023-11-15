package com.boaglio.kafka.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
@Table(name = "pedido")
public class PedidoMarketplace {

    @Id
    @Schema(example = "1")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pedido_seq")
    @SequenceGenerator(name = "pedido_seq", sequenceName = "pedido_seq", allocationSize = 1)
    private Long id;
    @Schema(example = "Loja SP")
    private String fornecedor;
    @Schema(example = "12345678901")
    private String  cpfDoCliente;

    @Schema(example = "1")
    private Integer quantidadeGalaoDeAgua;

    @Schema(example = "0")
    private Integer quantidadeSacoDeGelo;

    @Schema(example = "20.00")
    private Double valor;

    @Schema(example = "2023-11-12 19:53:21")
    private LocalDateTime data;

    private Churrasco churraco;

    public PedidoMarketplace() {
        this.data = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public String getCpfDoCliente() {
        return cpfDoCliente;
    }

    public Integer getQuantidadeGalaoDeAgua() {
        return quantidadeGalaoDeAgua;
    }

    public Integer getQuantidadeSacoDeGelo() {
        return quantidadeSacoDeGelo;
    }

    public Double getValor() {
        return valor;
    }

    public LocalDateTime getData() {
        return data;
    }

    public Churrasco getChurraco() {
        return churraco;
    }
}
