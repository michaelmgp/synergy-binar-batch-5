package com.example.challenge_5.utils;

public class MessageResponse {
    private final String succesSave = "SuccesFully Saved" ;

    private final String succesUpdate = "SuccesFully Updated";
    private final String succesDelete = "SuccesFully Deleted";

    private final String cannotNull ="There is one or more field is Empty";

    private String message;

    public String getSuccesSave() {
        return succesSave;
    }

    public String getSuccesUpdate() {
        return succesUpdate;
    }

    public String getSuccesDelete() {
        return succesDelete;
    }

    public String getCannotNull() {
        return cannotNull;
    }

    public String getErrorNotFound(Object t) {
        return  "Error File With id {" + t +"} Didn'tExist" ;
    }

    public String getMessage() {
        return message;
    }

    public MessageResponse(String message) {
        this.message = message;
    }

    public MessageResponse() {
    }

}
