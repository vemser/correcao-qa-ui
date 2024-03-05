package com.vemser.correcao.rest.dto.atividade;

import com.vemser.correcao.rest.enums.Trilha;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CriarAtividadeDto {

    private String descricao;
    private String edicaoVemSer;
    private String prazoEntrega;
    private ArrayList<Integer> questoesInt;
    private String titulo;
    private Trilha trilha;
}
