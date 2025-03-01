package br.edu.ifpb.enums;

public enum DoctorAvailabilityStatus {
    AVAILABLE("Available"),
    UNAVAILABLE("Unavailable"),
    ON_LEAVE("On Leave"),
    IN_CONSULTATION("In Consultation");

    private final String status;

    DoctorAvailabilityStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
