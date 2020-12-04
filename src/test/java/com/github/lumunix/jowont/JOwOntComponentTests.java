package com.github.lumunix.jowont;


import com.github.lumunix.jowont.models.JUnitTestSuite;
import org.junit.jupiter.api.Test;

import javax.xml.bind.JAXBException;
import javax.xml.bind.UnmarshalException;
import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertThrows;


public class JOwOntComponentTests {
    private static String badFile = "junitExamples/badFile.xml";

    private static String junitFile1 = "junitExamples/TEST-com.github.lumunix.electriceye.client.ElectricEyeAnnotationProcessorTests.xml";
    private static String junitFile2 = "junitExamples/TEST-com.github.lumunix.electriceye.client.ElectricEyeApiComponentTests.xml";
    private static String junitFile3 = "junitExamples/TEST-com.github.lumunix.electriceye.client.ElectricEyeConfigTests.xml";
    private static String junitFile4 = "junitExamples/TEST-com.github.lumunix.electriceye.client.ElectricEyeFunctionalTest.xml";
    private static String junitFile5 = "junitExamples/TEST-com.github.lumunix.electriceye.client.ElectricEyeGradlePluginComponentTests.xml";
    private static String junitFile6 = "junitExamples/TEST-com.github.lumunix.electriceye.client.ElectricEyeZipUtilsComponentTests.xml";

    @Test
    public void unmarshalTestSuite() throws IOException, JAXBException, XMLStreamException {
        final InputStream inputXml =
                getClass().getClassLoader().getResourceAsStream(junitFile1);
        final InputStream inputXml2 =
                getClass().getClassLoader().getResourceAsStream(junitFile2);
        JUnitTestSuite testSuite = JOwOnt.unmarshalTestSuite(inputXml);
        JUnitTestSuite testSuite2 = JOwOnt.unmarshalTestSuite(inputXml2);


        System.out.println(testSuite.getName());
        System.out.println(testSuite.getName());


    }

    @Test
    public void unmarshalTestSuite_testBadXmlFile(){
        final InputStream inputXml =
                getClass().getClassLoader().getResourceAsStream(badFile);
        assertThrows(UnmarshalException.class, () -> {
            JOwOnt.unmarshalTestSuite(inputXml);
        });

    }

    @Test
    public void createEscapedJUnitInputStream(){
        final InputStream inputXml =
                getClass().getClassLoader().getResourceAsStream(badFile);
        assertThrows(UnmarshalException.class, () -> {
            JOwOnt.unmarshalTestSuite(inputXml);
        });

    }
}
