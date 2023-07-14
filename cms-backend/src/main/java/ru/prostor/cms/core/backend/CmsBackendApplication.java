package ru.prostor.cms.core.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import ru.prostor.cms.core.backend.config.property.ImgStorageProperty;

@SpringBootApplication(
        scanBasePackages = {
                "ru.prostor.cms.core.backend"
        }
)
@ConfigurationPropertiesScan(
        basePackages = {
                "ru.prostor.cms.core.backend.config"
        }
)
@EnableConfigurationProperties({
        ImgStorageProperty.class
})
public class CmsBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(CmsBackendApplication.class, args);
    }

}
