package com.vemser.correcao.rest.dto.solucao;


import com.vemser.correcao.rest.enums.Linguagem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SolucaoQuestaoDto {
    private Integer atividadeEnviadaId;
    private String codigo;
    private Linguagem linguagem;
    private Integer questaoId;
}
