package com.vemser.correcao.rest.utils;



import com.vemser.correcao.rest.client.LoginClient;
import com.vemser.correcao.rest.data.factory.LoginDataFactory;
import com.vemser.correcao.rest.dto.login.LoginDto;
import com.vemser.correcao.rest.dto.login.LoginResponseDto;

public class Auth {
    public static String obterTokenInstrutor() {
        LoginDto login = LoginDataFactory.loginInstrutor();

        String token = LoginClient.autenticar(login).getBody().asString();
        LoginResponseDto loginResponseDto = new LoginResponseDto(token);

        return loginResponseDto.getToken();
    }

    public static String obterTokenAluno() {
        LoginDto login = LoginDataFactory.loginAluno();

        String token = LoginClient.autenticar(login).getBody().asString();
        LoginResponseDto loginResponseDto = new LoginResponseDto(token);

        return loginResponseDto.getToken();
    }
}
