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
    private static final By campoCompilador = By.cssSelector("#root > main > div > div.EditorCodigo_editorContainer__scE4i > div.EditorCodigo_editor__3d2ep > div > div > div.cm-scroller > div.cm-content > div");
    private static final By respostaExemplo = By.cssSelector("#root > main > div > div.EditorCodigo_editorContainer__scE4i > div.EditorCodigo_testeVisivel__wWW0Z.EditorCodigo_parabens__0PhoP > div > div");
    public String validarTituloQuestao() {
        return lerTexto(txtTitulo);
    }

    public String validarLinguagemQuestao() {
        return lerTexto(txtLinguagem);
    }
    public String validarDificuldadeQuestao() {
        return lerTexto(txtDificuldade);
    }
    public String validarDescricaoQuestao() {
        return lerTexto(txtDescricao);
    }
    public String validarValorEntradaExemplo() {
        return lerTexto(txtValorEntradaExemplo);
    }
    public String validarValorSaidaExemplo() {
        return lerTexto(txtValorSaidaExemplo);
    }
    public void preencherLinguagem(String linguagem) {
        preencherInput(inputLinguagem, linguagem);
    }
    public void preencherCodigoCompilador() {
        clicar(campoCompilador);
        clicar(campoCompilador);
        clicar(campoCompilador);

        String valorSaidaExemplo = lerTexto(txtValorSaidaExemplo);
        String codigo = "public class Main {\n" +
                "    public static void main(String[] args) {\n" +
                "        System.out.println(\"" + valorSaidaExemplo + "\");\n" +
                "    }\n" +
                "}";
        preencherInput(campoCompilador, codigo);
    }
    public void clicarRodarCodigo() {
        clicar(btnRodarCodigo);
    }
    public void validarLerResposta() {
        esperarElemento(respostaExemplo);
    }
}
