package fr.ocelet.model.dynpopculicoides;

import fr.ocelet.datafacer.ocltypes.KmlExport;
import fr.ocelet.runtime.entity.AbstractEntity;
import fr.ocelet.runtime.entity.Hproperty;
import fr.ocelet.runtime.geom.ocltypes.MultiPolygon;
import fr.ocelet.runtime.ocltypes.Date;
import org.eclipse.xtext.xbase.lib.DoubleExtensions;
import org.eclipse.xtext.xbase.lib.IntegerRange;

@SuppressWarnings("all")
public class Site extends AbstractEntity {
  public void setId(final String id) {
    setProperty("id",id);
  }
  
  public String getId() {
    return getProperty("id");
  }
  
  public void setCommune(final String commune) {
    setProperty("commune",commune);
  }
  
  public String getCommune() {
    return getProperty("commune");
  }
  
  public void setAltitude(final Integer altitude) {
    setProperty("altitude",altitude);
  }
  
  public Integer getAltitude() {
    return getProperty("altitude");
  }
  
  public void setDiff_alt(final Integer diff_alt) {
    setProperty("diff_alt",diff_alt);
  }
  
  public Integer getDiff_alt() {
    return getProperty("diff_alt");
  }
  
  public void setKl(final Integer kl) {
    setProperty("kl",kl);
  }
  
  public Integer getKl() {
    return getProperty("kl");
  }
  
  public void setGeom(final MultiPolygon geom) {
    setProperty("geom",geom);
  }
  
  public MultiPolygon getGeom() {
    return getProperty("geom");
  }
  
  public void setDate_begin(final String date_begin) {
    setProperty("date_begin",date_begin);
  }
  
  public String getDate_begin() {
    return getProperty("date_begin");
  }
  
  public void setDate_end(final String date_end) {
    setProperty("date_end",date_end);
  }
  
  public String getDate_end() {
    return getProperty("date_end");
  }
  
  public void setNom_station(final String nom_station) {
    setProperty("nom_station",nom_station);
  }
  
  public String getNom_station() {
    return getProperty("nom_station");
  }
  
  public void setDist_station(final Double dist_station) {
    setProperty("dist_station",dist_station);
  }
  
  public Double getDist_station() {
    return getProperty("dist_station");
  }
  
  public void setId_station(final Integer id_station) {
    setProperty("id_station",id_station);
  }
  
  public Integer getId_station() {
    return getProperty("id_station");
  }
  
  public void setNum_station(final Long num_station) {
    setProperty("num_station",num_station);
  }
  
  public Long getNum_station() {
    return getProperty("num_station");
  }
  
  public void setEggs(final Double eggs) {
    setProperty("eggs",eggs);
  }
  
  public Double getEggs() {
    return getProperty("eggs");
  }
  
  public void setLarvae(final Double larvae) {
    setProperty("larvae",larvae);
  }
  
  public Double getLarvae() {
    return getProperty("larvae");
  }
  
  public void setPupae(final Double pupae) {
    setProperty("pupae",pupae);
  }
  
  public Double getPupae() {
    return getProperty("pupae");
  }
  
  public void setAdults(final Double adults) {
    setProperty("adults",adults);
  }
  
  public Double getAdults() {
    return getProperty("adults");
  }
  
  public void setAdults_ov(final Double adults_ov) {
    setProperty("adults_ov",adults_ov);
  }
  
  public Double getAdults_ov() {
    return getProperty("adults_ov");
  }
  
  public void setFpon(final Integer fpon) {
    setProperty("fpon",fpon);
  }
  
  public Integer getFpon() {
    return getProperty("fpon");
  }
  
  public void setFegg(final Double fegg) {
    setProperty("fegg",fegg);
  }
  
  public Double getFegg() {
    return getProperty("fegg");
  }
  
  public void setFlarvae(final Double flarvae) {
    setProperty("flarvae",flarvae);
  }
  
  public Double getFlarvae() {
    return getProperty("flarvae");
  }
  
  public void setFpupae(final Double fpupae) {
    setProperty("fpupae",fpupae);
  }
  
  public Double getFpupae() {
    return getProperty("fpupae");
  }
  
  public void setFaov(final Double faov) {
    setProperty("faov",faov);
  }
  
  public Double getFaov() {
    return getProperty("faov");
  }
  
  public void setFme(final Double fme) {
    setProperty("fme",fme);
  }
  
  public Double getFme() {
    return getProperty("fme");
  }
  
  public void setFml(final Double fml) {
    setProperty("fml",fml);
  }
  
  public Double getFml() {
    return getProperty("fml");
  }
  
