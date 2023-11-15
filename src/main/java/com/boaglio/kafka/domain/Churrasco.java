package com.boaglio.kafka.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Embeddable;

@Embeddable
public class Churrasco {

    @Schema(example = "2")
    private Integer  quantidadeSacoDeCarvao;

    @Schema(example = "0")
    private Integer quantidadeAcendedor;

}