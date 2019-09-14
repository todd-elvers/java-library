package te.core.env

import spock.lang.Specification
import spock.lang.Subject

class OmniPropertyReaderTest extends Specification {

    @Subject
    OmniPropertyReader propertyReader = [
            Mock(EnvironmentPropertyReader) { getPropertyKeys() >> ["A"] },
            Mock(SystemPropertyReader) { getPropertyKeys() >> ["B"] },
    ]

    def "getPropertyKeys() returns flattened set of all keys from all readers"() {
        expect:
            propertyReader.getPropertyKeys() == ["A", "B"] as Set
    }

}
