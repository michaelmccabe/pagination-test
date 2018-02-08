package com.mic.document;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mic.document.entity.DocumentSearchResult;
import com.mic.document.service.IDocumentService;

@RestController
@RequestMapping(value = "/documents", produces = "application/hal+json")		
public class DocumentController {
	

	
    @Autowired
    IDocumentService documentService;
	
    @GetMapping
    public ResponseEntity<DocumentSearchResult> getPaginatedDocuments(@RequestParam (value ="page", defaultValue="1") int page, @RequestParam (value ="pageSize", defaultValue="20") int pageSize) {

    	
    		DocumentSearchResult searchResults = documentService.findDocuments(page, pageSize);
      

      return ResponseEntity.ok(searchResults);
    }



}
