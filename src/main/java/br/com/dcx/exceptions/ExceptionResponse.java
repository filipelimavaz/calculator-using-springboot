package br.com.dcx.exceptions;

import java.io.Serializable;
import java.util.Date;

public class ExceptionResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    private Date timestamp;
    private String messagem;
    private String detalhes;

    public ExceptionResponse(Date timestamp, String message, String details) {
        this.timestamp = timestamp;
        this.messagem = message;
        this.detalhes = details;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return messagem;
    }

    public String getDetails() {
        return detalhes;
    }
}