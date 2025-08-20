package com.lexivo.lexivo.model.lexicalItem;

import com.lexivo.lexivo.model.enums.Tense;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity
public class Expression extends LexicalItem {
	@Enumerated(EnumType.STRING)
	private Tense tense;
	private boolean isQuestion = false;

	public Expression() {
	}

	public Expression(String id, Text original, Text translation, String comment, String hash, Tense tense, boolean isQuestion) {
		super(id, original, translation, comment, hash);
		this.tense = tense;
		this.isQuestion = isQuestion;
	}

	public Tense getTense() {
		return tense;
	}

	public void setTense(Tense tense) {
		this.tense = tense;
	}

	public boolean isQuestion() {
		return isQuestion;
	}

	public void setQuestion(boolean question) {
		isQuestion = question;
	}
}
