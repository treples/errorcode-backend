package com.example.errorcodebackend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "Error_Codes")
public class ErrorCode {
    // @Field names are used in Compass
    @Id
    private String id;  // maps to _id automatically

    @Field("Error Code")
    private String errorCode;

    @Field("Error Title")
    private String errorTitle;

    @Field("Category")
    private String category;

    @Field("Description")
    private String description;

    @Field("Possible Cause")
    private String possibleCause;

    @Field("Possible Solutions")
    private String possibleSolutions;

    @Field("Source URL")
    private String sourceUrl;

    @Field("Debug Query")
    private String debugQuery;



    public ErrorCode() {}

    // Getters and setters…

    public String getErrorCode() { return errorCode; }
    public void setErrorCode(String errorCode) { this.errorCode = errorCode; }

    public String getErrorTitle() { return errorTitle; }
    public void setErrorTitle(String errorTitle) { this.errorTitle = errorTitle; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getPossibleCause() { return possibleCause; }
    public void setPossibleCause(String possibleCause) { this.possibleCause = possibleCause; }

    public String getPossibleSolutions() { return possibleSolutions; }
    public void setPossibleSolutions(String possibleSolutions) { this.possibleSolutions = possibleSolutions; }
    
    public String getSourceUrl() { return sourceUrl; }
    public void setSourceUrl(String sourceUrl) { this.sourceUrl = sourceUrl; }
    
    public String getDebugQuery() { return debugQuery; }
    public void setDebugQuery(String debugQuery) { this.debugQuery = debugQuery; }

}