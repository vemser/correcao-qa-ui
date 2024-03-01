package com.vemser.correcao.data.factory;


import com.vemser.correcao.data.dto.LoginDto;
import com.vemser.correcao.util.DataFakerGenerator;
import com.vemser.correcao.util.Manipulation;

public class LoginData {
    DataFakerGenerator faker = new DataFakerGenerator();

    public LoginDto loginEstagiarioComDadosValidos() {
        LoginDto loginDto = new LoginDto();
        loginDto.setEmail(Manipulation.getProps().getProperty("EmailAluno"));
        loginDto.setSenha(Manipulation.getProps().getProperty("SenhaAluno"));
        return loginDto;
    }
    public LoginDto loginComDadosInvalidos() {
        LoginDto loginDto = new LoginDto();
        loginDto.setEmail(faker.email());
        loginDto.setSenha(faker.senha());
        return loginDto;
    }
    public LoginDto loginComDadosVazios() {
        LoginDto loginDto = new LoginDto();
        loginDto.setEmail("");
        loginDto.setSenha("");
        return loginDto;
    }
    public LoginDto loginComSenhaVazia() {
        LoginDto loginDto = new LoginDto();
        loginDto.setEmail(faker.email());
        loginDto.setSenha("");
        return loginDto;
    }
}