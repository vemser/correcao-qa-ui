package com.vemser.correcao.page;

import org.openqa.selenium.By;

public class AtividadesAlunoPage extends BasePage{

    private static final By textSuasAtividades =
            By.cssSelector("#root > main > div > section.AtividadesAtribuidas_subHeader__vd6g8 > h1");

    private static final By textStatusPrimeiraAtividade =
            By.cssSelector("#root > main > div > section.AtividadesAtribuidas_atividadesContainer__u1tYB > button:nth-child(1) > div.AtividadesAtribuidas_rightSection__N5\\+fK > p");

    private static final By textStatusSegundaAtividade =
            By.cssSelector("#root > main > div > section.AtividadesAtribuidas_atividadesContainer__u1tYB > button:nth-child(2) > div.AtividadesAtribuidas_rightSection__N5\\+fK > p");

    private static final By btnVerAtividade =
            By.cssSelector("#root > main > div > section.AtividadesAtribuidas_atividadesContainer__u1tYB > button:nth-child(1)");

    private static final By textTelaAtividade =
            By.cssSelector("#root > main > div > section.AtividadeAluno_questoesSection__yQWDu > h2");

    private static final By campoDropDownFiltro =
            By.cssSelector("[id='select-status']");

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

    public void preencherCampoDropDownFiltro(String status) {
        selecionarElemento(campoDropDownFiltro);
        preencherInput(campoDropDownFiltro, status);
    }

    public String validarDropDown() {
        return lerTexto(campoDropDownFiltro);
    }

    public String validarAtividadePendente() {
        return lerTexto(textStatusSegundaAtividade);
    }
}
