package com.stockid.stockid.Configs;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.stockid.stockid.Service.AnsiColorUtil;

@Component
public class StartupMessage implements CommandLineRunner {

    @Override
    public void run(String... args) {
       System.out.println(AnsiColorUtil.colorText(
    "\n\n!! Aplicação iniciada e pronta para receber requisições !!", "GREEN"));
    }

}
