package te.core.env;

import java.util.HashSet;
import java.util.Set;

/**
 * A {@link PropertyReader} impl. whose keys come from an array of underlying {@link PropertyReader}s.
 * <p>
 * The no-arg constructor of this class returns an instance configured with {@link EnvironmentPropertyReader}
 * and {@link SystemPropertyReader}.
 */
public class OmniPropertyReader implements PropertyReader {

    private final PropertyReader[] propertyReaders;

    public OmniPropertyReader() {
        this.propertyReaders = new PropertyReader[]{
            new EnvironmentPropertyReader(),
            new SystemPropertyReader()
        };
    }

    public OmniPropertyReader(PropertyReader... propertyReaders) {
        this.propertyReaders = propertyReaders;
    }

    @Override
    public Set<String> getPropertyKeys() {
        HashSet<String> allPropertyKeys = new HashSet<>();
        for (PropertyReader propertyReader : propertyReaders) {
            allPropertyKeys.addAll(propertyReader.getPropertyKeys());
        }

        return allPropertyKeys;
    }

}
