package com.lexivo.lexivo.model.lexicalItem;

import com.lexivo.lexivo.model.enums.Gender;
import com.lexivo.lexivo.model.enums.WordType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity
public class Word extends LexicalItem {
	@Enumerated(EnumType.STRING)
	private WordType type;
	@Enumerated(EnumType.STRING)
	private Gender gender;
	private String past1;
	private String past2;
	private String plural;

	public Word() {
	}

	public Word(String id, Text original, Text translation, String comment, String hash, WordType type, Gender gender, String past1, String past2, String plural) {
		super(id, original, translation, comment, hash);
		this.type = type;
		this.gender = gender;
		this.past1 = past1;
		this.past2 = past2;
		this.plural = plural;
	}

	public WordType getType() {
		return type;
	}

	public void setType(WordType type) {
		this.type = type;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getPast1() {
		return past1;
	}

	public void setPast1(String past1) {
		this.past1 = past1;
	}

	public String getPast2() {
		return past2;
	}

	public void setPast2(String past2) {
		this.past2 = past2;
	}

	public String getPlural() {
		return plural;
	}

	public void setPlural(String plural) {
		this.plural = plural;
	}
}
