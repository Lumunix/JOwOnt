

```java
import com.github.lumunix.jowont.JOwOnt;
import com.github.lumunix.jowont.models.JUnitTestSuite;
import org.xml.sax.SAXException;
import javax.xml.bind.JAXBException;
import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.io.InputStream;


public class sample {

    static InputStream inputStream = sample.class.getClassLoader().getResourceAsStream("junit.xml");

    public static void main(String[] args) throws IOException, SAXException, XMLStreamException, JAXBException {

        Object parsedXML = JOwOnt.parseJunitXml(inputStream);

        JUnitTestSuite marshalledTestSuite = (JUnitTestSuite)parsedXML;

    }
}

```