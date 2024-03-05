package com.vemser.correcao.rest.dto.questao;

import com.vemser.correcao.rest.enums.Dificuldade;
import com.vemser.correcao.rest.enums.Linguagem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.vemser.correcao.rest.dto.teste.TesteDto;
import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestaoDto {
    private Integer questaoId;
    private String codigo;
    private String descricao;
    private Dificuldade dificuldade;
    private Linguagem linguagem;
    private String titulo;
    private ArrayList<TesteDto> testes;
    private String criado;
    private String editado;
    private String ativo;
}
