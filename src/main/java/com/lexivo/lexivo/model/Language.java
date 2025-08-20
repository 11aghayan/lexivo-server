package com.lexivo.lexivo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Language {
	@Id
	private String label;
	@Column(columnDefinition = "TEXT")
	private String flag;

	public Language() {
	}

	public Language(String label, String flag) {
		this.label = label;
		this.flag = flag;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}
}
