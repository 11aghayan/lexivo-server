package com.lexivo.lexivo.repo;

import com.lexivo.lexivo.model.lexicalItem.Word;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WordRepo extends JpaRepository<Word, String> {
}
