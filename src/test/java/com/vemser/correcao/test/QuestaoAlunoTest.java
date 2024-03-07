package com.vemser.correcao.test;

import com.vemser.correcao.data.dto.LoginDto;
import com.vemser.correcao.data.factory.LoginData;
import com.vemser.correcao.page.AtividadeIDAlunoPage;
import com.vemser.correcao.page.AtividadesAlunoPage;
import com.vemser.correcao.page.LoginPage;
import com.vemser.correcao.page.ResponderQuestaoPage;
import com.vemser.correcao.rest.client.AtividadesInstrutorClient;
import com.vemser.correcao.rest.data.factory.CriarAtividadeDataFactory;
import com.vemser.correcao.rest.data.factory.QuestaoDataFactory;
import com.vemser.correcao.rest.dto.atividade.CriarAtividadeDto;
import com.vemser.correcao.rest.dto.atividade.CriarAtividadeResponseDto;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.vemser.correcao.validate.AtividadesAlunoValidate.TELA_ATIVIDADES_ALUNO;
import static com.vemser.correcao.validate.AtividadesAlunoValidate.TEXT_DROP_DOWN_FILTRO;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@Epic("Visualizar atividade - visão aluno")
@DisplayName("Página de atividade - Aluno")
@Owner("Vitor Colombo")
public class QuestaoAlunoTest extends BaseTest{
    AtividadesAlunoPage atividadesAlunoPage = new AtividadesAlunoPage();
    LoginPage loginPage = new LoginPage();
    LoginData loginData = new LoginData();
//WIP
//    @Test
//    @Feature("Tela de Questão (Aluno)")
//    @Story("[CTU13] Rodar Compilador Com Codigo Correto")
//    @Severity(SeverityLevel.CRITICAL)
//    @Description("Teste que verifica rodar o compilador com código correto")
//    public void testRodarCompiladorComCodigoCorreto() {
//        LoginDto loginDto = loginData.loginEstagiarioComDadosValidos();
//        loginPage.fazerLoginValido(loginDto.getEmail(), loginDto.getSenha());
//
//        String telaAtividades = atividadesAlunoPage.validarTelaTodasAtividades();
//        atividadesAlunoPage.clicarSegundaAtividade();
//
//        AtividadeIDAlunoPage atividadesIDAlunoPage = new AtividadeIDAlunoPage();
//        atividadesIDAlunoPage.preencherComentario(QuestaoDataFactory.tituloFaker());
//        atividadesIDAlunoPage.clicarResolverQuestao();
//        ResponderQuestaoPage responderQuestaoPage = new ResponderQuestaoPage();
//        responderQuestaoPage.preencherCodigoCompilador();
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        responderQuestaoPage.clicarRodarCodigo();
//        responderQuestaoPage.validarLerResposta();
//    }
}
