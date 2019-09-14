package te.core.env;

import java.util.Set;

/**
 * A {@link PropertyReader} impl. whose keys come from the system's properties.
 */
public class SystemPropertyReader implements PropertyReader {

    @Override
    public Set<String> getPropertyKeys() {
        return System.getProperties().stringPropertyNames();
    }

}
