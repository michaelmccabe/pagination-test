package com.mic.document.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.mic.document.entity.Document;
import com.mic.document.entity.DocumentSearchResult;

@Service
public class DocumentService implements IDocumentService {
	
	@Override
	public DocumentSearchResult findDocuments(int page, int pageSize) {
		
		ClassLoader classLoader = getClass().getClassLoader();
		List<Document> documents =  JSONFileParser.getDocuments(new File(classLoader.getResource("DocumentsJSON.txt").getFile()));
		
		return getDocumentSearchResult(documents, page, pageSize);
	}
	
	protected DocumentSearchResult getDocumentSearchResult(List<Document> documents, int page, int pageSize) {
	
		if( pageSize<1) {
			return new DocumentSearchResult(new ArrayList<>(), "", "");
		}
		
		int totalPages = (documents.size() + pageSize - 1) / pageSize;
		int totalResults = documents.size();
		
		if(page<1 || page>totalPages || pageSize<1) {
			return new DocumentSearchResult(new ArrayList<>(), "", "");
		}

		int firstResult = 0;
		if (page >= 0 && page <= totalPages ) {
		    firstResult = (page-1) * pageSize;    
		}
		
		int count = Math.min(pageSize, totalResults - firstResult);   
		String nextPage = page < totalPages ? Integer.toString( page+1) : "";
		String previousPage = page <= 1 ? "" : Integer.toString(page-1);
		
	    ArrayList<Document> documentsForDisplay = new ArrayList<Document>(documents.subList(firstResult, firstResult+count));
		DocumentSearchResult documentSearchResult = new DocumentSearchResult(documentsForDisplay, nextPage, previousPage);
		
		return documentSearchResult;
		
		
	}
	

}