  public void setFmp(final Double fmp) {
    setProperty("fmp",fmp);
  }
  
  public Double getFmp() {
    return getProperty("fmp");
  }
  
  public void setFma(final Double fma) {
    setProperty("fma",fma);
  }
  
  public Double getFma() {
    return getProperty("fma");
  }
  
  public void setTemperature(final Double temperature) {
    setProperty("temperature",temperature);
  }
  
  public Double getTemperature() {
    return getProperty("temperature");
  }
  
  public void setTemperature_grad(final Double temperature_grad) {
    setProperty("temperature_grad",temperature_grad);
  }
  
  public Double getTemperature_grad() {
    return getProperty("temperature_grad");
  }
  
  public void setTmin(final Double tmin) {
    setProperty("tmin",tmin);
  }
  
  public Double getTmin() {
    return getProperty("tmin");
  }
  
  public void setTmax(final Double tmax) {
    setProperty("tmax",tmax);
  }
  
  public Double getTmax() {
    return getProperty("tmax");
  }
  
  /**
   * service updateVariablesRain () {
   * raincumul7 = raincumul7 + rain -rain7
   * }
   */
  public void setClassCuli(final Integer classCuli) {
    setProperty("classCuli",classCuli);
  }
  
  /**
   * service updateVariablesRain () {
   * raincumul7 = raincumul7 + rain -rain7
   * }
   */
  public Integer getClassCuli() {
    return getProperty("classCuli");
  }
  
  public void updateTemp() {
    Double _tmin = this.getTmin();
    Double _tmax = this.getTmax();
    double _plus = DoubleExtensions.operator_plus(_tmin, _tmax);
    double _divide = (_plus / 2);
    this.setTemperature(Double.valueOf(_divide));
  }
  
  public void gradientAlt(final Double temperature) {
    Integer _diff_alt = this.getDiff_alt();
    double _multiply = ((_diff_alt).intValue() * (6.5 / 1000));
    double _minus = ((temperature).doubleValue() - _multiply);
    this.setTemperature_grad(Double.valueOf(_minus));
  }
  
