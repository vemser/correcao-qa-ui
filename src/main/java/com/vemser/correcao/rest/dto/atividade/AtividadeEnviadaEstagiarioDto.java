package com.vemser.correcao.rest.dto.atividade;

import com.vemser.correcao.rest.dto.solucao.SolucaoQuestaoResponseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AtividadeEnviadaEstagiarioDto {

    private AtividadeDto atividade;
    private String userName;
    private Integer atividadesEnviadasId;
    private Integer atividadesId;
    private Double notaTestes;
    private String dataEnvio;
    private String feedbackInstrutor;
    private String status;
    private String comentarioAluno;
    private String criado;
    private String editado;
    private String estagiario;
    private List<SolucaoQuestaoResponseDto> solucaoEstagiario;
}
