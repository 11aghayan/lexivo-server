package com.lexivo.lexivo.model.lexicalItem;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Text {
	@Column(columnDefinition = "TEXT")
	private String value;
	@Column(columnDefinition = "TEXT")
	private String details;

	public Text() {}

	public Text(String value, String details) {
		this.value = value;
		this.details = details;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}
}
