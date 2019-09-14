package te.core.env;

import java.util.Collection;

/**
 * A {@link PropertyReader} impl. whose keys come from the system's properties.
 */
public class SystemPropertyReader implements PropertyReader {

    @Override
    public Collection<String> getPropertyKeys() {
        return System.getProperties().stringPropertyNames();
    }

}
