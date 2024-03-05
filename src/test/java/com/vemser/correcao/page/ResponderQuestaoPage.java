package com.vemser.correcao.page;

import org.openqa.selenium.By;

public class ResponderQuestaoPage extends BasePage {
    private static final By txtTitulo = By.cssSelector("[data-testid='titulo-questao']");
    private static final By txtLinguagem = By.cssSelector("[data-testid='linguagem-questao']");
    private static final By txtDificuldade = By.cssSelector("[data-testid='dificuldade-questao']");
    private static final By txtDescricao = By.cssSelector("[data-testid='descricao-questao']");
    private static final By txtValorEntradaExemplo = By.cssSelector("[data-testid='valor-entrada-exemplo']");
    private static final By txtValorSaidaExemplo = By.cssSelector("[data-testid='valor-saida-exemplo']");
    private static final By inputLinguagem = By.cssSelector("[data-testid='linguagem-input']");
    private static final By btnRodarCodigo = By.cssSelector("[data-testid='botao-rodar-codigo']");
    private static final By btnEnviarQuestao = By.cssSelector("[data-testid='botao-abrir-modal-confirmacao']");
    private static final By btnCancelarEnvio = By.cssSelector("[data-testid='botao-cancelar-envio']");
    private static final By btnEnviarQuestaoModal = By.cssSelector("[data-testid='botao-enviar-questao']");

    public String validarTituloQuestao() {
        return lerTexto(txtTitulo);
    }
}
