package com.vemser.correcao.test;

import com.vemser.correcao.page.AtividadesAlunoPage;
import org.junit.Test;

import static com.vemser.correcao.validate.AtividadesAlunoValidate.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class AtividadesAlunoTest extends BaseTest{

    AtividadesAlunoPage atividadesAlunoPage = new AtividadesAlunoPage();

    @Test
    public void testAcessarAtividadeComSucesso() {

        String telaAtividades = atividadesAlunoPage.validarTelaTodasAtividades();
        assertEquals(telaAtividades, TELA_ATIVIDADES_ALUNO);
        String statusAtividades = atividadesAlunoPage.validarStatusDaAtividade();
        assertNotNull(statusAtividades);
        atividadesAlunoPage.clicarVerAtividade();
        String telaAtividade = atividadesAlunoPage.validarTelaAtividade();
        assertEquals(telaAtividade, TELA_ATIVIDADE_ALUNO);
    }

    //@Test
    //public void testValidarFiltroAtividadesAtribuidas() {
    //}

    @Test
    public void testValidarFiltroAtividadesPendentes() {
        String telaAtividades = atividadesAlunoPage.validarTelaTodasAtividades();
        assertEquals(telaAtividades, TELA_ATIVIDADES_ALUNO);
        String statusAtividades = atividadesAlunoPage.validarStatusDaAtividade();
        assertNotNull(statusAtividades);
        String dropDown = atividadesAlunoPage.validarDropDown();
        assertEquals(dropDown, TEXT_DROP_DOWN_FILTRO);
        atividadesAlunoPage.clicarCampoDropDown();
        atividadesAlunoPage.preencherCampoDropDownFiltro("Pendentes");
        String atividadePendente = atividadesAlunoPage.validarAtividadePendente();
        assertEquals(atividadePendente, TEXT_STATUS_PENDENTE);
    }
}
