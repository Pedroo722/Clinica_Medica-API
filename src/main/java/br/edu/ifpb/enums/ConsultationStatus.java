package br.edu.ifpb.enums;

public enum ConsultationStatus {
    SCHEDULED("Scheduled"),
    COMPLETED("Completed"),
    CANCELED("Canceled");

    private final String status;

    ConsultationStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
