package com.lexivo.lexivo.repo;

import com.lexivo.lexivo.model.Dictionary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DictRepo extends JpaRepository<Dictionary, String> {
	List<Dictionary> findAllByOwnerId(String ownerId);
}
