package com.vemser.correcao.rest.specs;

import com.vemser.correcao.rest.utils.Auth;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class AtividadesSpecs {

    public static RequestSpecification atividadeInstrutorSpec() {
        String tokenInstrutor = Auth.obterTokenInstrutor();

        return new RequestSpecBuilder()
                .addRequestSpecification(InicialSpecs.setupApi())
                .setContentType(ContentType.JSON)
                .addHeader("Authorization", tokenInstrutor)
                .build();
    }

    public static RequestSpecification atividadeAlunoSpec() {
        String tokenAluno = Auth.obterTokenAluno();

        return new RequestSpecBuilder()
                .addRequestSpecification(InicialSpecs.setupApi())
                .setContentType(ContentType.JSON)
                .addHeader("Authorization", tokenAluno)
                .build();
    }
}
