package com.stockid.stockid.Configs.DataBase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.stockid.stockid.Service.AnsiColorUtil;

@Component
public class InitDataLoader implements CommandLineRunner {

    @Autowired
    InitMarca initMarca;

    @Autowired
    InitProduto initProduto;

    @Autowired
    InitEstoque initEstoque;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Iniciando a aplicação...");

        try {
            initMarca.initMarcas();
            initProduto.initProduto();
            initEstoque.initEstoque();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println(AnsiColorUtil.colorText(
                "\n\n!! Aplicação iniciada e pronta para receber requisições !!", "GREEN"));
    }
}
