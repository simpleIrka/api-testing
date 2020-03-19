package entity;

import com.google.gson.annotations.SerializedName;

public class ErrorRS
{
    @SerializedName("documentation_url")
    private String documentationUrl;
    private String message;

    public String getDocumentationUrl() {
        return documentationUrl;
    }

    public void setDocumentationUrl(String documentationUrl) {
        this.documentationUrl = documentationUrl;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
