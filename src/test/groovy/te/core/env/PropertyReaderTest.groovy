package te.core.env

import spock.lang.Specification
import spock.lang.Subject

class PropertyReaderTest extends Specification {

    @Subject
    PropertyReader propertyReader = new PropertyReader() {

        @Override
        Set<String> getPropertyKeys() {
            return ['someKey1' ,'someKey2']
        }

    }

    def "can determine if a property is set, regardless of case"() {
        expect: 'bogus input to be handled correctly'
            !propertyReader.containsKeyIgnoringCase(null)
            !propertyReader.containsKeyIgnoringCase('')
            !propertyReader.containsKeyIgnoringCase('someKe')

        and:
            propertyReader.containsKeyIgnoringCase('someKey1')
            propertyReader.containsKeyIgnoringCase('somekey1')
            propertyReader.containsKeyIgnoringCase('someKEY1')
            propertyReader.containsKeyIgnoringCase('SOMEKEY1')

        and: 'we return false if the keys do not match exactly (ignoring case)'
            !propertyReader.containsKeyIgnoringCase('someKey11')
    }

    def "can determine if any properties from a list are set, regardless of case"() {
        expect: 'bogus input to be handled correctly'
            !propertyReader.containsAnyKeyIgnoringCase(null)
            !propertyReader.containsAnyKeyIgnoringCase([])
            !propertyReader.containsAnyKeyIgnoringCase([null])

        and: 'the varargs version works correctly'
            propertyReader.containsAnyKeyIgnoringCase('someKey0', 'someKey1')
            propertyReader.containsAnyKeyIgnoringCase(null, 'someKey1')
            propertyReader.containsAnyKeyIgnoringCase('', 'SomeKey1')
            propertyReader.containsAnyKeyIgnoringCase('someKey-1', 'someKey0', 'someKey1')

        and: 'the list version works correctly'
            propertyReader.containsAnyKeyIgnoringCase(['someKey0', 'SOMEKEY1'])
            propertyReader.containsAnyKeyIgnoringCase([null, 'somekey1'])
            propertyReader.containsAnyKeyIgnoringCase(['', 'SomeKey1'])
            propertyReader.containsAnyKeyIgnoringCase(['someKey-1', 'someKey0', 'someKey1'])
    }

}
