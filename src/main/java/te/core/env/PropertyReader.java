package te.core.env;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * Describes an interface capable of determining, in a case-insensitive way, whether a {@link Collection} of
 * {@link String}s contains a given key or not.
 */
interface PropertyReader {

    Collection<String> getPropertyKeys();

    default boolean containsKeyIgnoringCase(String targetKey) {
        if (StringUtils.isEmpty(targetKey)) return false;

        return containsAnyKeyIgnoringCase(targetKey);
    }

    default boolean containsAnyKeyIgnoringCase(String... targetKeys) {
        if (ArrayUtils.isEmpty(targetKeys)) return false;

        return containsAnyKeyIgnoringCase(Arrays.asList(targetKeys));
    }

    default boolean containsAnyKeyIgnoringCase(List<String> targetKeys) {
        if (CollectionUtils.isEmpty(targetKeys)) return false;

        for (String key : getPropertyKeys()) {
            for (String targetKey : targetKeys) {
                if (key.equalsIgnoreCase(targetKey)) {
                    return true;
                }
            }
        }

        return false;
    }

}
