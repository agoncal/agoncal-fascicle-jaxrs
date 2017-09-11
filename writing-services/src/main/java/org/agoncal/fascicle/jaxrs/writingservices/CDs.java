package org.agoncal.fascicle.jaxrs.writingservices;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Antonio Goncalves
 *         http://www.antoniogoncalves.org
 *         --
 */
@XmlRootElement
@XmlSeeAlso(CD.class)
public class CDs extends ArrayList<CD> {

  // ======================================
  // =          Getters & Setters         =
  // ======================================

  @XmlElement(name = "cd")
  public List<CD> getCDs() {
    return this;
  }
}
