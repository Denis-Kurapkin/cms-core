package ru.prostor.cms.core.backend.model.type;

public enum IndexStatus {
    WAITING("Ожидание"),
    PAID("Оплачено"),
    RESERVED("Резерв");

    private final String ruCode;

    IndexStatus(String ruCode) {
        this.ruCode = ruCode;
    }

    public String getRuCode() {
        return ruCode;
    }
}
