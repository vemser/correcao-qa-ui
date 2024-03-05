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

import static com.vemser.correcao.validate.AtividadesAlunoValidate.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@Epic("Visualizar atividade - visão aluno")
@DisplayName("Página de atividade - Aluno")
@Owner("Vitor Colombo")
public class AtividadesIDAlunoTest extends BaseTest{
    AtividadesAlunoPage atividadesAlunoPage = new AtividadesAlunoPage();
    LoginPage loginPage = new LoginPage();
    LoginData loginData = new LoginData();

    @Test
    @Feature("Tela de Atividade (Aluno)")
    @Story("[CTU11] Enviar atividade sem resolver questões com sucesso")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Teste que verifica envio de atividade sem resolver questões com sucesso")
    public void testEnviarAtividadeSemResolverQuestoes() {
        CriarAtividadeDto atividade = CriarAtividadeDataFactory.atividadeComDadosValidos();
        CriarAtividadeResponseDto atividadeResult = AtividadesInstrutorClient.criarAtividade(atividade)
                .then()
                .statusCode(201)
                .extract().as(CriarAtividadeResponseDto.class);

        LoginDto loginDto = loginData.loginEstagiarioComDadosValidos();
        loginPage.fazerLoginValido(loginDto.getEmail(), loginDto.getSenha());

        String telaAtividades = atividadesAlunoPage.validarTelaTodasAtividades();
        assertEquals(telaAtividades, TELA_ATIVIDADES_ALUNO);
        String statusAtividades = atividadesAlunoPage.validarStatusDaAtividade();

        String dropDown = atividadesAlunoPage.validarDropDown();
        assertEquals(dropDown, TEXT_DROP_DOWN_FILTRO);
        atividadesAlunoPage.clicarCampoDropDown();
        atividadesAlunoPage.clicarCampoPendente();
        atividadesAlunoPage.clicarVerAtividade();

        AtividadeIDAlunoPage atividadesIDAlunoPage = new AtividadeIDAlunoPage();
        String nomeAtividade = atividadesIDAlunoPage.validarTituloAtividade();
        atividadesIDAlunoPage.preencherComentario(QuestaoDataFactory.tituloFaker());
        atividadesIDAlunoPage.clicarEnviarAtividade();
        atividadesIDAlunoPage.clicarConfirmarEnvio();
        String msgSucesso = loginPage.lerTxtSpan();
        assertEquals(msgSucesso, "Atividade enviada com sucesso!");
    }

    @Test
    @Feature("Tela de Atividade (Aluno)")
    @Story("[CTU12] Enviar atividade com sucesso resolvendo questões")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Teste que verifica envio de atividade sem resolver questões com sucesso")
    public void testAcessarPaginaDeQuestao() {
        LoginDto loginDto = loginData.loginEstagiarioComDadosValidos();
        loginPage.fazerLoginValido(loginDto.getEmail(), loginDto.getSenha());

        String telaAtividades = atividadesAlunoPage.validarTelaTodasAtividades();
        assertEquals(telaAtividades, TELA_ATIVIDADES_ALUNO);
        String statusAtividades = atividadesAlunoPage.validarStatusDaAtividade();

        String dropDown = atividadesAlunoPage.validarDropDown();
        assertEquals(dropDown, TEXT_DROP_DOWN_FILTRO);
        atividadesAlunoPage.clicarCampoDropDown();
        atividadesAlunoPage.clicarCampoPendente();
        atividadesAlunoPage.clicarVerAtividade();

        AtividadeIDAlunoPage atividadesIDAlunoPage = new AtividadeIDAlunoPage();
        String nomeAtividade = atividadesIDAlunoPage.validarTituloAtividade();
        atividadesIDAlunoPage.preencherComentario(QuestaoDataFactory.tituloFaker());
        atividadesIDAlunoPage.clicarResolverQuestao();
        ResponderQuestaoPage responderQuestaoPage = new ResponderQuestaoPage();
        String tituloQuestao = responderQuestaoPage.validarTituloQuestao();
        assertNotNull(tituloQuestao);
    }
}
