package com.lexivo.lexivo.repo;

import com.lexivo.lexivo.model.grammar.Grammar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrammarRepo extends JpaRepository<Grammar, String> {
}
