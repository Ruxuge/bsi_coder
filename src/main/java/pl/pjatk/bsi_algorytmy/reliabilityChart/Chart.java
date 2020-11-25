package pl.pjatk.bsi_algorytmy.reliabilityChart;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.util.List;

public class Chart extends JFrame {

    public Chart(String name, XYSeries series) {
        super(name);
        prepareWindow();
        setContentPane(prepareChart(name, series));
    }

    private void prepareWindow() {
        setSize(800, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private ChartPanel prepareChart(String name, XYSeries series) {
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series);
        JFreeChart chart = ChartFactory.createXYLineChart(name, "Time", name, dataset, PlotOrientation.VERTICAL, false, false, false);
        ChartPanel panel = new ChartPanel(chart);
        return panel;
    }

}
