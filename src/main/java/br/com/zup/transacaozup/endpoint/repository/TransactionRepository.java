package br.com.zup.transacaozup.endpoint.repository;

import br.com.zup.transacaozup.model.domain.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.validation.constraints.NotBlank;

public interface TransactionRepository extends JpaRepository<Transaction, String> {
    Page<Transaction> findAllByCardId(@NotBlank String cardId, Pageable pageable);
}
