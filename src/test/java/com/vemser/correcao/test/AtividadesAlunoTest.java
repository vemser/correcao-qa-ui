package com.vemser.correcao.test;

import com.vemser.correcao.data.dto.LoginDto;
import com.vemser.correcao.data.factory.LoginData;
import com.vemser.correcao.page.AtividadesAlunoPage;
import com.vemser.correcao.page.LoginPage;
import com.vemser.correcao.rest.client.AtividadesInstrutorClient;
import com.vemser.correcao.rest.data.factory.CriarAtividadeDataFactory;
import com.vemser.correcao.rest.dto.atividade.CriarAtividadeDto;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.vemser.correcao.validate.AtividadesAlunoValidate.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@Epic("Visualizar atividades - visão aluno")
@DisplayName("Tela de atividades - Aluno")
@Owner("Brayan Benet")
public class AtividadesAlunoTest extends BaseTest{

    AtividadesAlunoPage atividadesAlunoPage = new AtividadesAlunoPage();
    LoginPage loginPage = new LoginPage();
    LoginData loginData = new LoginData();

    @Test
    @Feature("Tela de Listagem de Atividades (Aluno)")
    @Story("[CTU08] Acessar atividades com sucesso")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Teste que verifica se o aluno consegue visualizar suas atividades")
    public void testAcessarAtividadeComSucesso() {

        CriarAtividadeDto atividade = CriarAtividadeDataFactory.atividadeComDadosValidos();
        AtividadesInstrutorClient.criarAtividade(atividade);

        LoginDto loginDto = loginData.loginEstagiarioComDadosValidos();
        loginPage.fazerLoginValido(loginDto.getEmail(), loginDto.getSenha());
        String telaAtividades = atividadesAlunoPage.validarTelaTodasAtividades();
        assertEquals(telaAtividades, TELA_ATIVIDADES_ALUNO);
        String statusAtividades = atividadesAlunoPage.validarStatusDaAtividade();
        assertEquals(statusAtividades, TEXT_STATUS_PENDENTE);
        atividadesAlunoPage.clicarVerAtividade();
        String telaAtividade = atividadesAlunoPage.validarTelaAtividade();
        assertEquals(telaAtividade, TELA_ATIVIDADE_ALUNO);
    }

    @Test
    @Feature("Tela de Listagem de Atividades (Aluno)")
    @Story("[CTU09] Acessar atividades com o filtro de pendentes")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Teste que verifica se a funcionalidade de filtragem de atividades está funcionando")
    public void testValidarFiltroAtividadesPendentes() {

        CriarAtividadeDto atividade = CriarAtividadeDataFactory.atividadeComDadosValidos();
        AtividadesInstrutorClient.criarAtividade(atividade);

        LoginDto loginDto = loginData.loginEstagiarioComDadosValidos();
        loginPage.fazerLoginValido(loginDto.getEmail(), loginDto.getSenha());
        String telaAtividades = atividadesAlunoPage.validarTelaTodasAtividades();
        assertEquals(telaAtividades, TELA_ATIVIDADES_ALUNO);
        String statusAtividades = atividadesAlunoPage.validarStatusDaAtividade();
        assertNotNull(statusAtividades);
        String dropDown = atividadesAlunoPage.validarDropDown();
        assertEquals(dropDown, TEXT_DROP_DOWN_FILTRO);
        atividadesAlunoPage.clicarCampoDropDown();
        atividadesAlunoPage.clicarCampoPendente();
        String atividadePendente = atividadesAlunoPage.validarStatusDaAtividade();
        assertEquals(atividadePendente, TEXT_STATUS_PENDENTE);
    }

    @Test
    @Feature("Tela de Listagem de Atividades (Aluno)")
    @Story("[CTU10] Acessar atividades com o filtro de entregues")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Teste que verifica se a funcionalidade de filtragem de atividades está funcionando")
    public void testValidarFiltroAtividadesEntregues() {

        CriarAtividadeDto atividade = CriarAtividadeDataFactory.atividadeComDadosValidosTituloCerto();
        AtividadesInstrutorClient.criarAtividade(atividade);

        LoginDto loginDto = loginData.loginEstagiarioComDadosValidos();
        loginPage.fazerLoginValido(loginDto.getEmail(), loginDto.getSenha());
        String telaAtividades = atividadesAlunoPage.validarTelaTodasAtividades();
        assertEquals(telaAtividades, TELA_ATIVIDADES_ALUNO);
        String statusAtividades = atividadesAlunoPage.validarStatusDaAtividade();
        assertEquals(statusAtividades, TEXT_STATUS_PENDENTE);
        atividadesAlunoPage.clicarVerAtividade();
        String telaAtividade = atividadesAlunoPage.validarTelaAtividade();
        assertEquals(telaAtividade, TELA_ATIVIDADE_ALUNO);
        atividadesAlunoPage.clicarCampoEntregarAtividade();
        atividadesAlunoPage.clicarCampoDropDown();
        atividadesAlunoPage.clicarCampoEntregue();
        String statusEntregue = atividadesAlunoPage.validarStatusDaAtividade();
        assertEquals(statusEntregue, TEXT_STATUS_ENTREGUE);

    }
}
