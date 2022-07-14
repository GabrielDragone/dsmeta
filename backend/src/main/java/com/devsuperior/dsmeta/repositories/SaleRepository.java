package com.devsuperior.dsmeta.repositories;

import com.devsuperior.dsmeta.entities.Sale;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;

// Repository: Classe responsável por fazer as operações no banco de dados. Extende JpaRepository do tipo Sale e com o tipo Long (id).
// Dessa forma, o Spring já cria os componentes para deletar, salvar, buscar, etc...
public interface SaleRepository extends JpaRepository<Sale, Long> {

    // Criamos um novo método que faz a busca paginada através de Query.
    // Usamos a linguagem de consulta JPQL, que resumidamente é o SQL do JPA.
    @Query("SELECT obj FROM Sale obj WHERE obj.date BETWEEN :min AND :max ORDER BY obj.amount DESC")
    Page<Sale> findSalesPaginatedByDate(LocalDate min, LocalDate max, Pageable pageable);

}
