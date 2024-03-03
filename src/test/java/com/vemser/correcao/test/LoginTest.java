package com.vemser.correcao.test;


import com.vemser.correcao.data.dto.LoginDto;
import com.vemser.correcao.data.factory.LoginData;
import com.vemser.correcao.page.LoginPage;
import static com.vemser.correcao.validate.AtividadesAlunoValidate.TELA_ATIVIDADES_ALUNO;
import static com.vemser.correcao.validate.LoginValidate.*;
import io.qameta.allure.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Epic("Login")
@DisplayName("Login")
@Owner("Luísa dos Santos")
public class LoginTest extends BaseTest{

    LoginPage loginPage = new LoginPage();
    LoginData loginData = new LoginData();

    @Test
    @Feature("Formulário Login")
    @Story("[CTU01] Login estagiário dados válidos")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Teste que verifica se um estagiário consegue logar com email e senha válidos")
    public void verificaLoginEstagiarioDadosValidos() {
        LoginDto loginDto = loginData.loginEstagiarioComDadosValidos();

        String txtLogin = loginPage.lerTxtLogin();
        Assertions.assertEquals("Login", txtLogin);

        loginPage.preencherCampoEmail(loginDto.getEmail());
        loginPage.preencherCampoSenha(loginDto.getSenha());
        loginPage.clicarBtnLogin();

        String txtSuasAtividades = loginPage.lerTxtSuasAtividades();
        String txtBemVindo = loginPage.lerTxtSpan();
        Assertions.assertEquals(txtBemVindo, TXT_BEM_VINDO_ALUNO_TESTE);
        Assertions.assertEquals(txtSuasAtividades, TELA_ATIVIDADES_ALUNO);
    }

    @Test
    @Feature("Formulário Login")
    @Story("[CTU02] Login instrutor dados válidos")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Teste que verifica se um instrutor consegue logar com email e senha válidos")
    public void verificaLoginInstrutorDadosValidos() {
        LoginDto loginDto = loginData.loginInstrutorComDadosValidos();

        String txtLogin = loginPage.lerTxtLogin();
        Assertions.assertEquals(txtLogin, TELA_LOGIN);

        loginPage.preencherCampoEmail(loginDto.getEmail());
        loginPage.preencherCampoSenha(loginDto.getSenha());
        loginPage.clicarBtnLogin();

        String txtSuasAtividades = loginPage.lerTxtAtividades();
        String txtBemVindo = loginPage.lerTxtSpan();
        Assertions.assertEquals(txtBemVindo, TXT_BEM_VINDO_INSTRUTOR_TESTE);
        Assertions.assertEquals(txtSuasAtividades, TELA_INSTRUTOR_ATIVIDADES);
    }

    @Test
    @Feature("Formulário Login")
    @Story("[CTU03] Login dados inválidos")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Teste que verifica que um usuario não consegue logar com email e senha inválidos")
    public void verificaLoginDadosInvalidos() {
        LoginDto loginDto = loginData.loginComDadosInvalidos();

        String txtLogin = loginPage.lerTxtLogin();

        Assertions.assertEquals(txtLogin, TELA_LOGIN);


        loginPage.preencherCampoEmail(loginDto.getEmail());
        loginPage.preencherCampoSenha(loginDto.getSenha());
        loginPage.clicarBtnLogin();

        String txtErro = loginPage.lerTxtSpan();

        Assertions.assertEquals(txtErro, ERRO_EFETUAR_LOGIN);

    }

    @Test
    @Feature("Formulário Login")
    @Story("[CTU04] Login email vazio")
    @Severity(SeverityLevel.NORMAL)
    @Description("Teste que verifica se aparece um erro ao tentar logar com email vazio")
    public void verificaLoginEmailVazio() {
        LoginDto loginDto = loginData.loginComDadosInvalidos();
        loginPage.preencherCampoSenha(loginDto.getSenha());
        loginPage.clicarBtnLogin();
        String txtErroEmail = loginPage.lerTxtErroSenhaOuEmail();

        Assertions.assertEquals(txtErroEmail, ERRO_EMAIL_OBRIGATORIO);

    }

    @Test
    @Feature("Formulário Login")
    @Story("[CTU05] Login senha vazia")
    @Severity(SeverityLevel.NORMAL)
    @Description("Teste que verifica se aparece um erro ao tentar logar com senha vazia")
    public void verificaLoginSenhaVazia() {
        LoginDto loginDto = loginData.loginComDadosInvalidos();
        loginPage.preencherCampoEmail(loginDto.getEmail());
        loginPage.clicarBtnLogin();
        String txtErroSenha = loginPage.lerTxtErroSenhaOuEmail();

        Assertions.assertEquals(txtErroSenha, ERRO_SENHA_OBRIGATORIA);

    }

    @Test
    @Feature("Formulário Login")
    @Story("[CTU06] Login senha com menos de 8 caracteres")
    @Severity(SeverityLevel.NORMAL)
    @Description("Teste que verifica se aparece um erro ao tentar logar com senha com menos de 8 caracteres")
    public void verificaLoginSenhaMenosDeOitoCaracteres() {
        LoginDto loginDto = loginData.loginComDadosInvalidos();
        loginPage.preencherCampoEmail(loginDto.getEmail());
        loginPage.preencherCampoSenha("123456");
        loginPage.clicarBtnLogin();
        String txtErroSenha = loginPage.lerTxtErroSenhaOuEmail();

        Assertions.assertEquals(txtErroSenha, ERRO_SENHA_8_CARACTERES);
    }

    @Test
    @Feature("Formulário Login")
    @Story("[CTU07] Login email com menos de 21 caracteres")
    @Severity(SeverityLevel.NORMAL)
    @Description("Teste que verifica se aparece um erro ao tentar logar com email com menos de 21 caracteres")
    public void verificaLoginEmailMenosDeVinteEUmCaracteres() {
        LoginDto loginDto = loginData.loginComDadosInvalidos();
        loginPage.preencherCampoEmail("qa@teste.com");
        loginPage.preencherCampoSenha(loginDto.getSenha());
        loginPage.clicarBtnLogin();
        String txtErroSenha = loginPage.lerTxtErroSenhaOuEmail();
        Assertions.assertEquals(txtErroSenha, ERRO_EMAIL_21_CARACTERES);
    }

}
