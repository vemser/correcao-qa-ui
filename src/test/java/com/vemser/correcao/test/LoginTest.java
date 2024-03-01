package com.vemser.correcao.test;


import com.vemser.correcao.data.dto.LoginDto;
import com.vemser.correcao.data.factory.LoginData;
import com.vemser.correcao.page.LoginPage;
import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@Epic("Login")
@Owner("Luísa dos Santos")
public class LoginTest extends BaseTest{

    LoginPage loginPage = new LoginPage();
    LoginData loginData = new LoginData();

    @Test
    @Feature("Formulário Login")
    @Story("Login estagiário dados válidos")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Teste que verifica se um estagiário consegue logar com email e senha válidos")
    public void verificaLoginEstagiarioDadosValidos() {
        LoginDto loginDto = loginData.loginEstagiarioComDadosValidos();

        String txtLogin = loginPage.lerTxtLogin();
        Assertions.assertEquals("Login", txtLogin);

        loginPage.preencherCampoEmail(loginDto.getEmail());
        loginPage.preencherCampoSenha(loginDto.getSenha());
        loginPage.clicarBtnLogin();

        String txtBemVindo = loginPage.lerTxtSpan();
        Assertions.assertEquals("Bem-vindo!", txtBemVindo);
    }

    @Test
    @Feature("Formulário Login")
    @Story("Login dados inválidos")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Teste que verifica que um usuario não consegue logar com email e senha inválidos")
    public void verificaLoginDadosInvalidos() {
        LoginDto loginDto = loginData.loginComDadosInvalidos();

        String txtLogin = loginPage.lerTxtLogin();
        Assertions.assertEquals("Login", txtLogin);

        loginPage.preencherCampoEmail(loginDto.getEmail());
        loginPage.preencherCampoSenha(loginDto.getSenha());
        loginPage.clicarBtnLogin();

        String txtErro = loginPage.lerTxtSpan();
        Assertions.assertEquals("Erro: credenciais inválidas", txtErro);
    }

    @Test
    @Feature("Formulário Login")
    @Story("Login email vazio")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Teste que verifica se aparece um erro ao tentar logar com email vazio")
    public void verificaLoginEmailVazio() {
        LoginDto loginDto = loginData.loginComDadosInvalidos();
        loginPage.preencherCampoSenha(loginDto.getSenha());
        loginPage.clicarBtnLogin();
        String txtErroEmail = loginPage.lerTxtErroSenhaOuEmail();
        Assertions.assertEquals("Email é obrigatório", txtErroEmail);
    }

    @Test
    @Feature("Formulário Login")
    @Story("Login senha vazia")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Teste que verifica se aparece um erro ao tentar logar com senha vazia")
    public void verificaLoginSenhaVazia() {
        LoginDto loginDto = loginData.loginComDadosInvalidos();
        loginPage.preencherCampoEmail(loginDto.getEmail());
        loginPage.clicarBtnLogin();
        String txtErroSenha = loginPage.lerTxtErroSenhaOuEmail();
        Assertions.assertEquals("Senha é obrigatória", txtErroSenha);
    }

    @Test
    @Feature("Formulário Login")
    @Story("Login senha com menos de 8 caracteres")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Teste que verifica se aparece um erro ao tentar logar com senha com menos de 8 caracteres")
    public void verificaLoginSenhaMenosDeOitoCaracteres() {
        LoginDto loginDto = loginData.loginComDadosInvalidos();
        loginPage.preencherCampoEmail(loginDto.getEmail());
        loginPage.preencherCampoSenha("123456");
        loginPage.clicarBtnLogin();
        String txtErroSenha = loginPage.lerTxtErroSenhaOuEmail();
        Assertions.assertEquals("Senha precisa ter no mínimo 8 caracteres", txtErroSenha);
    }

}
