package fr.ocelet.model.dynpopculicoides;

import fr.ocelet.datafacer.InputDataRecord;
import fr.ocelet.datafacer.OutputDataRecord;
import fr.ocelet.datafacer.ocltypes.Shapefile;
import fr.ocelet.model.dynpopculicoides.Site;
import fr.ocelet.runtime.entity.Entity;
import fr.ocelet.runtime.ocltypes.List;
import java.util.HashMap;

@SuppressWarnings("all")
public class ShpOutAllDates extends Shapefile {
  public ShpOutAllDates() {
    super("output/REUNION_serietemporelle.shp","EPSG:2975");
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
    _entity.setProperty("geom",readMultiPolygon("geom"));
    _entity.setProperty("id",readString("ID"));
    _entity.setProperty("commune",readString("Commune"));
    _entity.setProperty("date_begin",readString("date_debut"));
    _entity.setProperty("nom_station",readString("Stat_meteo"));
    _entity.setProperty("eggs",readDouble("oeufs"));
    _entity.setProperty("larvae",readDouble("larves"));
    _entity.setProperty("pupae",readDouble("nymphes"));
    _entity.setProperty("adults",readDouble("adultes"));
    _entity.setProperty("adults_ov",readDouble("adultes_ov"));
    _entity.setProperty("temperature",readDouble("t°"));
    _entity.setProperty("temperature_grad",readDouble("t°grad"));
    return _entity;
  }
  
  public HashMap<String, String> getMatchdef() {
    HashMap<String, String> hm = new HashMap<String, String>();
    hm.put("geom","fr.ocelet.runtime.geom.ocltypes.MultiPolygon");
    hm.put("ID","java.lang.String");
    hm.put("Commune","java.lang.String");
    hm.put("date_debut","java.lang.String");
    hm.put("Stat_meteo","java.lang.String");
    hm.put("oeufs","java.lang.Double");
    hm.put("larves","java.lang.Double");
    hm.put("nymphes","java.lang.Double");
    hm.put("adultes","java.lang.Double");
    hm.put("adultes_ov","java.lang.Double");
    hm.put("t°","java.lang.Double");
    hm.put("t°grad","java.lang.Double");
    return hm;
  }
  
  public List<Site> readFilteredSite(final String _filt) {
    setFilter(_filt);
    return readAllSite();
  }
  
  public OutputDataRecord createRecord(final Entity ety) throws IllegalArgumentException {
    OutputDataRecord odr = createOutputDataRec();
    if (odr != null) {
                       odr.setAttribute("geom",((Site) ety).getGeom());
                       odr.setAttribute("ID",((Site) ety).getId());
                       odr.setAttribute("Commune",((Site) ety).getCommune());
                       odr.setAttribute("date_debut",((Site) ety).getDate_begin());
                       odr.setAttribute("Stat_meteo",((Site) ety).getNom_station());
                       odr.setAttribute("oeufs",((Site) ety).getEggs());
                       odr.setAttribute("larves",((Site) ety).getLarvae());
                       odr.setAttribute("nymphes",((Site) ety).getPupae());
                       odr.setAttribute("adultes",((Site) ety).getAdults());
                       odr.setAttribute("adultes_ov",((Site) ety).getAdults_ov());
                       odr.setAttribute("t°",((Site) ety).getTemperature());
                       odr.setAttribute("t°grad",((Site) ety).getTemperature_grad());
    }
    return odr;
  }
}
