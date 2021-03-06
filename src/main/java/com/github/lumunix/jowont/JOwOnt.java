package com.github.lumunix.jowont;

import com.github.lumunix.jowont.models.JUnitTestSuite;
import com.github.lumunix.jowont.models.JUnitTestSuites;
import org.apache.commons.io.IOUtils;
import org.apache.commons.text.StringEscapeUtils;
import org.xml.sax.SAXException;



import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

public class JOwOnt {
    private static final String systemOutStart = "<system-out>";
    private static final String systemOutEnd = "</system-out>";
    private static final String systemErrStart = "<system-err>";
    private static final String systemErrEnd = "</system-err>";

    public static Object parseJunitXml(InputStream stream) throws IOException, XMLStreamException, SAXException, JAXBException {

            JAXBContext context = JAXBContext.newInstance(JUnitTestSuites.class, JUnitTestSuite.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            return unmarshaller.unmarshal(createJunitXMLStreamReader(stream));
    }

    public static XMLStreamReader createJunitXMLStreamReader(InputStream stream) throws XMLStreamException, IOException {

        XMLInputFactory xif = XMLInputFactory.newFactory();
        XMLStreamReader xsr = xif.createXMLStreamReader(createEscapedJUnitInputStream(stream));
        xsr = xif.createFilteredReader(xsr, reader -> {
            if (reader.getEventType() == XMLStreamReader.CHARACTERS) {
                return reader.getText().trim().length() > 0;
            }
            return true;
        });
        return xsr;
    }

    public static InputStream createEscapedJUnitInputStream(InputStream stream) throws IOException {
        try (stream) {
            String contents = IOUtils.toString(stream, Charset.defaultCharset());

            int systemOutStartIndex = contents.indexOf(systemOutStart);
            int systemOutEndIndex = contents.indexOf(systemOutEnd);
            if (systemOutStartIndex > 0 && systemOutEndIndex > 0) {
                systemOutStartIndex += systemOutStart.length();
                contents = contents.substring(0, systemOutStartIndex) +
                        StringEscapeUtils.escapeXml10(contents.substring(systemOutStartIndex, systemOutEndIndex)) +
                        contents.substring(systemOutEndIndex);
            }

            int systemErrStartIndex = contents.indexOf(systemErrStart);
            int systemErrEndIndex = contents.indexOf(systemErrEnd);
            if (systemErrStartIndex > 0 && systemErrEndIndex > 0) {
                systemErrStartIndex += systemErrStart.length();
                contents = contents.substring(0, systemErrStartIndex) +
                        StringEscapeUtils.escapeXml10(contents.substring(systemErrStartIndex, systemErrEndIndex)) +
                        contents.substring(systemErrEndIndex);
            }

            return new ByteArrayInputStream(contents.getBytes());
        }
    }
}