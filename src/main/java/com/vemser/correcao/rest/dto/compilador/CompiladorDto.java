package com.vemser.correcao.rest.dto.compilador;

import com.vemser.correcao.rest.enums.Linguagem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompiladorDto {
    private String codigo;
    private Linguagem linguagem;
}
