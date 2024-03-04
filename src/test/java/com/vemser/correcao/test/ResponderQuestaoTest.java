package com.vemser.correcao.test;

import com.vemser.correcao.data.dto.LoginDto;
import com.vemser.correcao.data.factory.LoginData;
import com.vemser.correcao.page.LoginPage;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Epic("Responder questão - visão aluno")
@DisplayName("Tela de Responder Questão - Aluno")
@Owner("Luísa Santos")
public class ResponderQuestaoTest extends BaseTest {

    LoginPage loginPage = new LoginPage();
    LoginData loginData = new LoginData();

    @Test
    @Feature("Tela de Responder Questão (Aluno)")
    @Story("Responder questão com testes falhando com sucesso")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Teste que verifica se o aluno consegue enviar uma questão com testes falhando com sucesso")
    public void testAcessarAtividadeComSucesso() {

        LoginDto loginDto = loginData.loginEstagiarioComDadosValidos();
        loginPage.fazerLoginValido(loginDto.getEmail(), loginDto.getSenha());

        

    }
}
