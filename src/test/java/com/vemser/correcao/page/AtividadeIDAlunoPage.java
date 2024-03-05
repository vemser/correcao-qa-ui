package com.vemser.correcao.page;

import org.openqa.selenium.By;

public class AtividadeIDAlunoPage extends BasePage{
    private static final By textSuasAtividades =
            By.cssSelector("#root > main > div > section.AtividadesAtribuidas_subHeader__vd6g8 > h1");

    private static final By tituloAtividade =
            By.cssSelector("[data-testid='titulo-atividade']");

    private static final By seletorStatusQuestoes =
            By.cssSelector("[data-testid='select-status']");

    private static final By resolverBtn =
            By.cssSelector("[data-testid='botao-resolver-questao']");

    private static final By containerQuestoes =
            By.cssSelector("#root > main > div > section.AtividadeAluno_questoesSection__yQWDu > div.AtividadeAluno_questoesContainer__rL8NT");

    private static final By campoComentario =
            By.cssSelector("#campo-comentario");

    private static final By btnEnviarComentarioAtividade =
            By.cssSelector("[data-testid='botao-abrir-modal-confirmacao']");

    private static final By btnConfirmarEnvioModal =
            By.cssSelector("[data-testid='botao-enviar-atividade']");

    private static final By btnCancelarEnvioModal =
            By.cssSelector("[data-testid='botao-cancelar-envio']");

    private static final By msgAtividadeEnviadaComSucesso =
            By.cssSelector("#notistack-snackbar");

    public String validarMsgSucesso() {
        return lerTexto(msgAtividadeEnviadaComSucesso);
    }

    public String validarTituloAtividade() {
        return lerTexto(tituloAtividade);
    }
    public void clicarResolverQuestao() {
        clicar(resolverBtn);
    }
    public String validarBotaoResolver() {
        return lerTexto(resolverBtn);
    }
    public void clicarEnviarAtividade() {
        clicar(btnEnviarComentarioAtividade);
    }
    public void clicarConfirmarEnvio() {
        clicar(btnConfirmarEnvioModal);
    }
    public void clicarCancelarEnvio() {
        clicar(btnCancelarEnvioModal);
    }
    public void preencherComentario(String comentario) {
        preencherInput(campoComentario, comentario);
    }
    public void clicarDropDown() {
        clicar(seletorStatusQuestoes);
    }

}
