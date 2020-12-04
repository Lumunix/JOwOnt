package com.github.lumunix.jowont;


import com.github.lumunix.jowont.models.JUnitTestSuite;
import org.junit.jupiter.api.Test;

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
    private static final String goodJunitFileWithFailures = "junitExamples/goodJunitFileWithFailures.xml";

    @Test
    public void parseJunitFile() throws IOException, JAXBException, XMLStreamException {
        final InputStream inputXml =
                getClass().getClassLoader().getResourceAsStream(goodJunitFileAllPass);
        final InputStream inputXml2 =
                getClass().getClassLoader().getResourceAsStream(goodJunitFileWithFailures);

        JUnitTestSuite testSuite = JOwOnt.parseJunitFile(inputXml);
        JUnitTestSuite testSuite2 = JOwOnt.parseJunitFile(inputXml2);
        assertNotNull(testSuite);
        assertNotNull(testSuite2);

    }

    @Test
    public void parseJunitFile_testBadXmlFile(){
        final InputStream inputXml =
                getClass().getClassLoader().getResourceAsStream(badFile);

        assertThrows(UnmarshalException.class, () -> {
            JOwOnt.parseJunitFile(inputXml);
        });

    }

    @Test
    public void createEscapedJUnitInputStream(){
        final InputStream inputXml =
                getClass().getClassLoader().getResourceAsStream(goodJunitFileAllPass);


        assertNotNull(inputXml);
    }

}
