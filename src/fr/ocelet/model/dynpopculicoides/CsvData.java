package fr.ocelet.model.dynpopculicoides;

import fr.ocelet.datafacer.InputDataRecord;
import fr.ocelet.datafacer.ocltypes.Csvfile;
import fr.ocelet.model.dynpopculicoides.DataStation;
import fr.ocelet.runtime.entity.Entity;
import fr.ocelet.runtime.ocltypes.List;
import java.util.HashMap;

@SuppressWarnings("all")
public class CsvData extends Csvfile {
  public CsvData() {
    super("data/TRAVAIL/CSVDATA/METEO/97401540.csv");
  }
  
  public List<DataStation> readAllDataStation() {
    List<DataStation> _elist = new List<DataStation>();
    for (InputDataRecord _record : this) {
      _elist.add(createDataStationFromRecord(_record));
     }
    resetIterator();
    return _elist;
  }
  
  public List<DataStation> readAll() {
    return readAllDataStation();
  }
  
  public DataStation createDataStationFromRecord(final InputDataRecord _rec) {
                      	    DataStation _entity = new DataStation();
    _entity.setProperty("numero",readInteger("Numero"));
    _entity.setProperty("dateTXT",readString("Date"));
    _entity.setProperty("tempMin",readDouble("Tmin"));
    _entity.setProperty("tempMax",readDouble("Tmax"));
    _entity.setProperty("rainMM",readDouble("Rain"));
    return _entity;
  }
  
  public HashMap<String, String> getMatchdef() {
    HashMap<String, String> hm = new HashMap<String, String>();
    hm.put("Numero","java.lang.Integer");
    hm.put("Date","java.lang.String");
    hm.put("Tmin","java.lang.Double");
    hm.put("Tmax","java.lang.Double");
    hm.put("Rain","java.lang.Double");
    return hm;
  }
  
  public String headerString() {
      StringBuffer sb = new StringBuffer();
    sb.append("Numero");
    sb.append(separator);                     
    sb.append("Date");
    sb.append(separator);                     
    sb.append("Tmin");
    sb.append(separator);                     
    sb.append("Tmax");
    sb.append(separator);                     
    sb.append("Rain");
    return sb.toString();
  }
  
  public String propsString(final Entity _entity) {
      StringBuffer sb = new StringBuffer();
    sb.append(_entity.getProperty("numero"));
    sb.append(separator);                     
    sb.append(_entity.getProperty("dateTXT"));
    sb.append(separator);                     
    sb.append(_entity.getProperty("tempMin"));
    sb.append(separator);                     
    sb.append(_entity.getProperty("tempMax"));
    sb.append(separator);                     
    sb.append(_entity.getProperty("rainMM"));
    return sb.toString();
  }
}