  public void lifeCycleFunctions(final Double temperature_grad) {
    this.setFpon(Integer.valueOf((60 / 2)));
    double _pow = Math.pow((temperature_grad).doubleValue(), 2);
    double _multiply = (0.0375 * _pow);
    double _minus = (_multiply - (1.9875 * (temperature_grad).doubleValue()));
    double duree_el = (_minus + 27.75);
    this.setFegg(Double.valueOf((1 / duree_el)));
    if (((temperature_grad).doubleValue() < 25)) {
      double _pow_1 = Math.pow((temperature_grad).doubleValue(), 2);
      double _multiply_1 = ((-0.2141) * _pow_1);
      double _plus = (_multiply_1 + (6.9271 * (temperature_grad).doubleValue()));
      double _minus_1 = (_plus - 19.045);
      double _divide = (_minus_1 / 100);
      this.setFme(Double.valueOf(_divide));
    }
    if (((temperature_grad).doubleValue() > 25)) {
      double _pow_2 = Math.pow((temperature_grad).doubleValue(), 2);
      double _multiply_2 = (0.3 * _pow_2);
      double _minus_2 = (_multiply_2 - (17.5 * (temperature_grad).doubleValue()));
      double _plus_1 = (_minus_2 + 270.0);
      double _divide_1 = (_plus_1 / 100);
      this.setFme(Double.valueOf(_divide_1));
    }
    Double _fme = this.getFme();
    boolean _greaterThan = ((_fme).doubleValue() > 1.0);
    if (_greaterThan) {
      this.setFme(Double.valueOf(1.0));
    }
    Double _fme_1 = this.getFme();
    boolean _lessThan = ((_fme_1).doubleValue() < 0.10);
    if (_lessThan) {
      this.setFme(Double.valueOf(0.10));
    }
    double _pow_3 = Math.pow((temperature_grad).doubleValue(), 2);
    double _multiply_3 = (0.0333 * _pow_3);
    double _minus_3 = (_multiply_3 - (2.6 * (temperature_grad).doubleValue()));
    double duree_lp = (_minus_3 + 54.667);
    this.setFlarvae(Double.valueOf((1 / duree_lp)));
    double _pow_4 = Math.pow((temperature_grad).doubleValue(), 3);
    double _multiply_4 = ((-0.0002) * _pow_4);
    double _pow_5 = Math.pow((temperature_grad).doubleValue(), 2);
    double _multiply_5 = (0.0172 * _pow_5);
    double _plus_2 = (_multiply_4 + _multiply_5);
    double _minus_4 = (_plus_2 - (0.4991 * (temperature_grad).doubleValue()));
    double _plus_3 = (_minus_4 + 4.8875);
    this.setFml(Double.valueOf(_plus_3));
    Double _fml = this.getFml();
    boolean _greaterThan_1 = ((_fml).doubleValue() > 1.0);
    if (_greaterThan_1) {
      this.setFml(Double.valueOf(1.0));
    }
    Double _fml_1 = this.getFml();
    boolean _lessThan_1 = ((_fml_1).doubleValue() < 0.10);
    if (_lessThan_1) {
      this.setFml(Double.valueOf(0.10));
    }
    double _pow_6 = Math.pow((temperature_grad).doubleValue(), 2);
    double _multiply_6 = (0.0083 * _pow_6);
    double _minus_5 = (_multiply_6 - (0.475 * (temperature_grad).doubleValue()));
    double _plus_4 = (_minus_5 + 9.1667);
    double _divide_2 = (1 / _plus_4);
    this.setFpupae(Double.valueOf(_divide_2));
    double _pow_7 = Math.pow((temperature_grad).doubleValue(), 2);
    double _multiply_7 = (0.0012 * _pow_7);
    double _minus_6 = (_multiply_7 - (0.0627 * (temperature_grad).doubleValue()));
    double _plus_5 = (_minus_6 + 0.8539);
    this.setFmp(Double.valueOf(_plus_5));
    Double _fmp = this.getFmp();
    boolean _greaterThan_2 = ((_fmp).doubleValue() > 1);
    if (_greaterThan_2) {
      this.setFmp(Double.valueOf(1.0));
    }
    double _pow_8 = Math.pow((temperature_grad).doubleValue(), 2);
    double _multiply_8 = (0.6208 * _pow_8);
    double _minus_7 = (_multiply_8 - (31.738 * (temperature_grad).doubleValue()));
    double cycle_gon = (_minus_7 + 409.42);
    this.setFaov(Double.valueOf((1 / cycle_gon)));
    if (((temperature_grad).doubleValue() < 15)) {
      double _pow_9 = Math.pow((temperature_grad).doubleValue(), 2);
      double _multiply_9 = ((-0.002) * _pow_9);
      double _plus_6 = (_multiply_9 + (0.0727 * (temperature_grad).doubleValue()));
      double _plus_7 = (_plus_6 + 0.3232);
      this.setFma(Double.valueOf(_plus_7));
      Double _fma = this.getFma();
      double _minus_8 = (1 - (_fma).doubleValue());
      this.setFma(Double.valueOf(_minus_8));
    }
    if ((((temperature_grad).doubleValue() > 15) && ((temperature_grad).doubleValue() < 35))) {
      double _pow_10 = Math.pow((temperature_grad).doubleValue(), 2);
      double _multiply_10 = (0.0002 * _pow_10);
      double _minus_9 = (_multiply_10 - (0.016 * (temperature_grad).doubleValue()));
      double _plus_8 = (_minus_9 + 1.155);
      this.setFma(Double.valueOf(_plus_8));
      Double _fma_1 = this.getFma();
      double _minus_10 = (1 - (_fma_1).doubleValue());
      this.setFma(Double.valueOf(_minus_10));
    }
    if (((temperature_grad).doubleValue() > 35)) {
      double _pow_11 = Math.pow((temperature_grad).doubleValue(), 2);
      double _multiply_11 = ((-0.0068) * _pow_11);
      double _plus_9 = (_multiply_11 + (0.4054 * (temperature_grad).doubleValue()));
      double _minus_11 = (_plus_9 - 4.9906);
      this.setFma(Double.valueOf(_minus_11));
      Double _fma_2 = this.getFma();
      double _minus_12 = (1 - (_fma_2).doubleValue());
      this.setFma(Double.valueOf(_minus_12));
    }
    Double _fma_3 = this.getFma();
    boolean _greaterThan_3 = ((_fma_3).doubleValue() > 0.99);
    if (_greaterThan_3) {
      this.setFma(Double.valueOf(0.99));
    }
    Double _fma_4 = this.getFma();
    boolean _lessThan_2 = ((_fma_4).doubleValue() < 0.0);
    if (_lessThan_2) {
      this.setFma(Double.valueOf(0.0));
    }
  }
  
