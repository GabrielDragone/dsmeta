package com.devsuperior.dsmeta.services;

import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.repositories.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

// Classe responsável por implementar as operações de negócio/regras de negócios da classe Sale:
@Service // Registramos o SaleService como componente no sistema:
public class SaleService {

    @Autowired // Injeção de dependência
    private SaleRepository saleRepository;

    public List<Sale> findSales() {
        return saleRepository.findAll();
    }

    public Page<Sale> findSalesPaginatedByDate(String minDate, String maxDate, Pageable pageable) {

        // Pega a data de hoje:
        LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());

        // Faz a conversão das datas de String para LocalDate:
        LocalDate min = minDate.equals("") ? today.minusDays(30) : LocalDate.parse(minDate); // Hoje - 30 dias.
        LocalDate max = maxDate.equals("") ? today : LocalDate.parse(maxDate); // Expressão condicional ternária. Ou seja, o famoso if else na mesma linha.

        return saleRepository.findSalesPaginatedByDate(min, max, pageable);
    }


}
