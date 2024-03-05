package com.vemser.correcao.test;

import com.vemser.correcao.service.SeleniumService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest extends SeleniumService {

    @BeforeEach
    public  void abrirNavegador(){
        initBrowser();
    }

//    @AfterEach
//    public  void fecharNavegador(){
//        tearDown();
//    }

}
