package com.devsuperior.dsmeta.exceptions;

public class SaleNotFoundException extends RuntimeException{

    public SaleNotFoundException(Long saleId) {
        super("Venda não encontrada: " + saleId);
    }

}
