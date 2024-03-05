package com.vemser.correcao.page;

import org.openqa.selenium.By;

public class AtividadesAlunoPage extends BasePage{

    private static final By textSuasAtividades =
            By.cssSelector("[data-testid='titulo-suas-atividades']");

    private static final By textStatusPrimeiraAtividade =
            By.cssSelector("[data-testid='status-atividade']");

    private static final By btnVerAtividade =
            By.cssSelector("#root > main > div > section.AtividadesAtribuidas_atividadesContainer__u1tYB > button:nth-child(1) > div.AtividadesAtribuidas_rightSection__N5\\+fK > div > h2");

    private static final By textTelaAtividade =
            By.cssSelector("#root > main > div > section.AtividadeAluno_questoesSection__yQWDu > h2");

    private static final By btnPendentes =
            By.cssSelector("[data-testid='opcao-pendentes']");

    private static final By btnEntregue =
            By.cssSelector("[data-testid='opcao-ENTREGUE']");

    private static final By campoDropDownFiltro =
            By.cssSelector("[id='select-status']");

    private static final By btnVoltaPaginaPrincipal =
            By.cssSelector("[data-testid='botao-abrir-modal-confirmacao']");

    private static final By btnEnviarAtividade =
            By.cssSelector("[data-testid='logo-DBC']");

    private static final By btnConfirmarEnviarAtividade =
            By.cssSelector("[data-testid='botao-enviar-atividade']");

    private static final By campoStatusDois =
            By.cssSelector("#root > main > div > section.AtividadesAtribuidas_atividadesContainer__u1tYB > button:nth-child(1) > div.AtividadesAtribuidas_rightSection__N5\\+fK > p");

    private static final By primeiraQuestaoTitulo =
            By.cssSelector("data-testid='titulo-atividade']");

    public String validarTituloAtividade() {
        return lerTexto(primeiraQuestaoTitulo);
    }

    public String validarTelaTodasAtividades() {
        return lerTexto(textSuasAtividades);
    }

    public String validarStatusDaAtividade() {
        return lerTexto(textStatusPrimeiraAtividade);
    }

    public void clicarVerAtividade() {
        clicar(btnVerAtividade);
    }

    public String validarTelaAtividade() {
        return lerTexto(textTelaAtividade);
    }

    public void clicarCampoDropDown() {
        clicar(campoDropDownFiltro);
    }

    public void clicarCampoPendente() {
        clicar(btnPendentes);
    }

    public void clicarCampoEntregue() {
        clicar(btnEntregue);
    }

    public void clicarCampoConfirmarAtividade() {
        clicar(btnConfirmarEnviarAtividade);
    }

    public void clicarCampoEntregarAtividade() {
        clicar(btnEnviarAtividade);
    }

    public String validarDropDown() {
        return lerTexto(campoDropDownFiltro);
    }

    public void voltarPaginaPrincipal() {
        clicar(btnVoltaPaginaPrincipal);
    }

}
