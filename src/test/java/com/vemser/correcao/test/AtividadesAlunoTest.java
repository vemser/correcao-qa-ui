package com.vemser.correcao.test;

import com.vemser.correcao.data.dto.LoginDto;
import com.vemser.correcao.data.factory.LoginData;
import com.vemser.correcao.page.AtividadesAlunoPage;
import com.vemser.correcao.page.LoginPage;
import io.qameta.allure.*;
import org.junit.Test;

import static com.vemser.correcao.validate.AtividadesAlunoValidate.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@Epic("Visualizar atividades - visão aluno")
@Owner("Brayan Benet")
public class AtividadesAlunoTest extends BaseTest{

    AtividadesAlunoPage atividadesAlunoPage = new AtividadesAlunoPage();
    LoginPage loginPage = new LoginPage();
    LoginData loginData = new LoginData();

    @Test
    @Feature("Tela de Listagem de Atividades (Aluno)")
    @Story("Acessar atividades com sucesso")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Teste que verifica se o aluno consegue visualizar suas atividades")
    public void testAcessarAtividadeComSucesso() {

        LoginDto loginDto = loginData.loginEstagiarioComDadosValidos();
        loginPage.fazerLoginValido(loginDto.getEmail(), loginDto.getSenha());
        String telaAtividades = atividadesAlunoPage.validarTelaTodasAtividades();
        assertEquals(telaAtividades, TELA_ATIVIDADES_ALUNO);
        String statusAtividades = atividadesAlunoPage.validarStatusDaAtividade();
        assertNotNull(statusAtividades);
        atividadesAlunoPage.clicarVerAtividade();
        String telaAtividade = atividadesAlunoPage.validarTelaAtividade();
        assertEquals(telaAtividade, TELA_ATIVIDADE_ALUNO);
    }

//    @Test
//    @Feature("Tela de Listagem de Atividades (Aluno)")
//    @Story("Acessar atividades com o filtro de atribuídas")
//    @Severity(SeverityLevel.CRITICAL)
//    @Description("Teste que verifica se a funcionalidade de filtragem de atividades está funcionando")
//    public void testValidarFiltroAtividadesAtribuidas() {
//
//        LoginDto loginDto = loginData.loginEstagiarioComDadosValidos();
//        loginPage.fazerLoginValido(loginDto.getEmail(), loginDto.getSenha());
//
//        String telaAtividades = atividadesAlunoPage.validarTelaTodasAtividades();
//        assertEquals(telaAtividades, TELA_ATIVIDADES_ALUNO);
//        String statusAtividades = atividadesAlunoPage.validarStatusDaAtividade();
//        assertNotNull(statusAtividades);
//        String dropDown = atividadesAlunoPage.validarDropDown();
//        assertEquals(dropDown, TEXT_DROP_DOWN_FILTRO);
//        atividadesAlunoPage.clicarCampoDropDown();
//        atividadesAlunoPage.clicarCampoAtribuido();
//        String atividadePendente = atividadesAlunoPage.validarAtividadeAtribuida();
//        assertEquals(atividadePendente, TEXT_STATUS_ATRIBUIDA);
//    }

    @Test
    @Feature("Tela de Listagem de Atividades (Aluno)")
    @Story("Acessar atividades com o filtro de pendentes")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Teste que verifica se a funcionalidade de filtragem de atividades está funcionando")
    public void testValidarFiltroAtividadesPendentes() {

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
    @Story("Acessar atividades com o filtro de entregues")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Teste que verifica se a funcionalidade de filtragem de atividades está funcionando")
    public void testValidarFiltroAtividadesEntregues() {

        LoginDto loginDto = loginData.loginEstagiarioComDadosValidos();
        loginPage.fazerLoginValido(loginDto.getEmail(), loginDto.getSenha());

        String telaAtividades = atividadesAlunoPage.validarTelaTodasAtividades();
        assertEquals(telaAtividades, TELA_ATIVIDADES_ALUNO);
        String statusAtividades = atividadesAlunoPage.validarStatusDaAtividade();
        assertNotNull(statusAtividades);
        String dropDown = atividadesAlunoPage.validarDropDown();
        assertEquals(dropDown, TEXT_DROP_DOWN_FILTRO);
        atividadesAlunoPage.clicarCampoDropDown();
        atividadesAlunoPage.clicarCampoEntregue();
        String atividadeEntregue = atividadesAlunoPage.validarStatusDaAtividade();
        assertEquals(atividadeEntregue, TEXT_STATUS_ENTREGUE);
    }
}
