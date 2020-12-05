package com.github.lumunix.jowont.models;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

@Getter
@Setter
@Accessors(chain = true)
public class JUnitTestCase {

    @XmlElement
    private JUnitSkipped skipped;

    @XmlElement(name = "error")
    private List<JUnitError> errors;

    @XmlElement(name = "failure")
    private List<JUnitFailure> failures;

    @XmlElement(name = "system-out")
    private String systemOut;

    @XmlElement(name = "system-err")
    private String systemErr;

    @XmlAttribute(required = true)
    private String name;

    @XmlAttribute
    private int assertions;

    @XmlAttribute
    private Double time;

    @XmlAttribute(name = "classname", required = true)
    private String className;

    @XmlAttribute
    private String status;


    @Override
    public String toString() {
        return ReflectionToStringBuilder.toStringExclude(this, "systemOut", "systemErr");
    }
}
