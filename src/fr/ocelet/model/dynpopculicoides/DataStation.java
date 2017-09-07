package fr.ocelet.model.dynpopculicoides;

import fr.ocelet.runtime.entity.AbstractEntity;
import fr.ocelet.runtime.entity.Hproperty;
import fr.ocelet.runtime.ocltypes.Date;
import org.eclipse.xtext.xbase.lib.DoubleExtensions;

@SuppressWarnings("all")
public class DataStation extends AbstractEntity {
  public void setName(final String name) {
    setProperty("name",name);
  }
  
  public String getName() {
    return getProperty("name");
  }
  
  public void setNumero(final Integer numero) {
    setProperty("numero",numero);
  }
  
  public Integer getNumero() {
    return getProperty("numero");
  }
  
  public void setDateTXT(final String dateTXT) {
    setProperty("dateTXT",dateTXT);
  }
  
  public String getDateTXT() {
    return getProperty("dateTXT");
  }
  
  public void setTempC(final Double tempC) {
    setProperty("tempC",tempC);
  }
  
  public Double getTempC() {
    return getProperty("tempC");
  }
  
  public void setTempMin(final Double tempMin) {
    setProperty("tempMin",tempMin);
  }
  
  public Double getTempMin() {
    return getProperty("tempMin");
  }
  
  public void setTempMax(final Double tempMax) {
    setProperty("tempMax",tempMax);
  }
  
  public Double getTempMax() {
    return getProperty("tempMax");
  }
  
  public void setRainMM(final Double rainMM) {
    setProperty("rainMM",rainMM);
  }
  
  public Double getRainMM() {
    return getProperty("rainMM");
  }
  
  public void setDate(final Date date) {
    setProperty("date",date);
  }
  
  public Date getDate() {
    return getProperty("date");
  }
  
  public void getDate() {
    String _dateTXT = this.getDateTXT();
    Date _fromString = Date.fromString("dd/MM/yyyy", _dateTXT);
    this.setDate(_fromString);
  }
  
  public void getTempMoy() {
    Double _tempMin = this.getTempMin();
    Double _tempMax = this.getTempMax();
    double _plus = DoubleExtensions.operator_plus(_tempMin, _tempMax);
    double _divide = (_plus / 2);
    this.setTempC(Double.valueOf(_divide));
  }
  
  public DataStation() {
    super();
    defProperty("name",new Hproperty<String>());
    setName(new String());
    defProperty("numero",new Hproperty<Integer>());
    setNumero(new Integer("0"));
    defProperty("dateTXT",new Hproperty<String>());
    setDateTXT(new String());
    defProperty("tempC",new Hproperty<Double>());
    setTempC(new Double("0"));
    defProperty("tempMin",new Hproperty<Double>());
    setTempMin(new Double("0"));
    defProperty("tempMax",new Hproperty<Double>());
    setTempMax(new Double("0"));
    defProperty("rainMM",new Hproperty<Double>());
    setRainMM(new Double("0"));
    defProperty("date",new Hproperty<Date>());
    setDate(new Date());
  }
}
