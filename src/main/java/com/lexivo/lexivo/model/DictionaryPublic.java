package com.lexivo.lexivo.model;

import com.lexivo.lexivo.model.grammar.Grammar;
import com.lexivo.lexivo.model.lexicalItem.Expression;
import com.lexivo.lexivo.model.lexicalItem.Word;

import java.util.List;

public class DictionaryPublic {
	private final String id;
	private final List<Grammar> grammarList;
	private final List<Word> words;
	private final List<Expression> expressions;
	private final Language language;

	public DictionaryPublic(Dictionary dictionary) {
		this.id = dictionary.getId();
		this.grammarList = dictionary.getGrammarList();
		this.words = dictionary.getWords();
		this.expressions = dictionary.getExpressions();
		this.language = dictionary.getLanguage();
	}

	public String getId() {
		return id;
	}

	public List<Grammar> getGrammarList() {
		return grammarList;
	}

	public List<Word> getWords() {
		return words;
	}

	public List<Expression> getExpressions() {
		return expressions;
	}

	public Language getLanguage() {
		return language;
	}

	@Override
	public String toString() {
		return "DictionaryPublic{" +
				"id='" + id + '\'' +
				", grammarList=" + grammarList +
				", words=" + words +
				", expressions=" + expressions +
				", language=" + language +
				'}';
	}
}
