package com.devsuperior.dsmeta;

import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping() // Buscar por data e de forma paginada, ou seja, não retornará mais todos os dados, e sim apenas um trecho:
    @RequestMapping(value = "/byDate")
    public Page<Sale> findSalesPaginatedByDate(
            @RequestParam(value = "minDate", defaultValue = "") String minDate, // Parâmetros que devem ser enviados para o front. Em caso de não preenchimento, valor padrão será String vazia
            @RequestParam(value = "maxDate", defaultValue = "") String maxDate,
            Pageable pageable) {
        return saleService.findSalesPaginatedByDate(minDate, maxDate, pageable);
    }

}
