package com.documents.model;

import lombok.Data;

@Data
public class DocumentDetailsDTO  {
    private String Name;
    private int Cost;

    public DocumentDetailsDTO() {
    }

    public DocumentDetailsDTO(String documentName, int documentCost) {
        this.Name = documentName;
        this.Cost = documentCost;
    }
}
