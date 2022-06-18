package tests.config;

import org.aeonbits.owner.Config;
@Config.Sources ({
      // "system:properties",
        "classpath:BrowserStack.properties"
})
public interface BrowserstackConfig extends Config {

    @Key("username")
    @DefaultValue("testingtest_C1KlNE")
    String username();

    @Key("key")
    @DefaultValue("sAq7zr5P82sMBqVyxemW")
    String key();

    @Key("appinbrowserstack")
    @DefaultValue("bs://c700ce60cf13ae8ed97705a55b8e022f13c5827c")
    String appinbrowserstack();

    @Key("deviceinbrowserstack")
    @DefaultValue("Google Pixel 3")
    String deviceinbrowserstack();

    @Key("os_versioninbrowserstack")
    @DefaultValue("9.0")
    String os_versioninbrowserstack();

    @Key("projectinbrowserstack")
    @DefaultValue("QA.GURU lesson 21 Andrey G")
    String projectinbrowserstack();

    @Key("buildinbrowserstack")
    @DefaultValue("browserstack-build-1")
    String buildinbrowserstack();

    @Key("nameinbrowserstack")
    @DefaultValue("selenide android test")
    String nameinbrowserstack();
}
