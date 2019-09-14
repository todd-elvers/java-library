package te.core.env;

import java.util.Collection;

/**
 * A {@link PropertyReader} impl. whose keys come from the system's environment variables.
 */
public class EnvironmentPropertyReader implements PropertyReader {

    @Override
    public Collection<String> getPropertyKeys() {
        return System.getenv().keySet();
    }

}