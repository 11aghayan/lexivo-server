package com.lexivo.lexivo.repo;

import com.lexivo.lexivo.model.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LangRepo extends JpaRepository<Language, String> {

}
