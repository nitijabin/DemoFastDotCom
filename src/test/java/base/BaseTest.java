package base;

import com.fastautomaton.core.DriverManager;
import com.fastautomaton.model.EnvironmentConfig;
import com.fastautomaton.utils.YamlReader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {
    protected WebDriver webDriver;
    protected EnvironmentConfig environmentConfig;

    @BeforeClass(alwaysRun = true)
    //@Parameters("env")
    public void setup(){
        String env = System.getProperty("env", "qa");
        environmentConfig = YamlReader.loadEnvironment(env);
        DriverManager driverManager = new DriverManager(environmentConfig.getBrowser());
        webDriver = driverManager.createDriver();
        webDriver.get(environmentConfig.getBaseUrl());
    }

    @AfterClass(alwaysRun = true)
    public void tearDown(){
      //  if(webDriver != null) webDriver.quit();
    }
}
