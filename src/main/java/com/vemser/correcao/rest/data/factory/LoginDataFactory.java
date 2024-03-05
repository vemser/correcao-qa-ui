package com.vemser.correcao.rest.data.factory;


import com.vemser.correcao.rest.dto.login.LoginDto;
import com.vemser.correcao.rest.utils.Manipulation;

public class LoginDataFactory {
    public static LoginDto loginAluno() {
        LoginDto loginAluno = new LoginDto();
        loginAluno.setUsername(Manipulation.getProps().getProperty("AlunoUsername"));
        loginAluno.setPassword(Manipulation.getProps().getProperty("AlunoPassword"));
        return loginAluno;
    }

    public static LoginDto loginInstrutor() {
        LoginDto loginAluno = new LoginDto();
        loginAluno.setUsername(Manipulation.getProps().getProperty("InstrutorUsername"));
        loginAluno.setPassword(Manipulation.getProps().getProperty("InstrutorPassword"));
        return loginAluno;
    }
}
