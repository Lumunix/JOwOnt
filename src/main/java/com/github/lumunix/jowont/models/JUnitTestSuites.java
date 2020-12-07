package com.github.lumunix.jowont.models;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;


@Getter
@Setter
@Accessors(chain = true)
@XmlRootElement(name = "testsuites")
public class JUnitTestSuites {

    @XmlElement(name = "testsuite")
    private List<JUnitTestSuite> testSuites;

    @XmlAttribute
    private String name;

    @XmlAttribute
    private double time;

    @XmlAttribute
    private int tests;

    @XmlAttribute
    private int failures;

    @XmlAttribute
    private boolean disabled;

    @XmlAttribute
    private int errors;

}
