package com.farvic.cinemaroom.errors;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class ErrorResponse {
    @JsonIgnore
    private String status;

    private String error;

    public ErrorResponse(String error) {
        this.error = error;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
