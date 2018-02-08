package com.mic.document.service;

import java.util.List;

import com.mic.document.entity.Document;
import com.mic.document.entity.DocumentSearchResult;

public interface IDocumentService {

	DocumentSearchResult findDocuments(int page, int pageSize);
	
}
