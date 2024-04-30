package com.SneakerSite.SneakerSite.Controller;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class RestApiResponse {

    private boolean success;
    private MessageApiResponse message;
    private Object data;

    public RestApiResponse() {
        super();
    }

    public RestApiResponse(boolean success, MessageApiResponse message, Object data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    private RestApiResponse(boolean success, MessageApiResponse message) {
        this.success = success;
        this.message = message;
    }

    private RestApiResponse(boolean success) {
        this.success = success;
    }

    private RestApiResponse(boolean success, Object data) {
        this.success = success;
        this.data = data;
    }

    /**
     * A static function which returns the ApiResponse JSON object and calls the private "relevant" constructor from within it. Create one when creating a new buildSuccess or buildFail if required.
     */
    public static RestApiResponse buildSuccess(Object data) {
        return new RestApiResponse(Boolean.TRUE, data);
    }

    public static RestApiResponse buildFail(MessageApiResponse message) {
        return new RestApiResponse(Boolean.FALSE, message);
    }

    public static RestApiResponse buildFail(String code, String text) {
        MessageApiResponse message = new MessageApiResponse(code, text);
        return new RestApiResponse(Boolean.FALSE, message);

    }

    public static RestApiResponse buildSuccess() {
        return new RestApiResponse(Boolean.TRUE);
    }

    public static RestApiResponse buildFail() {
        return new RestApiResponse(Boolean.FALSE);
    }

    public static RestApiResponse buildFail(Object data) {
        return new RestApiResponse(Boolean.FALSE, data);
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public MessageApiResponse getMessage() {
        return message;
    }

    public void setMessage(MessageApiResponse message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "RestApiResponse{" +
                "success=" + success +
                ", message=" + message +
                ", data=" + data +
                '}';
    }
}

