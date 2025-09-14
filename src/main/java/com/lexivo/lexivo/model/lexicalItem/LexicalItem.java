package com.lexivo.lexivo.model.lexicalItem;

import jakarta.persistence.*;

@MappedSuperclass
public abstract class LexicalItem {
	@Id
	private String id;
	@Embedded
	@AttributeOverrides({
			@AttributeOverride(name = "value", column = @Column(name = "original_value", columnDefinition = "TEXT")),
			@AttributeOverride(name = "details", column = @Column(name = "original_details", columnDefinition = "TEXT"))
	})
	private Text original;
	@Embedded
	@AttributeOverrides({
			@AttributeOverride(name = "value", column = @Column(name = "translation_value", columnDefinition = "TEXT")),
			@AttributeOverride(name = "details", column = @Column(name = "translation_details", columnDefinition = "TEXT"))
	})
	private Text translation;
	private String comment;
	private String hash;

	public LexicalItem() {
	}

	public LexicalItem(String id, Text original, Text translation, String comment, String hash) {
		this.id = id;
		this.original = original;
		this.translation = translation;
		this.comment = comment;
		this.hash = hash;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Text getOriginal() {
		return original;
	}

	public void setOriginal(Text original) {
		this.original = original;
	}

	public Text getTranslation() {
		return translation;
	}

	public void setTranslation(Text translation) {
		this.translation = translation;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	@Override
	public String toString() {
		return "LexicalItem{" +
				"id='" + id + '\'' +
				", original=" + original +
				", translation=" + translation +
				", comment='" + comment + '\'' +
				", hash='" + hash + '\'' +
				'}';
	}
}
