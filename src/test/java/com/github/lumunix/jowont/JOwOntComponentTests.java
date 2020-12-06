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
        final InputStream inputXml2 =
                getClass().getClassLoader().getResourceAsStream(goodJunitFileWithFailures);

        Object obj = JOwOnt.parseJunitXml(inputXml);


        JUnitTestSuites parsedTestSuites;

        if(obj instanceof JUnitTestSuites)
            parsedTestSuites = (JUnitTestSuites) obj;





       // JUnitTestSuite testSuite2 = JOwOnt.parseJunitFile(inputXml2);
       // assertNotNull(testSuite);
       // assertNotNull(testSuite2);

    }

    @Test
    public void parseJunitFile_testBadXmlFile() throws SAXException, XMLStreamException, JAXBException, IOException {
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


    @Test
    public void experimental() throws IOException, JAXBException, XMLStreamException, SAXException {
        final InputStream inputXml =
                getClass().getClassLoader().getResourceAsStream(goodJunitFileWithMultipleTestsuite);
        final InputStream inputXml2 =
                getClass().getClassLoader().getResourceAsStream(goodJunitFileWithFailures);

        Object testSuite = JOwOnt.parseJunitXml(inputXml);
        Object testSuite2 = JOwOnt.parseJunitXml(inputXml2);


        assertNotNull(testSuite);


    }

}
