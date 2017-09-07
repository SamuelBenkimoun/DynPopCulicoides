package fr.ocelet.model.dynpopculicoides;

import fr.ocelet.model.dynpopculicoides.CsvData;
import fr.ocelet.model.dynpopculicoides.DataStation;
import fr.ocelet.model.dynpopculicoides.KmlOut;
import fr.ocelet.model.dynpopculicoides.LocStation;
import fr.ocelet.model.dynpopculicoides.Shp;
import fr.ocelet.model.dynpopculicoides.ShpOutAllDates;
import fr.ocelet.model.dynpopculicoides.ShpStation;
import fr.ocelet.model.dynpopculicoides.Site;
import fr.ocelet.runtime.Miscutils;
import fr.ocelet.runtime.TextFileWriter;
import fr.ocelet.runtime.geom.ocltypes.MultiPolygon;
import fr.ocelet.runtime.geom.ocltypes.Point;
import fr.ocelet.runtime.model.AbstractModel;
import fr.ocelet.runtime.model.Parameter;
import fr.ocelet.runtime.model.ParameterImpl;
import fr.ocelet.runtime.model.SimulationListener;
import fr.ocelet.runtime.ocltypes.Date;
import fr.ocelet.runtime.ocltypes.KeyMap;
import fr.ocelet.runtime.ocltypes.List;
import java.util.HashMap;
import org.eclipse.xtext.xbase.lib.InputOutput;

@SuppressWarnings("all")
public class DynPopCulicoides extends AbstractModel {
  public DynPopCulicoides() {
    super("DynPopCulicoides");
    Parameter<String> par_region = new ParameterImpl<String>("region","",true,"REUNION",null);
    addParameter(par_region);
    region = "REUNION";
    Parameter<Boolean> par_replaceMeteoFiles = new ParameterImpl<Boolean>("replaceMeteoFiles","",true,false,null);
    addParameter(par_replaceMeteoFiles);
    replaceMeteoFiles = false;
    Parameter<String> par_inputDirNew = new ParameterImpl<String>("inputDirNew","",true,"data/ENTREES",null);
    addParameter(par_inputDirNew);
    inputDirNew = "data/ENTREES";
    Parameter<String> par_inputDirWork = new ParameterImpl<String>("inputDirWork","",true,"data/TRAVAIL",null);
    addParameter(par_inputDirWork);
    inputDirWork = "data/TRAVAIL";
    Parameter<String> par_date_debut = new ParameterImpl<String>("date_debut","",true,"01/01/2014",null);
    addParameter(par_date_debut);
    date_debut = "01/01/2014";
    Parameter<String> par_date_fin = new ParameterImpl<String>("date_fin","",true,"31/12/2016",null);
    addParameter(par_date_fin);
    date_fin = "31/12/2016";
    Parameter<Boolean> par_outputAllDates = new ParameterImpl<Boolean>("outputAllDates","",true,true,null);
    addParameter(par_outputAllDates);
    outputAllDates = true;
    Parameter<Boolean> par_outputLastDate = new ParameterImpl<Boolean>("outputLastDate","",true,true,null);
    addParameter(par_outputLastDate);
    outputLastDate = true;
    Parameter<Boolean> par_exportSHP = new ParameterImpl<Boolean>("exportSHP","",true,true,null);
    addParameter(par_exportSHP);
    exportSHP = true;
    Parameter<String> par_outputDir = new ParameterImpl<String>("outputDir","",true,"output",null);
    addParameter(par_outputDir);
    outputDir = "output";
    Parameter<Boolean> par_exportKML = new ParameterImpl<Boolean>("exportKML","",true,false,null);
    addParameter(par_exportKML);
    exportKML = false;
  }
  
  public static void main(final String[] args) {
    DynPopCulicoides model_DynPopCulicoides = new DynPopCulicoides();
    model_DynPopCulicoides.run_DynPopCulicoides();
  }
  
