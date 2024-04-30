package com.SneakerSite.SneakerSite.Controller;


import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class MessageApiResponse {

    private String code;
    private String text;

    public MessageApiResponse(String code, String text) {
        this.code = code;
        this.text = text;
    }

    public MessageApiResponse(String text) {
        this.text = text;
    }

    public MessageApiResponse() {
    }

    /**
     * Static builder for building the MessageApiResponse.
     */
    public static MessageApiResponse build(String code, String text) {
        MessageApiResponse messageApiResponse = new MessageApiResponse(code, text);
        return messageApiResponse;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

