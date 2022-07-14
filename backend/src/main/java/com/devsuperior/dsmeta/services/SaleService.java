package com.devsuperior.dsmeta.services;

import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.repositories.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// Classe responsável por implementar as operações de negócio/regras de negócios da classe Sale:
@Service // Registramos o SaleService como componente no sistema:
public class SaleService {

    @Autowired // Injeção de dependência
    private SaleRepository saleRepository;

    public List<Sale> findSales() {
        return saleRepository.findAll();
    }


}
