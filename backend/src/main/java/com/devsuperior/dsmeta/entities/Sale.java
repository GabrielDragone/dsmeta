package com.devsuperior.dsmeta.entities;

import javax.persistence.*;
import java.time.LocalDate;

// Banco de Dados: seller_name, visited, deals, amount, date
@Entity // Preparamos a classe para ser equivalente à uma tabela no banco.
@Table(name = "tb_sales") // O nome da tabela no banco.
public class Sale {

    @Id // Esse atributo deve ser único, não pode se repetir pois ele que identifica cada uma das vendas no banco de dados.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto incremental, primeira venda código 1, dps código 2, assim por diante.
    private Long id;
    private String sellerName;
    private Integer visited;
    private Integer deals;
    private Double amount;
    private LocalDate date;

    public Sale() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public Integer getVisited() {
        return visited;
    }

    public void setVisited(Integer visited) {
        this.visited = visited;
    }

    public Integer getDeals() {
        return deals;
    }

    public void setDeals(Integer deals) {
        this.deals = deals;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
