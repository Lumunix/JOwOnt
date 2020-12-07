package com.github.lumunix.jowont;


import com.github.lumunix.jowont.models.JUnitTestSuite;
import com.github.lumunix.jowont.models.JUnitTestSuites;
import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import javax.xml.bind.UnmarshalException;
import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class JOwOntComponentTests {
    private static final String badFile = "junitExamples/badFile.xml";
    private static final String goodJunitFileAllPass = "junitExamples/goodJunitFileAllPass.xml";
    private static final String goodJunitFileWithMultipleTestsuite = "junitExamples/goodJunitFileMultipleTestsuite.xml";
    private static final String goodJunitFileWithFailures = "junitExamples/goodJunitFileWithFailures.xml";

    @Test
    public void parseJunitFile() throws IOException, JAXBException, XMLStreamException, SAXException {
        final InputStream inputXml =
                getClass().getClassLoader().getResourceAsStream(goodJunitFileAllPass);

        Object obj = JOwOnt.parseJunitXml(inputXml);
        assertNotNull(obj);

    }

    @Test
    public void parseJunitFile_testBadXmlFile(){
        final InputStream inputXml =
                getClass().getClassLoader().getResourceAsStream(badFile);
        assertThrows(UnmarshalException.class, () -> {
            JOwOnt.parseJunitXml(inputXml);
        });

    }

    @Test
    public void createEscapedJUnitInputStream(){
        final InputStream inputXml =
                getClass().getClassLoader().getResourceAsStream(goodJunitFileAllPass);
        
        assertNotNull(inputXml);
    }

}
