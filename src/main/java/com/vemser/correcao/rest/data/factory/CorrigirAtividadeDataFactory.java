package com.vemser.correcao.rest.data.factory;

import com.github.javafaker.Faker;
import com.vemser.correcao.rest.dto.atividade.CorrigirAtividadeDto;


public class CorrigirAtividadeDataFactory {

    private static Faker faker = new Faker();

    public static CorrigirAtividadeDto corrigirComDadosValidos(Integer id) {

        CorrigirAtividadeDto corrigirAtividadeDto = new CorrigirAtividadeDto();
        corrigirAtividadeDto.setAtividadeEnviadaID(id);
        corrigirAtividadeDto.setFeedbackProfessor(faker.book().title());
        corrigirAtividadeDto.setNotaTestes(faker.number().numberBetween(1, 100));

        return corrigirAtividadeDto;
    }
}
