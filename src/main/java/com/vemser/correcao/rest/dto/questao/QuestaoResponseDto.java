package com.vemser.correcao.rest.dto.questao;

import com.vemser.correcao.rest.dto.teste.TesteResponseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestaoResponseDto {
    private QuestaoDto questaoDTO;
    private List<TesteResponseDto> testes;
}
