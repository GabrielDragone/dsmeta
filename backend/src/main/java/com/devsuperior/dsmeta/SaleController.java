package com.devsuperior.dsmeta;

import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// É a classe que implementa a nossa API, ou seja, nossos endpoints. Para onde o front vai apontar para fazer as requisições pro back:
@RestController
@RequestMapping(value = "/sales") // Rota que iremos acessar.
public class SaleController {

    @Autowired
    private SaleService saleService;

    @GetMapping // Verbo GET. Responde via web usando HTTP protocolo WEB. Responde conteúdo json:
    public List<Sale> findSales() {
        return saleService.findSales();
    }

}
