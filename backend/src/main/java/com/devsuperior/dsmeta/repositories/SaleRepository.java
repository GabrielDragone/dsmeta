package com.devsuperior.dsmeta.repositories;

import com.devsuperior.dsmeta.entities.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

// Repository: Classe responsável por fazer as operações no banco de dados. Extende JpaRepository do tipo Sale e com o tipo Long (id).
// Dessa forma, o Spring já cria os componentes para deletar, salvar, buscar, etc...
public interface SaleRepository extends JpaRepository<Sale, Long> {
}
