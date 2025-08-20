package com.lexivo.lexivo.model.grammar;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.ArrayList;
import java.util.List;

@Entity
public class GrammarSubmenu {
	@Id
	private String id;
	private String header;
	@Column(columnDefinition = "TEXT[]")
	private List<String> explanations;
	@Column(columnDefinition = "TEXT[]")
	private List<String> examples;

	public GrammarSubmenu() {
	}

	public GrammarSubmenu(String id, String header, List<String> explanations, List<String> examples) {
		this.id = id;
		this.header = header;
		this.explanations = explanations;
		this.examples = examples;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public List<String> getExplanations() {
		return explanations;
	}

	public void setExplanations(List<String> explanations) {
		this.explanations = explanations;
	}

	public List<String> getExamples() {
		return examples;
	}

	public void setExamples(List<String> examples) {
		this.examples = examples;
	}
}
