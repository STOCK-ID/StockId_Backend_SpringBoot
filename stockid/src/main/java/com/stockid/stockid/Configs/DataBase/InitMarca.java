package com.stockid.stockid.Configs.DataBase;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spec.speedspring.core.exception.RegistroJaExisteException;
import com.stockid.stockid.Repository.MarcaRepository;
import com.stockid.stockid.Service.MarcaService;
import com.stockid.stockid.model.Marca;

@Service
public class InitMarca {

    @Autowired
    MarcaRepository marcaRepository;

    @Autowired
    MarcaService marcaService;

    private List<Marca> marcas = new ArrayList<>();

    private void setMarca() {
        if (marcaRepository.count() == 0) {
            marcas.add(new Marca("Nestlé")); // Alimentos e bebidas

            marcas.add(new Marca("Samsung")); // Eletrônicos

            marcas.add(new Marca("Nike")); // Vestuário esportivo

            marcas.add(new Marca("BIC")); // Papelaria

            marcas.add(new Marca("Tramontina")); // Utensílios domésticos
        }
    }

    public void initMarcas() {
        System.out.println("Iniciando o INIT MARCAS");

        if(marcaRepository.count() == 0) {
            setMarca();

            System.out.println("===== Criando MARCAS =====");

            for(Marca marca : marcas) {
                System.out.println("=== MARCA: " + marca.getNome());

                try {
                    Marca m = marcaService.createMarca(marca);

                    if(m != null) {
                        System.out.println("Marca criada com sucesso!");
                    }
                } catch (RegistroJaExisteException e) {
                    System.out.println("Erro ao salvar marca: " + marca.getNome());
                    System.out.println("ERRO LOG: " + e.getMessage());
                }
            }
            System.out.println("===== Cadastro de MARCA FINALIZADO");
        }
        else {
            System.out.println("===== Já esxiste MARCAS REGISTRADAS!");
        }
    }
}
