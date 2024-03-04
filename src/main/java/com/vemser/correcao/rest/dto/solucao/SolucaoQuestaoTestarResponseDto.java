package com.vemser.correcao.rest.dto.solucao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SolucaoQuestaoTestarResponseDto {
    private String correcao;
    private String testesPassados;
    private String testesTotais;
}