  public void run_DynPopCulicoides() {
    InputOutput.<String>println("Model DynPopCulicoides ready to run");
    Date debutCalcul = new Date();
    final int frequencedisplay = 1;
    final double dt = 0.1;
    Date bdateuser = Date.fromString("dd/MM/yyyy", this.date_debut);
    Date edateuser = Date.fromString("dd/MM/yyyy", this.date_fin);
    Shp shp = new Shp();
    String nomDeFichier = (this.inputDirWork + "/SHAPEFILE/SITES/Sites_culi.shp");
    shp.setFileName(nomDeFichier);
    ShpStation shpStation = new ShpStation();
    nomDeFichier = (this.inputDirWork + "/SHAPEFILE/STATIONS/31Stations.shp");
    shpStation.setFileName(nomDeFichier);
    CsvData csvData = new CsvData();
    nomDeFichier = (this.inputDirWork + "/CSVDATA/METEO/97404540.csv");
    csvData.setFileName(nomDeFichier);
    CsvData csvDataNew = new CsvData();
    nomDeFichier = (this.inputDirNew + "/97404540.csv");
    csvDataNew.setFileName(nomDeFichier);
    CsvData csvDataOut = new CsvData();
    nomDeFichier = (this.outputDir + "/historique_simulations.csv");
    csvDataOut.setFileName(nomDeFichier);
    KmlOut kmlout = new KmlOut();
    nomDeFichier = (((this.outputDir + "/") + this.region) + "_serietemporelle.kml");
    kmlout.setFileName(nomDeFichier);
    ShpOutAllDates shpout = new ShpOutAllDates();
    InputOutput.<String>println("Reading data ... ");
    List<Site> lsitetot = shp.readAllSite();
    InputOutput.<String>println("shp read ...");
    List<LocStation> lstation = shpStation.readAllLocStation();
    final KeyMap<Integer, List<DataStation>> allMeteoData = new KeyMap<Integer, List<DataStation>>();
    int i = 0;
    for (final LocStation s : lstation) {
      {
        Long _numero = s.getNumero();
        String _plus = ((this.inputDirWork + "/CSVDATA/METEO/") + _numero);
        String nomDeFichierCsv = (_plus + ".csv");
        csvData.setFileName(nomDeFichierCsv);
        if (((this.replaceMeteoFiles).booleanValue() == true)) {
          Long _numero_1 = s.getNumero();
          String _plus_1 = ((this.inputDirNew + "/") + _numero_1);
          String nomDeFichierCsvNew = (_plus_1 + ".csv");
          csvDataNew.setFileName(nomDeFichierCsvNew);
          List<DataStation> DataMeteoNew = csvDataNew.readAll();
          for (final DataStation j : DataMeteoNew) {
            {
              Integer _numero_2 = j.getNumero();
              String ligneDeTexte = _numero_2.toString();
              String _dateTXT = j.getDateTXT();
              String _plus_2 = (";" + _dateTXT);
              String _plus_3 = (_plus_2 + ";");
              Double _rainMM = j.getRainMM();
              String _string = _rainMM.toString();
              String _plus_4 = (_plus_3 + _string);
              String _plus_5 = (_plus_4 + ";");
              Double _tempMin = j.getTempMin();
              String _string_1 = _tempMin.toString();
              String _plus_6 = (_plus_5 + _string_1);
              String _plus_7 = (_plus_6 + ";");
              Double _tempMax = j.getTempMax();
              String _string_2 = _tempMax.toString();
              String _plus_8 = (_plus_7 + _string_2);
              String _concat = ligneDeTexte.concat(_plus_8);
              ligneDeTexte = _concat;
              TextFileWriter.printToFile(nomDeFichierCsv, ligneDeTexte);
            }
          }
        }
        List<DataStation> DataMeteo = csvData.readAll();
        allMeteoData.put(Integer.valueOf(i), DataMeteo);
        i = (i + 1);
      }
    }
    List<DataStation> _get = allMeteoData.get(Integer.valueOf(0));
    DataStation _get_1 = _get.get(0);
    String _dateTXT = _get_1.getDateTXT();
    final Date bdate = Date.fromString("yyyy-MM-dd", _dateTXT);
    List<DataStation> _get_2 = allMeteoData.get(Integer.valueOf(0));
    DataStation _get_3 = _get_2.get(0);
    String _dateTXT_1 = _get_3.getDateTXT();
    Date bdate1 = Date.fromString("yyyy-MM-dd", _dateTXT_1);
    bdate1.addYears(1);
    boolean _isBefore = bdateuser.isBefore(bdate1);
    boolean _equals = (_isBefore == true);
    if (_equals) {
      bdateuser = bdate1;
    }
    List<DataStation> _get_4 = allMeteoData.get(Integer.valueOf(0));
    DataStation _get_5 = _get_4.get(0);
    String _dateTXT_2 = _get_5.getDateTXT();
    Date edate = Date.fromString("yyyy-MM-dd", _dateTXT_2);
    List<DataStation> _get_6 = allMeteoData.get(Integer.valueOf(0));
    int _size = _get_6.size();
    int _minus = (_size - 1);
    edate.addDays(_minus);
    boolean _isAfter = edateuser.isAfter(edate);
    boolean _equals_1 = (_isAfter == true);
    if (_equals_1) {
      edateuser = edate;
    }
    int _year = bdateuser.getYear();
    String _plus = ((((this.outputDir + "/") + this.region) + "_") + Integer.valueOf(_year));
    int _month = bdateuser.getMonth();
    String _format = Miscutils.format(Integer.valueOf(_month), "00");
    String _plus_1 = (_plus + _format);
    int _dayOfMonth = bdateuser.getDayOfMonth();
    String _format_1 = Miscutils.format(Integer.valueOf(_dayOfMonth), "00");
    String _plus_2 = (_plus_1 + _format_1);
    String _plus_3 = (_plus_2 + "_");
    int _year_1 = edateuser.getYear();
    String _plus_4 = (_plus_3 + Integer.valueOf(_year_1));
    int _month_1 = edateuser.getMonth();
    String _format_2 = Miscutils.format(Integer.valueOf(_month_1), "00");
    String _plus_5 = (_plus_4 + _format_2);
    int _dayOfMonth_1 = edateuser.getDayOfMonth();
    String _format_3 = Miscutils.format(Integer.valueOf(_dayOfMonth_1), "00");
    String _plus_6 = (_plus_5 + _format_3);
    String nomDeFichierShpAll = (_plus_6 + ".shp");
    shpout.setFileName(nomDeFichierShpAll);
    if (((this.outputAllDates).booleanValue() == true)) {
      shpout.remove();
    }
    Date now = bdate.clone();
    double test_display = 0.0;
    Date fin = now.clone();
    for (final Site sit : lsitetot) {
      {
        sit.setEggs(Double.valueOf(1000.0));
        sit.setLarvae(Double.valueOf(0.0));
        sit.setPupae(Double.valueOf(0.0));
        sit.setAdults(Double.valueOf(0.0));
        sit.setAdults_ov(Double.valueOf(0.0));
        sit.setDist_station(Double.valueOf(1000000.0));
        i = 0;
        for (final LocStation s_1 : lstation) {
          {
            MultiPolygon _geom = sit.getGeom();
            Point _geom_1 = s_1.getGeom();
            double dist = _geom.distance(_geom_1);
            Double _dist_station = sit.getDist_station();
            boolean _lessThan = (dist < (_dist_station).doubleValue());
            if (_lessThan) {
              sit.setDist_station(Double.valueOf(dist));
              Long _numero = s_1.getNumero();
              sit.setNum_station(_numero);
              sit.setId_station(Integer.valueOf(i));
              Integer _altitude = sit.getAltitude();
              Integer _altitude_1 = s_1.getAltitude();
              int _minus_1 = ((_altitude).intValue() - (_altitude_1).intValue());
              sit.setDiff_alt(Integer.valueOf(_minus_1));
            }
            i = (i + 1);
          }
        }
      }
    }
    int day = 0;
    while ((now.isBefore(edateuser.addDays(1)) == true)) {
      {
        String _string = now.toString("dd/MM/yyyy");
        String _plus_7 = ("date en cours : " + _string);
        this.printOut(_plus_7);
        edateuser.addDays((-1));
        boolean _isAfter_1 = now.isAfter(bdateuser);
        boolean _equals_2 = (_isAfter_1 == true);
        if (_equals_2) {
          double _IEEEremainder = Math.IEEEremainder(day, frequencedisplay);
          test_display = _IEEEremainder;
          Date _clone = now.clone();
          fin = _clone;
          fin.addDays(frequencedisplay);
        }
        int j = 0;
        for (final Site sit_1 : lsitetot) {
          {
            Integer _id_station = sit_1.getId_station();
            i = (_id_station).intValue();
            List<DataStation> _get_7 = allMeteoData.get(Integer.valueOf(i));
            DataStation _get_8 = _get_7.get(day);
            Double _tempMin = _get_8.getTempMin();
            sit_1.setTmin(_tempMin);
            List<DataStation> _get_9 = allMeteoData.get(Integer.valueOf(i));
            DataStation _get_10 = _get_9.get(day);
            Double _tempMax = _get_10.getTempMax();
            sit_1.setTmax(_tempMax);
            sit_1.updateTemp();
            Double _temperature = sit_1.getTemperature();
            sit_1.gradientAlt(_temperature);
            Double _temperature_grad = sit_1.getTemperature_grad();
            sit_1.lifeCycleFunctions(_temperature_grad);
            sit_1.dynPop(Double.valueOf(dt));
            if (((this.exportKML).booleanValue() == true)) {
              sit_1.classify();
            }
            boolean _isAfter_2 = now.isAfter(bdateuser);
            boolean _equals_3 = (_isAfter_2 == true);
            if (_equals_3) {
              if ((test_display == 0)) {
                if (((this.exportKML).booleanValue() == true)) {
                  sit_1.outputKml(Integer.valueOf(day), now, Integer.valueOf(frequencedisplay), kmlout);
                }
                String _string_1 = now.toString("yyyy-MM-dd");
                sit_1.setDate_begin(_string_1);
                String _string_2 = fin.toString("yyyy-MM-dd");
                sit_1.setDate_end(_string_2);
              }
            }
            j = (j + 1);
          }
        }
        boolean _isAfter_2 = now.isAfter(bdateuser);
        boolean _equals_3 = (_isAfter_2 == true);
        if (_equals_3) {
          if ((test_display == 0)) {
            if (((this.outputAllDates).booleanValue() == true)) {
              shpout.append(lsitetot);
            }
          }
        }
        day = (day + 1);
        now.addDays(1);
      }
    }
    InputOutput.<String>println(".");
    InputOutput.<String>println("Saving kml file...");
    kmlout.saveAsKml();
    InputOutput.<String>println("Geronimo !");
  }
  
