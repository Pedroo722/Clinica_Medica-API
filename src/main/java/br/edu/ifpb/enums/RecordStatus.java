package br.edu.ifpb.enums;

public enum RecordStatus {
    ACTIVE("Active"),
    INACTIVE("Inactive"),
    UNDER_TREATMENT("Under Treatment"),
    RECOVERED("Recovered"),
    DISCHARGED("Discharged");

    private final String status;

    RecordStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
