package com.vemser.correcao.rest.dto.questao;


import com.vemser.correcao.rest.dto.teste.EditarTesteDto;
import com.vemser.correcao.rest.enums.Dificuldade;
import com.vemser.correcao.rest.enums.Linguagem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EditarQuestaoDto {
    private String codigo;
    private String descricao;
    private Dificuldade dificuldade;
    private Linguagem linguagem;
    private List<EditarTesteDto> testes;
    private String titulo;
}
