package org.agoncal.fascicle.jaxrs.integrating.beanvalidation;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.sql.SQLException;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
public abstract class AbstractPersistentTest {

  // ======================================
  // =             Attributes             =
  // ======================================

  protected EntityManagerFactory emf = Persistence.createEntityManagerFactory("cdbookstorePU");
  protected EntityManager em;
  protected EntityTransaction tx;

  // ======================================
  // =          Lifecycle Methods         =
  // ======================================

  @BeforeEach
  public void initEntityManager() throws Exception {
    em = emf.createEntityManager();
    tx = em.getTransaction();
  }

  @AfterEach
  public void closeEntityManager() throws SQLException {
    if (em != null) em.close();
  }
}
