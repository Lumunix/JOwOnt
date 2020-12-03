package com.github.lumunix.jowont;


import com.github.lumunix.jowont.models.JUnitTestSuite;
import org.junit.jupiter.api.Test;

import javax.xml.bind.JAXBException;
import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.io.InputStream;


public class JOwOntComponentTests {

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
        JUnitTestSuite testSuite = JOwOnt.unmarshalTestSuite(inputXml);
        System.out.println(testSuite.getName());
        System.out.println(testSuite.getName());



    }
}