  public void simulate(final HashMap<String, Object> in_params) {
    String val_region = (String) in_params.get("region");
    if (val_region != null) region = val_region;
    Boolean val_replaceMeteoFiles = (Boolean) in_params.get("replaceMeteoFiles");
    if (val_replaceMeteoFiles != null) replaceMeteoFiles = val_replaceMeteoFiles;
    String val_inputDirNew = (String) in_params.get("inputDirNew");
    if (val_inputDirNew != null) inputDirNew = val_inputDirNew;
    String val_inputDirWork = (String) in_params.get("inputDirWork");
    if (val_inputDirWork != null) inputDirWork = val_inputDirWork;
    String val_date_debut = (String) in_params.get("date_debut");
    if (val_date_debut != null) date_debut = val_date_debut;
    String val_date_fin = (String) in_params.get("date_fin");
    if (val_date_fin != null) date_fin = val_date_fin;
    Boolean val_outputAllDates = (Boolean) in_params.get("outputAllDates");
    if (val_outputAllDates != null) outputAllDates = val_outputAllDates;
    Boolean val_outputLastDate = (Boolean) in_params.get("outputLastDate");
    if (val_outputLastDate != null) outputLastDate = val_outputLastDate;
    Boolean val_exportSHP = (Boolean) in_params.get("exportSHP");
    if (val_exportSHP != null) exportSHP = val_exportSHP;
    String val_outputDir = (String) in_params.get("outputDir");
    if (val_outputDir != null) outputDir = val_outputDir;
    Boolean val_exportKML = (Boolean) in_params.get("exportKML");
    if (val_exportKML != null) exportKML = val_exportKML;
    run_DynPopCulicoides();
  }
  
