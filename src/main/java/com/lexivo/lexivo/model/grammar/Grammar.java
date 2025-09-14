package com.lexivo.lexivo.model.grammar;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Grammar {
	@Id
	private String id;
	private String header;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "grammar_id")
	private List<GrammarSubmenu> submenuList;

	public Grammar() {
	}

	public Grammar(String id, String header, List<GrammarSubmenu> submenuList) {
		this.id = id;
		this.header = header;
		this.submenuList = submenuList;
	}

	public List<GrammarSubmenu> getSubmenuList() {
		return submenuList;
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

	public void setSubmenuList(List<GrammarSubmenu> submenuList) {
		this.submenuList = submenuList;
	}

	@Override
	public String toString() {
		return "Grammar{" +
				"id='" + id + '\'' +
				", header='" + header + '\'' +
				", submenuList=" + submenuList +
				'}';
	}
}