  public void dynPop(final Double dt) {
    long _round = Math.round((1 / (dt).doubleValue()));
    int npastemps = Long.valueOf(_round).intValue();
    Double x1 = this.getEggs();
    Double x2 = this.getLarvae();
    Double x3 = this.getPupae();
    Double x4 = this.getAdults();
    Double x5 = this.getAdults_ov();
    double k1 = 0.0;
    double l1 = 0.0;
    double m1 = 0.0;
    double n1 = 0.0;
    double o1 = 0.0;
    IntegerRange _upTo = new IntegerRange(1, npastemps);
    for (final Integer y : _upTo) {
      {
        Integer _fpon = this.getFpon();
        double _multiply = DoubleExtensions.operator_multiply(x5, _fpon);
        Double _fegg = this.getFegg();
        double _multiply_1 = DoubleExtensions.operator_multiply(x1, _fegg);
        double _minus = (_multiply - _multiply_1);
        Double _fme = this.getFme();
        double _multiply_2 = DoubleExtensions.operator_multiply(x1, _fme);
        double _minus_1 = (_minus - _multiply_2);
        k1 = _minus_1;
        Double _fegg_1 = this.getFegg();
        double _multiply_3 = DoubleExtensions.operator_multiply(x1, _fegg_1);
        Double _flarvae = this.getFlarvae();
        double _multiply_4 = DoubleExtensions.operator_multiply(x2, _flarvae);
        double _minus_2 = (_multiply_3 - _multiply_4);
        Double _fml = this.getFml();
        double _multiply_5 = DoubleExtensions.operator_multiply(x2, _fml);
        Integer _kl = this.getKl();
        double _divide = DoubleExtensions.operator_divide(x2, _kl);
        double _plus = (1 + _divide);
        double _multiply_6 = (_multiply_5 * _plus);
        double _minus_3 = (_minus_2 - _multiply_6);
        l1 = _minus_3;
        Double _flarvae_1 = this.getFlarvae();
        double _multiply_7 = DoubleExtensions.operator_multiply(x2, _flarvae_1);
        Double _fpupae = this.getFpupae();
        double _multiply_8 = DoubleExtensions.operator_multiply(x3, _fpupae);
        double _minus_4 = (_multiply_7 - _multiply_8);
        Double _fmp = this.getFmp();
        double _multiply_9 = DoubleExtensions.operator_multiply(x3, _fmp);
        double _minus_5 = (_minus_4 - _multiply_9);
        m1 = _minus_5;
        Double _fpupae_1 = this.getFpupae();
        double _multiply_10 = DoubleExtensions.operator_multiply(x3, _fpupae_1);
        Double _faov = this.getFaov();
        double _multiply_11 = DoubleExtensions.operator_multiply(x4, _faov);
        double _minus_6 = (_multiply_10 - _multiply_11);
        Double _fma = this.getFma();
        double _multiply_12 = DoubleExtensions.operator_multiply(x4, _fma);
        double _minus_7 = (_minus_6 - _multiply_12);
        double _plus_1 = (_minus_7 + (x5).doubleValue());
        n1 = _plus_1;
        Double _faov_1 = this.getFaov();
        double _multiply_13 = DoubleExtensions.operator_multiply(x4, _faov_1);
        double _minus_8 = (_multiply_13 - (x5).doubleValue());
        o1 = _minus_8;
        double k = ((x1).doubleValue() + ((dt).doubleValue() * k1));
        double l = ((x2).doubleValue() + ((dt).doubleValue() * l1));
        double m = ((x3).doubleValue() + ((dt).doubleValue() * m1));
        double n = ((x4).doubleValue() + ((dt).doubleValue() * n1));
        double o = ((x5).doubleValue() + ((dt).doubleValue() * o1));
        x1 = Double.valueOf(k);
        x2 = Double.valueOf(l);
        x3 = Double.valueOf(m);
        x4 = Double.valueOf(n);
        x5 = Double.valueOf(o);
      }
    }
    this.setEggs(x1);
    this.setLarvae(x2);
    this.setPupae(x3);
    this.setAdults(x4);
    this.setAdults_ov(x5);
  }
  
