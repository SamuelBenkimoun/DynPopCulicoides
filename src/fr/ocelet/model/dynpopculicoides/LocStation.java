package fr.ocelet.model.dynpopculicoides;

import fr.ocelet.runtime.entity.AbstractEntity;
import fr.ocelet.runtime.entity.Hproperty;
import fr.ocelet.runtime.geom.ocltypes.Point;

@SuppressWarnings("all")
public class LocStation extends AbstractEntity {
  public void setName(final String name) {
    setProperty("name",name);
  }
  
  public String getName() {
    return getProperty("name");
  }
  
  public void setId(final Integer id) {
    setProperty("id",id);
  }
  
  public Integer getId() {
    return getProperty("id");
  }
  
  public void setNumero(final Long numero) {
    setProperty("numero",numero);
  }
  
  public Long getNumero() {
    return getProperty("numero");
  }
  
  public void setGeom(final Point geom) {
    setProperty("geom",geom);
  }
  
  public Point getGeom() {
    return getProperty("geom");
  }
  
  public void setAltitude(final Integer altitude) {
    setProperty("altitude",altitude);
  }
  
  public Integer getAltitude() {
    return getProperty("altitude");
  }
  
  public LocStation() {
    super();
    defProperty("name",new Hproperty<String>());
    setName(new String());
    defProperty("id",new Hproperty<Integer>());
    setId(new Integer("0"));
    defProperty("numero",new Hproperty<Long>());
    setNumero(new Long("0"));
    defProperty("geom",new Hproperty<Point>());
    setGeom(new Point());
    defProperty("altitude",new Hproperty<Integer>());
    setAltitude(new Integer("0"));
  }
}
