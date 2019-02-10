package org.agoncal.fascicle.jaxrs.exposing;

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
@XmlSeeAlso(Item.class)
public class Items extends ArrayList<Item> {

  // ======================================
  // =          Getters & Setters         =
  // ======================================

  @XmlElement(name = "item")
  public List<Item> getItems() {
    return this;
  }
}
