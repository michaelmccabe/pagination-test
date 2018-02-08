package com.mic.document.service;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.mic.document.entity.Document;

public class JSONFileParser {

	
	static List<Document> getDocuments(File file){
		
		List<Document> documents = new ArrayList<>();
        JSONParser parser = new JSONParser();

        try {
        	  	        	
            Object obj = parser.parse(new FileReader(file));
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray resultList = (JSONArray) jsonObject.get("results");
            for (int i = 0; i < resultList.size(); i++) {
                JSONObject jsonobject = (JSONObject) resultList.get(i);
                String href = (String) jsonobject.get("href");
                String title = (String) jsonobject.get("title");
                String summary = (String) jsonobject.get("summary");
                System.out.println("href: " + href + " " + " title: " + title +" summary: " + summary );
                Document document = new Document(href, title, summary);
                documents.add(document);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }		
		
		return documents;
	}

}
