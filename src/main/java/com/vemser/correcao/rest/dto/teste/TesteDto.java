package com.vemser.correcao.rest.dto.teste;

import com.vemser.correcao.rest.enums.Exemplo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TesteDto {
    private Exemplo exemplo;
    private String retornoEsperado;
    private String valorEntrada;
}