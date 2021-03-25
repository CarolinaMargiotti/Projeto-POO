package com.jerso.projetopoo.db;

import org.springframework.data.jpa.repository.JpaRepository;
import com.jerso.projetopoo.model.unidade.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
