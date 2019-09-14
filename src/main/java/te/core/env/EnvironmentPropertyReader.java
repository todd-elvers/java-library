package te.core.env;

import java.util.Set;

/**
 * A {@link PropertyReader} impl. whose keys come from the system's environment variables.
 */
public class EnvironmentPropertyReader implements PropertyReader {

    @Override
    public Set<String> getPropertyKeys() {
        return System.getenv().keySet();
    }

}