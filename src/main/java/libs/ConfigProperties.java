package libs;

import org.aeonbits.owner.Config;

@Config.Sources(value = "file:./src/main/java/resources/config.properties")
public interface ConfigProperties extends Config {
    long TIME_FOR_DEFAULT_WAIT();
    long TIME_FOR_EXPLICIT_WAIT_LOW();

    String base_url();

}
