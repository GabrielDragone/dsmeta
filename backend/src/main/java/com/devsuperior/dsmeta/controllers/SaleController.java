package com.devsuperior.dsmeta.controllers;

import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.exceptions.SaleNotFoundException;
import com.devsuperior.dsmeta.services.SaleService;
import com.devsuperior.dsmeta.services.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.websocket.server.PathParam;
import java.util.List;

// É a classe que implementa a nossa API, ou seja, nossos endpoints. Para onde o front vai apontar para fazer as requisições pro back:
@RestController
@RequestMapping(value = "/sales") // Rota que iremos acessar.
public class SaleController {

    @Autowired
    private SaleService saleService;

    @Autowired
    private SmsService smsService;

    @GetMapping // Verbo GET. Responde via web usando HTTP protocolo WEB. Responde conteúdo json:
    public List<Sale> findSales() {
        return saleService.findSales();
    }

    @GetMapping("/byDate") // Buscar por data e de forma paginada, ou seja, não retornará mais todos os dados, e sim apenas um trecho:
    public Page<Sale> findSalesPaginatedByDate(
            @RequestParam(value = "minDate", defaultValue = "") String minDate, // Parâmetros que devem ser enviados para o front. Em caso de não preenchimento, valor padrão será String vazia
            @RequestParam(value = "maxDate", defaultValue = "") String maxDate,
            Pageable pageable) {
        return saleService.findSalesPaginatedByDate(minDate, maxDate, pageable);
    }

    @GetMapping("/notifySms")
    public void notifySms() {
        smsService.sendSms();
    }

    @GetMapping("{id}/notifySms") // Quando inserimos o parametro dessa forma, ele vira um PathVariable e deve ter o mesmo nome do parametro no método abaixo:
    public void notifySms(@PathVariable Long id) {
        try {
            smsService.sendSaleBySms(id);
        } catch (SaleNotFoundException e) {
            System.out.println(e.getMessage());
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
    }

}
