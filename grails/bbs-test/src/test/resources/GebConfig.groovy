import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.htmlunit.HtmlUnitDriver
import org.openqa.selenium.ie.InternetExplorerDriver
import org.openqa.selenium.remote.DesiredCapabilities

waiting {
    timeout = 2
    retryInterval = 0.5
}

// default driver
driver = { new HtmlUnitDriver() }

environments {
    // run via "gradle testIe"
    ie {
        def ieDriverPath = 'src/test/resources/driver/ie/x64/IEDriverServer.exe'
        System.setProperty('webdriver.ie.driver', ieDriverPath)
        driver = {
            def ieCapabilities = DesiredCapabilities.internetExplorer()
            ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true)
            new InternetExplorerDriver(ieCapabilities)
        }
    }

    // run via "gradle testFirefox"
    firefox {
        def firefoxPath = 'D:/Program Files (x86)/Mozilla Firefox/firefox.exe'
        System.setProperty('webdriver.firefox.bin', firefoxPath)
        driver = { new FirefoxDriver() }
    }
}
