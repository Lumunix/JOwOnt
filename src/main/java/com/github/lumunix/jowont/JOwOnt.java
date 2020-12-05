package com.github.lumunix.jowont;

import com.github.lumunix.jowont.models.JUnitTestSuite;
import com.github.lumunix.jowont.models.JUnitTestSuites;
import org.apache.commons.io.IOUtils;
import org.apache.commons.text.StringEscapeUtils;
import org.xml.sax.SAXException;


import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

public class JOwOnt {
    private static final String systemOutStart = "<system-out>";
    private static final String systemOutEnd = "</system-out>";
    private static final String systemErrStart = "<system-err>";
    private static final String systemErrEnd = "</system-err>";
    private static final File jUnitXSDSchemaFile = new File("src/main/resources/junit.xsd");

    public static Object parseJunitXml(InputStream stream){
        try {
            JAXBContext context = JAXBContext.newInstance(JUnitTestSuites.class, JUnitTestSuite.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();

            //Setup schema validator
            SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema junitSchema = sf.newSchema(jUnitXSDSchemaFile);
            unmarshaller.setSchema(junitSchema);

            return unmarshaller.unmarshal(createJunitXMLStreamReader(stream));
        }
        catch(XMLStreamException|IOException|JAXBException|SAXException e){
           throw new RuntimeException(e);
        }
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