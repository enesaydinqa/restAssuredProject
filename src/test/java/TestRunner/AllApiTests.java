package TestRunner;

import ApiTests.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        Login.class,
        Integration.class,
        Language.class,
        Reminders.class,
        Address.class
})
public class AllApiTests {
}
