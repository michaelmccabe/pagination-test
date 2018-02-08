package com.mic.document.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.mic.document.entity.Document;
import com.mic.document.entity.DocumentSearchResult;

public class DocumentServiceTest {
	
	DocumentService underTest = new DocumentService();
	
	List<Document> documents = new ArrayList<>();
	
	@Before
	public void setup() {
		
		documents.add(new Document("href", "title1", "summary"));
		documents.add(new Document("href", "title2", "summary"));
		documents.add(new Document("href", "title3", "summary"));
		documents.add(new Document("href", "title4", "summary"));
		documents.add(new Document("href", "title5", "summary"));
		documents.add(new Document("href", "title6", "summary"));
		documents.add(new Document("href", "title7", "summary"));
		documents.add(new Document("href", "title8", "summary"));
		documents.add(new Document("href", "title9", "summary"));
		documents.add(new Document("href", "title10", "summary"));
		documents.add(new Document("href", "title11", "summary"));
		documents.add(new Document("href", "title12", "summary"));
		documents.add(new Document("href", "title13", "summary"));
	}
	
	@Test
	public void testPageOutOfRangeReturnsNoEntries() throws Exception {
		
		DocumentSearchResult documentSearchResult = underTest.getDocumentSearchResult(documents, 0, 10);
		
		assertEquals("", documentSearchResult.getNextPage());
		assertEquals("", documentSearchResult.getPreviousPage());
		assertEquals(0, documentSearchResult.getDocuments().size());
		
		documentSearchResult = underTest.getDocumentSearchResult(documents, 30, 10);
		
		assertEquals("", documentSearchResult.getNextPage());
		assertEquals("", documentSearchResult.getPreviousPage());
		assertEquals(0, documentSearchResult.getDocuments().size());
		
		
	}
	
	@Test
	public void testPageSizeGreaterThanTotalReturnsFullList() throws Exception {
		DocumentSearchResult documentSearchResult = underTest.getDocumentSearchResult(documents, 1, 20);
		assertEquals("", documentSearchResult.getNextPage());
		assertEquals("", documentSearchResult.getPreviousPage());
		assertEquals(13, documentSearchResult.getDocuments().size());
	}
	
	@Test
	public void testPageSizeAndPageNumberReturnsCorectEntries() throws Exception {
		DocumentSearchResult documentSearchResult = underTest.getDocumentSearchResult(documents, 2, 5);
		
		assertEquals("3", documentSearchResult.getNextPage());
		assertEquals("1", documentSearchResult.getPreviousPage());
		assertEquals(5, documentSearchResult.getDocuments().size());		
		assertEquals("title6", documentSearchResult.getDocuments().get(0).getTitle());
		
		documentSearchResult = underTest.getDocumentSearchResult(documents, 3, 4);
		
		assertEquals("4", documentSearchResult.getNextPage());
		assertEquals("2", documentSearchResult.getPreviousPage());
		assertEquals(4, documentSearchResult.getDocuments().size());		
		assertEquals("title9", documentSearchResult.getDocuments().get(0).getTitle());	
		
		documentSearchResult = underTest.getDocumentSearchResult(documents, 5, 3);
		
		assertEquals("", documentSearchResult.getNextPage());
		assertEquals("4", documentSearchResult.getPreviousPage());
		assertEquals(1, documentSearchResult.getDocuments().size());			
	}

}
