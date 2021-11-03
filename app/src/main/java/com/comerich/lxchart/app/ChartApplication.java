package com.comerich.lxchart.app;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ConfigurableApplicationContext;

public class ChartApplication extends Application {
    private ConfigurableApplicationContext applicationContext;

    @Override
    public void init() {
        applicationContext = new SpringApplicationBuilder(StockUiApplication.class).run();
    }

    @Override
    public void start(Stage stage) {
        applicationContext.publishEvent(new StageReadyEvent(stage));
    }

    @Override
    public void stop() {
        applicationContext.close();
        Platform.exit();
    }

    static class StageReadyEvent extends ApplicationEvent {
        StageReadyEvent(Stage stage) {
            super(stage);
        }

        Stage getStage() {
            return ((Stage) getSource());
        }
    }

    // Method called "main" here for experimental purposes.
    // But for production use you may decide to call it, "run" for example.
    // Exact name does not matter.
    static void run(String[] args)
    {
        ChartApplication.launch();
    }


}