  public void classify() {
    Double _adults = this.getAdults();
    boolean _lessThan = ((_adults).doubleValue() < 50);
    if (_lessThan) {
      this.setClassCuli(Integer.valueOf(1));
    }
    boolean _and = false;
    Double _adults_1 = this.getAdults();
    boolean _greaterEqualsThan = ((_adults_1).doubleValue() >= 50);
    if (!_greaterEqualsThan) {
      _and = false;
    } else {
      Double _adults_2 = this.getAdults();
      boolean _lessThan_1 = ((_adults_2).doubleValue() < 100);
      _and = _lessThan_1;
    }
    if (_and) {
      this.setClassCuli(Integer.valueOf(2));
    }
    boolean _and_1 = false;
    Double _adults_3 = this.getAdults();
    boolean _greaterEqualsThan_1 = ((_adults_3).doubleValue() >= 100);
    if (!_greaterEqualsThan_1) {
      _and_1 = false;
    } else {
      Double _adults_4 = this.getAdults();
      boolean _lessThan_2 = ((_adults_4).doubleValue() < 200);
      _and_1 = _lessThan_2;
    }
    if (_and_1) {
      this.setClassCuli(Integer.valueOf(3));
    }
    boolean _and_2 = false;
    Double _adults_5 = this.getAdults();
    boolean _greaterEqualsThan_2 = ((_adults_5).doubleValue() >= 200);
    if (!_greaterEqualsThan_2) {
      _and_2 = false;
    } else {
      Double _adults_6 = this.getAdults();
      boolean _lessThan_3 = ((_adults_6).doubleValue() < 300);
      _and_2 = _lessThan_3;
    }
    if (_and_2) {
      this.setClassCuli(Integer.valueOf(4));
    }
    Double _adults_7 = this.getAdults();
    boolean _greaterEqualsThan_3 = ((_adults_7).doubleValue() >= 300);
    if (_greaterEqualsThan_3) {
      this.setClassCuli(Integer.valueOf(5));
    }
  }
  
  public void outputKml(final Integer day, final Date now, final Integer frequencedisplay, final KmlExport kml) {
    String _id = this.getId();
    String _plus = ("Site" + _id);
    String _plus_1 = (_plus + "_");
    String _string = now.toString("yyyy-MM-dd");
    String id = (_plus_1 + _string);
    Integer _classCuli = this.getClassCuli();
    String style = ("R0_" + _classCuli);
    Date deb = now;
    Date fin = now.clone();
    fin.addDays((frequencedisplay).intValue());
    MultiPolygon _geom = this.getGeom();
    kml.addGeometry(style, id, deb, fin, _geom, style, 0);
  }
  
  public Site() {
    super();
    defProperty("id",new Hproperty<String>());
    setId(new String());
    defProperty("commune",new Hproperty<String>());
    setCommune(new String());
    defProperty("altitude",new Hproperty<Integer>());
    setAltitude(new Integer("0"));
    defProperty("diff_alt",new Hproperty<Integer>());
    setDiff_alt(new Integer("0"));
    defProperty("kl",new Hproperty<Integer>());
    setKl(new Integer("0"));
    defProperty("geom",new Hproperty<MultiPolygon>());
    setGeom(new MultiPolygon());
    defProperty("date_begin",new Hproperty<String>());
    setDate_begin(new String());
    defProperty("date_end",new Hproperty<String>());
    setDate_end(new String());
    defProperty("nom_station",new Hproperty<String>());
    setNom_station(new String());
    defProperty("dist_station",new Hproperty<Double>());
    setDist_station(new Double("0"));
    defProperty("id_station",new Hproperty<Integer>());
    setId_station(new Integer("0"));
    defProperty("num_station",new Hproperty<Long>());
    setNum_station(new Long("0"));
    defProperty("eggs",new Hproperty<Double>());
    setEggs(new Double("0"));
    defProperty("larvae",new Hproperty<Double>());
    setLarvae(new Double("0"));
    defProperty("pupae",new Hproperty<Double>());
    setPupae(new Double("0"));
    defProperty("adults",new Hproperty<Double>());
    setAdults(new Double("0"));
    defProperty("adults_ov",new Hproperty<Double>());
    setAdults_ov(new Double("0"));
    defProperty("fpon",new Hproperty<Integer>());
    setFpon(new Integer("0"));
    defProperty("fegg",new Hproperty<Double>());
    setFegg(new Double("0"));
    defProperty("flarvae",new Hproperty<Double>());
    setFlarvae(new Double("0"));
    defProperty("fpupae",new Hproperty<Double>());
    setFpupae(new Double("0"));
    defProperty("faov",new Hproperty<Double>());
    setFaov(new Double("0"));
    defProperty("fme",new Hproperty<Double>());
    setFme(new Double("0"));
    defProperty("fml",new Hproperty<Double>());
    setFml(new Double("0"));
    defProperty("fmp",new Hproperty<Double>());
    setFmp(new Double("0"));
    defProperty("fma",new Hproperty<Double>());
    setFma(new Double("0"));
    defProperty("temperature",new Hproperty<Double>());
    setTemperature(new Double("0"));
    defProperty("temperature_grad",new Hproperty<Double>());
    setTemperature_grad(new Double("0"));
    defProperty("tmin",new Hproperty<Double>());
    setTmin(new Double("0"));
    defProperty("tmax",new Hproperty<Double>());
    setTmax(new Double("0"));
    defProperty("classCuli",new Hproperty<Integer>());
    setClassCuli(new Integer("0"));
  }
}
