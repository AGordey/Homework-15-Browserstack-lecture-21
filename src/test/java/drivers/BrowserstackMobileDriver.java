package drivers;

import com.codeborne.selenide.WebDriverProvider;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import tests.config.BrowserstackConfig;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackMobileDriver implements WebDriverProvider {

    BrowserstackConfig config = ConfigFactory
            .create(BrowserstackConfig.class, System.getProperties());
    @Override

    public WebDriver createDriver(Capabilities capabilities) {
        MutableCapabilities mutableCapabilities = new MutableCapabilities();
        mutableCapabilities.merge(capabilities);
        // Set your access credentials
        mutableCapabilities.setCapability("browserstack.user", config.username());
        mutableCapabilities.setCapability("browserstack.key", config.key());

        // Set URL of the application under test
        mutableCapabilities.setCapability("app", config.appinbrowserstack());
        // Specify device and os_version for testing
        mutableCapabilities.setCapability("device", config.deviceinbrowserstack());
        mutableCapabilities.setCapability("os_version", config.os_versioninbrowserstack());

        // Set other BrowserStack capabilities
        mutableCapabilities.setCapability("project", config.projectinbrowserstack());
        mutableCapabilities.setCapability("build", config.buildinbrowserstack());
        mutableCapabilities.setCapability("name", config.nameinbrowserstack());
        return new RemoteWebDriver(getBrowserstackUrl(), mutableCapabilities);
    }

    public static URL getBrowserstackUrl() {
        try {
            return new URL("http://hub.browserstack.com/wd/hub");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
