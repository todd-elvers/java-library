package te.core.env;

import java.util.HashSet;
import java.util.Set;
import org.apache.commons.collections4.CollectionUtils;

/**
 * A {@link PropertyReader} impl. whose keys come from an array of underlying {@link PropertyReader}s.
 */
public class MultiPropertyReader implements PropertyReader {

    private final PropertyReader[] propertyReaders;

    /**
     * @return an impl. of {@link PropertyReader} that reads from environment variables and system properties.
     */
    public static MultiPropertyReader forEnvAndSysReading() {
        return new MultiPropertyReader(
            new EnvironmentPropertyReader(),
            new SystemPropertyReader()
        );
    }

    public MultiPropertyReader(PropertyReader... propertyReaders) {
        this.propertyReaders = propertyReaders;
    }

    @Override
    public Set<String> getPropertyKeys() {
        HashSet<String> allKeys = new HashSet<>();
        for (PropertyReader propertyReader : propertyReaders) {
            CollectionUtils.addAll(allKeys, propertyReader.getPropertyKeys());
        }

        return allKeys;
    }

}
