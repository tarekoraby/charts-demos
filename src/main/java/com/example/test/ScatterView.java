package com.example.test;

import com.vaadin.flow.component.charts.Chart;
import com.vaadin.flow.component.charts.model.ChartType;
import com.vaadin.flow.component.charts.model.Configuration;
import com.vaadin.flow.component.charts.model.DataSeries;
import com.vaadin.flow.component.charts.model.DataSeriesItem;
import com.vaadin.flow.component.charts.model.Dimension;
import com.vaadin.flow.component.charts.model.PlotOptionsScatter;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("ScatterView")
public class ScatterView extends VerticalLayout {

    public ScatterView() {
        Chart chart = new Chart(ChartType.SCATTER);

        // Modify the default configuration a bit
        Configuration conf = chart.getConfiguration();
        conf.setTitle("Random Sphere");
        conf.getLegend().setEnabled(false); // Disable legend
        conf.getxAxis().setTitle("X");
        conf.getyAxis().setTitle("Y");
        conf.getxAxis().setMax(1);
        conf.getxAxis().setMin(-1);
        conf.getyAxis().setMax(1);
        conf.getyAxis().setMin(-1);

        PlotOptionsScatter options = new PlotOptionsScatter();
        // ... Give overall plot options here ...
        conf.setPlotOptions(options);

        DataSeries series = new DataSeries();
        for (int i = 0; i < 300; i++) {
            double lng = Math.random() * 2 * Math.PI;
            double lat = (Math.random() * Math.PI) - (Math.PI / 2);
            double x = Math.cos(lat) * Math.sin(lng);
            double y = Math.sin(lat);

            DataSeriesItem point = new DataSeriesItem(x, y);
            series.add(point);
        }
        conf.addSeries(series);

        conf.getChart().setZoomType(Dimension.XY);

        add(chart);
    }
}
