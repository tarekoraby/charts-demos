package com.example.test;

import com.vaadin.flow.component.charts.Chart;
import com.vaadin.flow.component.charts.model.ChartType;
import com.vaadin.flow.component.charts.model.Configuration;
import com.vaadin.flow.component.charts.model.DataSeries;
import com.vaadin.flow.component.charts.model.DataSeriesItem;
import com.vaadin.flow.component.charts.model.PlotOptionsBar;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("BarChartView")
public class BarChartView extends VerticalLayout {

    public BarChartView() {
        Chart chart = new Chart(ChartType.BAR);

        Configuration conf = chart.getConfiguration();
        PlotOptionsBar options = new PlotOptionsBar();
        conf.setPlotOptions(options);



        DataSeries series = new DataSeries();
        for (int i = 0; i < 5; i++) {
            double x = i;
            double y = i;

            DataSeriesItem point = new DataSeriesItem(x, (y * y) + 1);
            series.add(point);
        }
        conf.addSeries(series);

        add(chart);
    }
}
