/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import ejb.negocio.BubbleServiceLocal;
import entidades.Chart;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.SessionScoped;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BubbleChartModel;
import org.primefaces.model.chart.BubbleChartSeries;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LineChartModel;

/**
 *
 * @author Wayo Sapiens
 */
@Named(value = "bubbleController")
@SessionScoped
public class BubbleController implements Serializable {
//1.Atributos
    private List<Chart> lstChart=null;
    private List<Chart> lstIngresos=null;
    private Integer idChart = null;
    private LineChartModel lineModel2;
    private BubbleChartModel bubbleModel;
    private Chart chartmodel=null;
    private Integer ingreso=0;
    private List<Integer> listita = new ArrayList<Integer>();
    //2.EJB's
    @EJB
    private BubbleServiceLocal chartService;
    /**
     * Creates a new instance of BubbleController
     */
    public BubbleController() {
        createLineModels();
        createBubbleModels();
    }
    
    public LineChartModel getLineModel2() {
        return lineModel2;
    }
    
    public BubbleChartModel getBubbleModel() {
        return bubbleModel;
    }
    
    public String recuperarDatos(){
        //chartmodel= chartService.buscarSeleccionado(idChart);
        //setIngreso(chartmodel.getIngresos());           
        for (int i = 1; i <= lstChart.size(); i++) { //size es 13
            chartmodel= chartService.buscarSeleccionado(i);
            ingreso = chartmodel.getIngresos();
            listita.add(ingreso);
            System.out.println("wayoteo"+chartmodel.getIngresos());
            //System.out.println("ezwayoteo"+arregloIng[i]);
            System.out.println("ezwayoteo"+listita.get(i-1));
        }
        System.out.println("ing"+ingreso);
        createLineModels();
        createBubbleModels();
        return "oko";
    }
    
    private void createLineModels() { 
        lineModel2 = initCategoryModel();
        lineModel2.setTitle("Gráfico de categorías");
        lineModel2.setLegendPosition("e");
        lineModel2.setShowPointLabels(true);
        lineModel2.getAxes().put(AxisType.X, new CategoryAxis("Tipo de ingreso"));
        Axis yAxis = lineModel2.getAxis(AxisType.Y);
        yAxis.setLabel("Ingresos");
        yAxis.setMin(0);
        yAxis.setMax(2990);
    }
    
    private void createBubbleModels(){
        bubbleModel = initBubbleModel();
        bubbleModel.setTitle("Gráfico Burbuje - Bubble Chart");
        bubbleModel.getAxis(AxisType.X).setLabel("Egresos");
        Axis yAxis = bubbleModel.getAxis(AxisType.Y);
        yAxis.setMin(0);
        yAxis.setMax(2390);
        yAxis.setLabel("Ingresos");
    }
      
    private LineChartModel initCategoryModel() {
        LineChartModel model = new LineChartModel();
        ChartSeries datos = new ChartSeries();
        datos.setLabel("Ingresos");
        System.out.println("ingreso a linechartmodel");        
        System.out.println("ingreso:"+ingreso);

        if(!listita.isEmpty()){
            for (int i = 1; i < lstChart.size()+1; i++) {       
                ingreso = listita.get(i-1);
                datos.set("Ingreso"+i,ingreso);           
            }
        }

        model.addSeries(datos);
        ChartSeries otros = new ChartSeries();
        otros.setLabel("Egresos");
        if(!listita.isEmpty()){
            for (int i = 1; i < lstChart.size()+1; i++) {       
                ingreso = listita.get(i-1);
                otros.set("Egreso"+i,ingreso-232);           
            }
        } 
        model.addSeries(otros);
        return model;
    }
    
    private BubbleChartModel initBubbleModel(){
        BubbleChartModel model = new BubbleChartModel();
        if(!listita.isEmpty()){
            for (int i = 1; i <= lstChart.size(); i++) {       
                ingreso = listita.get(i-1);
                model.add(new BubbleChartSeries("Datos"+i, ingreso-999, ingreso-700,ingreso-590));         
            }
        } 
        
        /*
        model.add(new BubbleChartSeries("Alfa Romeo", 45, 92, 36));
        model.add(new BubbleChartSeries("AM General", 24, 104, 40));
        model.add(new BubbleChartSeries("Bugatti", 50, 123, 60));
        model.add(new BubbleChartSeries("BMW", 15, 89, 25));
        model.add(new BubbleChartSeries("Audi", 40, 180, 80));
        model.add(new BubbleChartSeries("Aston Martin", 70, 70, 48));
        */
        return model;
    }
    //4.Get y Set
    public List<Chart> getLstChart() {
        lstChart = chartService.listadoChart();
        return lstChart;
    }
   
    public void setLstChart(List<Chart> lstChart) {
        this.lstChart = lstChart;
    }

    public Integer getIdChart() {
        return idChart;
    }

    public void setIdChart(Integer idChart) {
        this.idChart = idChart;
    }
    
    public List<Chart> getLstIngresos() {
        lstIngresos = chartService.listadoIngresos();
        return lstIngresos;
    }

    public void setLstIngresos(List<Chart> lstIngresos) {
        this.lstIngresos = lstIngresos;
    }
    public List<Integer> getListita() {
        return listita;
    }

    public void setListita(List<Integer> listita) {
        this.listita = listita;
    }

    public Integer getIngreso() {
        return ingreso;
    }

    public void setIngreso(Integer ingreso) {
        this.ingreso = ingreso;
    }
    
    public Chart getChartmodel() {
        return chartmodel;
    }

    public void setChartmodel(Chart chartmodel) {
        this.chartmodel = chartmodel;
    }
}
