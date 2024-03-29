package com.vemser.correcao.rest.data.factory;

import com.github.javafaker.Faker;
import com.vemser.correcao.rest.dto.teste.EditarTesteDto;
import com.vemser.correcao.rest.dto.questao.QuestaoResponseDto;
import com.vemser.correcao.rest.dto.teste.TesteDto;
import com.vemser.correcao.rest.enums.Exemplo;


import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class TesteDataFactory {
    private static Faker faker = new Faker(new Locale("PT-BR"));

    private TesteDataFactory() {
    }

    public static String textoFaker() {
        return faker.lorem().sentence();
    }

    public static Exemplo exemploFaker() {
        return Exemplo.values()[faker.number().numberBetween(0, 1)];
    }

    public static Integer valorFaker() {
        return faker.number().numberBetween(0, 100);
    }

    public static String valorEntradaFaker(Integer valor1, Integer valor2) {
        return valor1 + " " + valor2;
    }

    public static String retornoEsperado(Integer valor1, Integer valor2) {
        return String.valueOf(valor1 + valor2);
    }

    public static ArrayList<TesteDto> testesCorretos(int quantidade) {
        ArrayList<TesteDto> testes = new ArrayList<>();

        for (int i = 0; i < quantidade; i++) {
            testes.add(testeAleatorio());
        }

        testes.add(testeSomaExemplo());
        testes.add(testeSomaNaoExemplo());

        return testes;
    }

    public static ArrayList<TesteDto> testesExemploInvalido() {
        ArrayList<TesteDto> testes = new ArrayList<>();
        testes.add(testeExemploInvalido());
        testes.add(testeSomaExemplo());

        return testes;
    }

    public static ArrayList<TesteDto> testesVazio() {
        return new ArrayList<>();
    }

    public static ArrayList<TesteDto> testesSomenteExemplos() {
        ArrayList<TesteDto> testes = new ArrayList<>();
        testes.add(testeSomaExemplo());
        testes.add(testeSomaExemplo());

        return testes;
    }

    public static ArrayList<TesteDto> testesSomenteNaoExemplos() {
        ArrayList<TesteDto> testes = new ArrayList<>();
        testes.add(testeSomaNaoExemplo());
        testes.add(testeSomaNaoExemplo());

        return testes;
    }

    public static ArrayList<TesteDto> testesApenasUmTeste() {
        ArrayList<TesteDto> testes = new ArrayList<>();
        testes.add(testeSomaExemplo());

        return testes;
    }

    public static ArrayList<TesteDto> limiteMinimoTestes() {
        ArrayList<TesteDto> testes = new ArrayList<>();
        testes.add(testeSomaExemplo());
        testes.add(testeSomaNaoExemplo());
        return testes;
    }

    public static ArrayList<TesteDto> testesCom4Exemplos() {
        ArrayList<TesteDto> testes = new ArrayList<>();
        testes.add(testeSomaExemplo());
        testes.add(testeSomaExemplo());
        testes.add(testeSomaExemplo());
        testes.add(testeSomaExemplo());
        testes.add(testeSomaNaoExemplo());

        return testes;
    }

    public static ArrayList<TesteDto> testesCom8NaoExemplos() {
        ArrayList<TesteDto> testes = new ArrayList<>();
        testes.add(testeSomaExemplo());
        testes.add(testeSomaNaoExemplo());
        testes.add(testeSomaNaoExemplo());
        testes.add(testeSomaNaoExemplo());
        testes.add(testeSomaNaoExemplo());
        testes.add(testeSomaNaoExemplo());
        testes.add(testeSomaNaoExemplo());
        testes.add(testeSomaNaoExemplo());
        testes.add(testeSomaNaoExemplo());

        return testes;
    }

    public static ArrayList<TesteDto> testesComValorDeEntradaVazio() {
        ArrayList<TesteDto> testes = new ArrayList<>();
        testes.add(testeValorDeEntradaVazioExemplo());
        testes.add(testeValorDeEntradaVazioNaoExemplo());

        return testes;
    }

    public static ArrayList<TesteDto> testesComRetornoEsperadoVazio() {
        ArrayList<TesteDto> testes = new ArrayList<>();
        testes.add(testeRetornoEsperadoVazioExemplo());
        testes.add(testeRetornoEsperadoVazioNaoExemplo());

        return testes;
    }

    public static TesteDto testeAleatorio() {
        TesteDto teste = new TesteDto();
        teste.setExemplo(exemploFaker());
        teste.setValorEntrada(textoFaker());
        teste.setRetornoEsperado(textoFaker());

        return teste;
    }

    public static TesteDto testeValorDeEntradaVazioExemplo() {
        TesteDto teste = new TesteDto();
        teste.setExemplo(Exemplo.SIM);
        teste.setValorEntrada("");
        teste.setRetornoEsperado(textoFaker());

        return teste;
    }

    public static TesteDto testeValorDeEntradaVazioNaoExemplo() {
        TesteDto teste = new TesteDto();
        teste.setExemplo(Exemplo.NAO);
        teste.setValorEntrada("");
        teste.setRetornoEsperado(textoFaker());

        return teste;
    }

    public static TesteDto testeRetornoEsperadoVazioExemplo() {
        TesteDto teste = new TesteDto();
        teste.setExemplo(Exemplo.SIM);
        teste.setValorEntrada(textoFaker());
        teste.setRetornoEsperado("");

        return teste;
    }

    public static TesteDto testeRetornoEsperadoVazioNaoExemplo() {
        TesteDto teste = new TesteDto();
        teste.setExemplo(Exemplo.NAO);
        teste.setValorEntrada(textoFaker());
        teste.setRetornoEsperado("");

        return teste;
    }

    public static TesteDto testeSomaNaoExemplo() {
        Integer valor1 = valorFaker();
        Integer valor2 = valorFaker();

        TesteDto teste = new TesteDto();
        teste.setExemplo(Exemplo.NAO);
        teste.setValorEntrada(valorEntradaFaker(valor1, valor2));
        teste.setRetornoEsperado(retornoEsperado(valor1, valor2));

        return teste;
    }

    public static TesteDto testeSomaExemplo() {
        Integer valor1 = valorFaker();
        Integer valor2 = valorFaker();

        TesteDto teste = new TesteDto();
        teste.setExemplo(Exemplo.SIM);
        teste.setValorEntrada(valorEntradaFaker(valor1, valor2));
        teste.setRetornoEsperado(retornoEsperado(valor1, valor2));

        return teste;
    }

    public static TesteDto testeExemploInvalido() {
        TesteDto teste = new TesteDto();
        teste.setExemplo(Exemplo.NAO_SEI);
        teste.setValorEntrada(textoFaker());
        teste.setRetornoEsperado(textoFaker());

        return teste;
    }

    public static List<EditarTesteDto> editarTesteValido(QuestaoResponseDto questaoResult, EditarTesteDto testeDto, int quantidadeDeTestes) {
        List<EditarTesteDto> listaTestesEditados = new ArrayList<>();
        for (int i=0; i<quantidadeDeTestes; i++) {
            testeDto.setExemplo(questaoResult.getTestes().get(i).getExemplo());
            testeDto.setRetornoEsperado(questaoResult.getTestes().get(i).getRetornoEsperado());
            testeDto.setTesteId(questaoResult.getTestes().get(i).getTesteId());
            testeDto.setValorEntrada(questaoResult.getTestes().get(i).getValorEntrada());
            listaTestesEditados.add(testeDto);
        }
        return listaTestesEditados;
    }

    public static List<EditarTesteDto> editarTesteCamposVaziosExcetoId(QuestaoResponseDto questaoResult, EditarTesteDto testeDto, int quantidadeDeTestes) {
        List<EditarTesteDto> listaTestesEditados = new ArrayList<>();
        for (int i=0; i<quantidadeDeTestes; i++) {
            testeDto.setExemplo("");
            testeDto.setRetornoEsperado("");
            testeDto.setTesteId(questaoResult.getTestes().get(i).getTesteId());
            testeDto.setValorEntrada("");
            listaTestesEditados.add(testeDto);
        }
        return listaTestesEditados;
    }
}
