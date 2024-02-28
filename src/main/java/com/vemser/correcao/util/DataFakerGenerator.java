package com.vemser.correcao.util;

import com.github.javafaker.Faker;

import java.util.Locale;

public class DataFakerGenerator {

    private static final Faker faker = new Faker(new Locale("PT-BR"));

    public String descricao() {
        return faker.lorem().paragraph();
    }

    public String titulo() {
        return faker.lorem().sentence();
    }
}