  public void printOut(final String msg) {
    InputOutput.<String>println(("-->  " + msg));
    for (final SimulationListener sl : this.simlisteners) {
      sl.consoleEvent((msg + "\n"));
    }
  }
  
  private String region;
  
  public void setRegion(final String region) {
    this.region = region;
  }
  
  public String getRegion() {
    return this.region;
  }
  
  private Boolean replaceMeteoFiles;
  
  public void setReplaceMeteoFiles(final Boolean replaceMeteoFiles) {
    this.replaceMeteoFiles = replaceMeteoFiles;
  }
  
  public Boolean getReplaceMeteoFiles() {
    return this.replaceMeteoFiles;
  }
  
  private String inputDirNew;
  
  public void setInputDirNew(final String inputDirNew) {
    this.inputDirNew = inputDirNew;
  }
  
  public String getInputDirNew() {
    return this.inputDirNew;
  }
  
  private String inputDirWork;
  
  public void setInputDirWork(final String inputDirWork) {
    this.inputDirWork = inputDirWork;
  }
  
  public String getInputDirWork() {
    return this.inputDirWork;
  }
  
  private String date_debut;
  
  public void setDate_debut(final String date_debut) {
    this.date_debut = date_debut;
  }
  
  public String getDate_debut() {
    return this.date_debut;
  }
  
  private String date_fin;
  
  public void setDate_fin(final String date_fin) {
    this.date_fin = date_fin;
  }
  
  public String getDate_fin() {
    return this.date_fin;
  }
  
  private Boolean outputAllDates;
  
  public void setOutputAllDates(final Boolean outputAllDates) {
    this.outputAllDates = outputAllDates;
  }
  
  public Boolean getOutputAllDates() {
    return this.outputAllDates;
  }
  
  private Boolean outputLastDate;
  
  public void setOutputLastDate(final Boolean outputLastDate) {
    this.outputLastDate = outputLastDate;
  }
  
  public Boolean getOutputLastDate() {
    return this.outputLastDate;
  }
  
  private Boolean exportSHP;
  
  public void setExportSHP(final Boolean exportSHP) {
    this.exportSHP = exportSHP;
  }
  
  public Boolean getExportSHP() {
    return this.exportSHP;
  }
  
  private String outputDir;
  
  public void setOutputDir(final String outputDir) {
    this.outputDir = outputDir;
  }
  
  public String getOutputDir() {
    return this.outputDir;
  }
  
  private Boolean exportKML;
  
  public void setExportKML(final Boolean exportKML) {
    this.exportKML = exportKML;
  }
  
  public Boolean getExportKML() {
    return this.exportKML;
  }
}
