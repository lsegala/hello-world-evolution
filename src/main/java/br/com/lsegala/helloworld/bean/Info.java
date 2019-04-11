package br.com.lsegala.helloworld.bean;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement
public class Info implements Serializable {
    public String message;
}
