package com.mic.document.entity;

import java.util.List;

public class DocumentSearchResult {
	public DocumentSearchResult(List<Document> documents, String nextPage, String previousPage) {
		super();
		this.documents = documents;
		this.setNextPage(nextPage);
		this.setPreviousPage(previousPage);
	}

	private List<Document> documents;
	private String nextPage;
	private String previousPage;
	

	public List<Document> getDocuments() {
		return documents;
	}

	public void setDocuments(List<Document> documents) {
		this.documents = documents;
	}

	public String getPreviousPage() {
		return previousPage;
	}

	public void setPreviousPage(String previousPage) {
		this.previousPage = previousPage;
	}

	public String getNextPage() {
		return nextPage;
	}

	public void setNextPage(String nextPage) {
		this.nextPage = nextPage;
	}
	

}
