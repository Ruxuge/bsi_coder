package pl.pjatk.bsi_algorytmy.alg4;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import javax.swing.plaf.synth.Region;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Chart extends JFrame {

    public Chart(String name, List<TestUnit> data, boolean reliability) {
        super(name);
        setSize(800, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        XYSeriesCollection dataset = new XYSeriesCollection();
        XYSeries series = new XYSeries(name);
        if (reliability) {
            data.stream().forEach(e -> series.add(e.getTime(), e.getFailureRate()));
        } else {
            data.stream().forEach(e -> series.add(e.getTime(), e.getReliability()));
        }

        dataset.addSeries(series);

        JFreeChart chart = ChartFactory.createXYLineChart(name, "Time", name, dataset, PlotOrientation.VERTICAL, false, false, false);
        ChartPanel panel = new ChartPanel(chart);
        setContentPane(panel);
    }


}
