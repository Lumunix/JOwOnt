package com.github.lumunix.jowont.models;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;

@Getter
@Setter
@Accessors(chain = true)
public class JUnitError {

    @XmlAttribute
    private String type;


    @XmlAttribute
    private String message;


    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
