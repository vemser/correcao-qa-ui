package com.vemser.correcao.rest.dto.atividade;

import com.vemser.correcao.dto.questao.QuestaoDto;
import com.vemser.correcao.rest.enums.Exemplo;
import com.vemser.correcao.rest.enums.Trilha;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AtividadeDto {
    private Integer atividadeId;
    private Integer limiteEnvios;
    private String titulo;
    private String descricao;
    private String userName;
    private Trilha trilha;
    private String prazoEntrega;
    private ArrayList<QuestaoDto> questoes;
    private Exemplo ativo;
}
