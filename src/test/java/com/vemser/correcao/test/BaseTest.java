package com.vemser.correcao.test;

import com.vemser.correcao.service.SeleniumService;
import org.junit.After;
import org.junit.Before;

public class BaseTest extends SeleniumService {

    @Before
    public  void abrirNavegador(){
        initBrowser();
    }

    @After
    public  void fecharNavegador(){
        tearDown();
    }

}
