package ApiTests;

import Properties.SetProperties;
import org.junit.Before;

public abstract class BasePage implements Base {

    @Before
    @Override
    public void setProperties() throws Exception {

        SetProperties.SetValueProperties();

    }
}
