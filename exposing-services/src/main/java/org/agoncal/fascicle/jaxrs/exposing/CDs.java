package org.agoncal.fascicle.jaxrs.exposing;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlSeeAlso;
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
