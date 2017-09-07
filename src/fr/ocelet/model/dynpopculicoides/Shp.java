package fr.ocelet.model.dynpopculicoides;

import fr.ocelet.datafacer.InputDataRecord;
import fr.ocelet.datafacer.OutputDataRecord;
import fr.ocelet.datafacer.ocltypes.Shapefile;
import fr.ocelet.model.dynpopculicoides.Site;
import fr.ocelet.runtime.entity.Entity;
import fr.ocelet.runtime.ocltypes.List;
import java.util.HashMap;

@SuppressWarnings("all")
public class Shp extends Shapefile {
  public Shp() {
    super("data/TRAVAIL/SHAPEFILE/SITES/Sites_culi.shp","EPSG:2975");
  }
  
  public List<Site> readAllSite() {
    List<Site> _elist = new List<Site>();
    for (InputDataRecord _record : this) {
      _elist.add(createSiteFromRecord(_record));
     }
    resetIterator();
    return _elist;
  }
  
  public List<Site> readAll() {
    return readAllSite();
  }
  
  public Site createSiteFromRecord(final InputDataRecord _rec) {
                      	    Site _entity = new Site();
    _entity.setProperty("id",readString("ID_SITE"));
    _entity.setProperty("commune",readString("site"));
    _entity.setProperty("altitude",readInteger("altitude"));
    _entity.setProperty("geom",readMultiPolygon("geom"));
    _entity.setProperty("kl",readInteger("KL"));
    return _entity;
  }
  
  public HashMap<String, String> getMatchdef() {
    HashMap<String, String> hm = new HashMap<String, String>();
    hm.put("ID_SITE","java.lang.String");
    hm.put("site","java.lang.String");
    hm.put("altitude","java.lang.Integer");
    hm.put("geom","fr.ocelet.runtime.geom.ocltypes.MultiPolygon");
    hm.put("KL","java.lang.Integer");
    return hm;
  }
  
  public List<Site> readFilteredSite(final String _filt) {
    setFilter(_filt);
    return readAllSite();
  }
  
  public OutputDataRecord createRecord(final Entity ety) throws IllegalArgumentException {
    OutputDataRecord odr = createOutputDataRec();
    if (odr != null) {
                       odr.setAttribute("ID_SITE",((Site) ety).getId());
                       odr.setAttribute("site",((Site) ety).getCommune());
                       odr.setAttribute("altitude",((Site) ety).getAltitude());
                       odr.setAttribute("geom",((Site) ety).getGeom());
                       odr.setAttribute("KL",((Site) ety).getKl());
    }
    return odr;
  }
}
