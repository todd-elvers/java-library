package te.core.env

import spock.lang.Specification
import spock.lang.Subject

class MultiPropertyReaderTest extends Specification {

    @Subject
    MultiPropertyReader propertyReader = [
            Mock(EnvironmentPropertyReader) { getPropertyKeys() >> ["A"] },
            Mock(SystemPropertyReader) { getPropertyKeys() >> ["B"] },
    ]

    def "getPropertyKeys() returns flattened set of all keys from all readers"() {
        expect:
            propertyReader.getPropertyKeys() == ["A", "B"] as Set
    }

    def "factory method build the correct instance"() {
        when:
            MultiPropertyReader propertyReader = MultiPropertyReader.forEnvAndSysReading()

        then:
            propertyReader.propertyReaders
            propertyReader.propertyReaders.size() == 2
            propertyReader.propertyReaders.any { it instanceof EnvironmentPropertyReader }
            propertyReader.propertyReaders.any { it instanceof SystemPropertyReader }
    }
}
