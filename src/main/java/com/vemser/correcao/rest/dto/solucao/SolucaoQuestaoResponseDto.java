package com.vemser.correcao.rest.dto.solucao;

import com.vemser.correcao.rest.enums.Linguagem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SolucaoQuestaoResponseDto {
    private Integer atividadeEnviadaId;
    private String codigo;
    private Linguagem linguagem;
    private Integer questaoId;
}