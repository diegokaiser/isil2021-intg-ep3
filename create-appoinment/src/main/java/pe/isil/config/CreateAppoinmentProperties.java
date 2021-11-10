package pe.isil.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "app.queue")
public class CreateAppoinmentProperties {

    private String createAppoinmentQueue;

    public String getCreateAppoinmentQueue() {
        return createAppoinmentQueue;
    }

    public void setCreateAppoinmentQueue(String createAppoinmentQueue) {
        this.createAppoinmentQueue = createAppoinmentQueue;
    }
}
