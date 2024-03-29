package com.vemser.correcao.rest.client;


import com.vemser.correcao.rest.dto.atividade.CriarAtividadeDto;
import com.vemser.correcao.rest.specs.AtividadesSpecs;
import com.vemser.correcao.rest.specs.LoginSpecs;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class AtividadesInstrutorClient {

    private static final String DELETAR_ATIVIDADE_POR_ID = "/atividades/deletar/{id}";
    private static final String LISTAR_TODAS_ATIVIDADES = "/atividades";
    private static final String CRIAR_ATIVIDADE = "/atividades/criar";
    private static final String CORRIGIR_ATIVIDADE = "/atividades/retorno-do-professor";
    private static final String EDITAR_ATIVIDADE = "/atividades/editar/{idAtividade}";
    private static final String EDITAR_ATIVIDADE_SEM_ID = "/atividades/editar/";

    public AtividadesInstrutorClient(){}

    public static Response criarAtividade(CriarAtividadeDto atividade) {
        return given()
                    .spec(AtividadesSpecs.atividadeInstrutorSpec())
                    .body(atividade)
                .when()
                    .post(CRIAR_ATIVIDADE);
    }

    public static Response criarAtividadeString(String atividade) {
        return given()
                .spec(AtividadesSpecs.atividadeInstrutorSpec())
                .body(atividade)
                .when()
                .post(CRIAR_ATIVIDADE);
    }

    public static Response excluirAtividade(Integer atividadeId) {
        return given()
                .spec(AtividadesSpecs.atividadeInstrutorSpec())
                .pathParam("id", atividadeId)
                .when()
                .delete(DELETAR_ATIVIDADE_POR_ID);
    }

    public static Response excluirAtividadeString(String atividadeId) {
        return given()
                .spec(AtividadesSpecs.atividadeInstrutorSpec())
                .pathParam("id", atividadeId)
                .when()
                .delete(DELETAR_ATIVIDADE_POR_ID);
    }

    public static Response editarAtividade(Integer atividadeId, CriarAtividadeDto atividadeEditada) {
        return given()
                .spec(AtividadesSpecs.atividadeInstrutorSpec())
                .pathParam("idAtividade", atividadeId)
                .body(atividadeEditada)
            .when()
                .put(EDITAR_ATIVIDADE);
    }

    public static Response editarAtividadeSemId(CriarAtividadeDto atividadeEditada) {
        return given()
                .spec(AtividadesSpecs.atividadeInstrutorSpec())
                .body(atividadeEditada)
                .when()
                .put(EDITAR_ATIVIDADE_SEM_ID);
    }

    public static Response editarAtividadeComoString(Integer atividadeId, String atividadeEditada) {
        return given()
                .spec(AtividadesSpecs.atividadeInstrutorSpec())
                .pathParam("idAtividade", atividadeId)
                .body(atividadeEditada)
                .when()
                .put(EDITAR_ATIVIDADE);
    }

    public static Response editarAtividadeSemAutenticacao(Integer atividadeId, CriarAtividadeDto atividadeEditada) {
        return given()
                .spec(LoginSpecs.reqSemTokenSpec())
                .pathParam("idAtividade", atividadeId)
                .body(atividadeEditada)
                .when()
                .put(EDITAR_ATIVIDADE);
    }
}
