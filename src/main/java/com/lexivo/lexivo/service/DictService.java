package com.lexivo.lexivo.service;

import com.lexivo.lexivo.exception.DictionaryNotFoundException;
import com.lexivo.lexivo.exception.UserNotFoundException;
import com.lexivo.lexivo.model.Dictionary;
import com.lexivo.lexivo.model.DictionaryPublic;
import com.lexivo.lexivo.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DictService {
	@Autowired
	private DictRepo dictRepo;
	@Autowired
	private LangRepo langRepo;
	@Autowired
	private ExpressionRepo expressionRepo;
	@Autowired
	private WordRepo wordRepo;
	@Autowired
	private GrammarRepo grammarRepo;
	@Autowired
	private GrammarSubmenuRepo grammarSubmenuRepo;
	@Autowired
	private UserRepo userRepo;

	public void addDict(Dictionary dictionary) throws UserNotFoundException {
		if (!userRepo.existsById(dictionary.getOwner().getId())) {
			throw new UserNotFoundException(dictionary.getOwner().getId());
		}

		if (!langRepo.existsById(dictionary.getLanguage().getLabel())) {
			langRepo.save(dictionary.getLanguage());
		}

		expressionRepo.saveAll(dictionary.getExpressions());
		wordRepo.saveAll(dictionary.getWords());
		for (var grammar : dictionary.getGrammarList()) {
			grammarSubmenuRepo.saveAll(grammar.getSubmenuList());
			grammarRepo.save(grammar);
		}

		dictRepo.save(dictionary);
	}

	public DictionaryPublic getDictById(String id) throws DictionaryNotFoundException {
		Dictionary dict = dictRepo.findById(id).orElse(null);
		if (dict == null) {
			throw new DictionaryNotFoundException(id);
		}
		return new DictionaryPublic(dict);
	}
	public List<DictionaryPublic> getAllDicts(String ownerId) {
		return dictRepo.findAllByOwnerId(ownerId).stream().map(DictionaryPublic::new).toList();
	}

	public void updateDict(Dictionary dictionary) throws DictionaryNotFoundException, UserNotFoundException {
		Dictionary dict = dictRepo.findById(dictionary.getId()).orElse(null);
		if (dict == null) {
			throw new DictionaryNotFoundException(dictionary.getId());
		}

		if (!userRepo.existsById(dictionary.getOwner().getId())) {
			throw new UserNotFoundException(dictionary.getOwner().getId());
		}

		if (!langRepo.existsById(dictionary.getLanguage().getLabel())) {
			langRepo.save(dictionary.getLanguage());
		}

		expressionRepo.saveAll(dictionary.getExpressions());
		wordRepo.saveAll(dictionary.getWords());
		for (var grammar : dictionary.getGrammarList()) {
			grammarSubmenuRepo.saveAll(grammar.getSubmenuList());
			grammarRepo.save(grammar);
		}

		dictRepo.save(dictionary);
	}

	public void deleteDictionary(String id) throws DictionaryNotFoundException {
		Dictionary dict = dictRepo.findById(id).orElse(null);
		if (dict == null) {
			throw new DictionaryNotFoundException(id);
		}

		dictRepo.deleteById(id);
	}
}
