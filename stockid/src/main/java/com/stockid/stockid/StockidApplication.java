package com.stockid.stockid;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.stockid.stockid.Service.AnsiColorUtil;
import com.stockid.stockid.Service.ComunService;

@SpringBootApplication
public class StockidApplication {
	public static void main(String[] args) {
		
		ComunService.clearTerminal();

		System.out.println(AnsiColorUtil.colorText(
						" ######  ########  #######   ######  ##    ##    #### ########  \n" +
						"##    ##    ##    ##     ## ##    ## ##   ##      ##  ##     ## \n" +
						"##          ##    ##     ## ##       ##  ##       ##  ##     ## \n" +
						" ######     ##    ##     ## ##       #####        ##  ##     ## \n" +
						"      ##    ##    ##     ## ##       ##  ##       ##  ##     ## \n" +
						"##    ##    ##    ##     ## ##    ## ##   ##      ##  ##     ## \n" +
						" ######     ##     #######   ######  ##    ##    #### ########  ",
				"PURPLE"));
	
		SpringApplication.run(StockidApplication.class, args);
	}

}
