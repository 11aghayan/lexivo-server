package com.lexivo.lexivo.repo;

import com.lexivo.lexivo.model.grammar.GrammarSubmenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrammarSubmenuRepo extends JpaRepository<GrammarSubmenu, String> {
}
