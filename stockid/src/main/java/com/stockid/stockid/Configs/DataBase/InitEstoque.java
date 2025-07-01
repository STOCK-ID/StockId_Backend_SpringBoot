package com.stockid.stockid.Configs.DataBase;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stockid.stockid.Repository.EstoqueRepository;
import com.stockid.stockid.Service.EstoqueService;
import com.stockid.stockid.enums.EnumStatusLote;
import com.stockid.stockid.model.Estoque;
import com.stockid.stockid.model.WriteDTOs.EstoqueWriteDTO;

@Service
public class InitEstoque {

    @Autowired
    EstoqueRepository estoqueRepository;

    @Autowired
    EstoqueService estoqueService;

    List<EstoqueWriteDTO> lotes = new ArrayList<>();

    private void setLotes() {
        if (estoqueRepository.count() == 0) {
            // Produto 1 – Achocolatado Nescau
            lotes.add(new EstoqueWriteDTO(1, "NSC-202406", 50, 10, "lata 400g", LocalDate.of(2025, 6, 15),
                    LocalDate.of(2024, 6, 1), 4.50, 6.99, EnumStatusLote.ATIVO));
            lotes.add(new EstoqueWriteDTO(1, "NSC-202407", 30, 10, "lata 400g", LocalDate.of(2025, 7, 15),
                    LocalDate.of(2024, 6, 15), 4.70, 7.19, EnumStatusLote.ATIVO));

            // Produto 2 – Smartphone Galaxy A14
            lotes.add(new EstoqueWriteDTO(2, "SAM-A14-001", 10, 2, "unidade", null, LocalDate.of(2024, 5, 20), 950.00,
                    1199.99, EnumStatusLote.ATIVO));
            lotes.add(new EstoqueWriteDTO(2, "SAM-A14-002", 5, 2, "unidade", null, LocalDate.of(2024, 6, 10), 970.00,
                    1229.99, EnumStatusLote.ATIVO));

            // Produto 3 – Tênis Nike Revolution 6
            lotes.add(new EstoqueWriteDTO(3, "NIKE-REV6-01", 12, 4, "par", null, LocalDate.of(2024, 6, 2), 180.00,
                    249.90, EnumStatusLote.ATIVO));

            // Produto 4 – Caneta BIC
            lotes.add(new EstoqueWriteDTO(4, "BIC-BLUE10", 200, 50, "pacote c/10", null, LocalDate.of(2024, 6, 5), 5.50,
                    9.90, EnumStatusLote.ATIVO));

            // Produto 5 – Faca Tramontina
            lotes.add(new EstoqueWriteDTO(5, "TRAM-CHUR-01", 20, 5, "unidade", null, LocalDate.of(2024, 6, 3), 15.00,
                    29.90, EnumStatusLote.ATIVO));
        }
    }

    public void initEstoque() {
        System.out.println("\n\nIniciando INIT ESTOQUE");

        if (estoqueRepository.count() == 0) {
            setLotes();

            System.out.println("===== CRIANDO LOTES =====");

            for (EstoqueWriteDTO lote : lotes) {
                System.out.println("=== LOTE: " + lote.getLote());

                try {
                    Estoque e = estoqueService.createLote(lote);

                    if (e != null) {
                        System.out.println("Lote criando com sucesso!");
                    }
                } catch (Exception e) {
                    System.out.println("Erro ao salvar marca: " + lote.getLote());
                    System.out.println("ERRO LOG: " + e.getMessage());
                }
            }
            System.out.println("===== Cadastro de LOTE FINALIZADO");
        } else {
            System.out.println("===== Já existe LOTES REGISTRADOS");
        }
    }
}
