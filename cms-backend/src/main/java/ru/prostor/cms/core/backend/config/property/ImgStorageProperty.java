package ru.prostor.cms.core.backend.config.property;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "application.img-storage")
public class ImgStorageProperty {
    private final String url;

    public ImgStorageProperty(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
