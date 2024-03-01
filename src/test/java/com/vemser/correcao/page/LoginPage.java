package com.vemser.correcao.page;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    private static final By txtLogin = By.cssSelector("#root > div > section > h5");
    private static final By campoEmail = By.cssSelector("[data-testid='input-email']");
    private static final By campoSenha = By.cssSelector("[data-testid='input-senha']");
    private static final By btnLogin = By.cssSelector("[data-testid='botao-submit']");
    private static final By txtSpan = By.cssSelector("#notistack-snackbar");
    private static final By txtErroSenhaOuEmail = By.cssSelector("#root > div > section > form > div > p");

    public String lerTxtLogin() {
        return lerTexto(txtLogin);
    }
    public void preencherCampoEmail(String email) {
        preencherInput(campoEmail, email);
    }

    public void preencherCampoSenha(String senha) {
        preencherInput(campoSenha, senha);
    }

    public void clicarBtnLogin() {
        clicar(btnLogin);
    }

    public String lerTxtSpan() {
        return lerTexto(txtSpan);
    }

    public String lerTxtErroSenhaOuEmail() {
        return lerTexto(txtErroSenhaOuEmail);
    }

    public void fazerLoginValido(String email, String senha) {
        preencherInput(campoEmail, email);
        preencherInput(campoSenha, senha);
        clicar(btnLogin);
        String msgBemVindo = lerTexto(txtSpan);
        Assertions.assertEquals("Bem-vindo!", msgBemVindo);
    }



}
