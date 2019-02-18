package netflixTests;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/netflixTests"},
        plugin = {"pretty"},
        tags = {"@testNetflixPublicArea"})


public class NetflixCucumberRunner {
}
