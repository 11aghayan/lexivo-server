package com.lexivo.lexivo.model;

import com.lexivo.lexivo.model.grammar.Grammar;
import com.lexivo.lexivo.model.lexicalItem.Expression;
import com.lexivo.lexivo.model.lexicalItem.Word;
import jakarta.persistence.*;

import java.util.List;

@Entity
public final class Dictionary {
	@Id
	private String id;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "dict_id")
	private List<Grammar> grammarList;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "dict_id")
	private List<Word> words;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "dict_id")
	private List<Expression> expressions;
	@ManyToOne
	@JoinColumn(name = "language_label", nullable = false)
	private Language language;
	@ManyToOne(optional = false)
	@JoinColumn(
			name = "owner_id",
			referencedColumnName = "id",
			foreignKey = @ForeignKey(name = "fk_dictionary_owner")
	)
	private User owner;

	public Dictionary() {
	}

	public Dictionary(String id, List<Grammar> grammarList, List<Word> words, List<Expression> expressions, Language language, User owner) {
		this.id = id;
		this.grammarList = grammarList;
		this.words = words;
		this.expressions = expressions;
		this.language = language;
		this.owner = owner;
	}

	public Language getLanguage() {
		return language;
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setGrammarList(List<Grammar> grammarList) {
		this.grammarList = grammarList;
	}

	public void setWords(List<Word> words) {
		this.words = words;
	}

	public void setExpressions(List<Expression> expressions) {
		this.expressions = expressions;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}
}
