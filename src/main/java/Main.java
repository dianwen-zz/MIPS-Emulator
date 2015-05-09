package main.java;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import main.java.exceptions.InstructionNotReadyException;
import main.java.exceptions.InstructionsCouldNotBeLoadedException;
import main.java.exceptions.InvalidRegisterAccessException;
import main.java.exceptions.InvalidRegisterWriteException;

import java.io.File;

/**
 * Created by dianwen on 5/8/15.
 */
public class Main extends Application {
    Emulator emulator;

    public static void main(String[] args) {
        Application.launch(args);
    }

    private void startEmulation(File file) throws InstructionsCouldNotBeLoadedException {
        emulator = new Emulator(file);
        emulator.readyInstructions();
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Choose file");

        final FileChooser fileChooser = new FileChooser();

        final Button openButton = new Button("Open a file");
        final Button runButton = new Button("Step");

        openButton.setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(final ActionEvent e) {
                        configureFileChooser(fileChooser);
                        File file = fileChooser.showOpenDialog(stage);
                        if (file != null) {
                            try {
                                startEmulation(file);
                            } catch (InstructionsCouldNotBeLoadedException e1) {
                                e1.printStackTrace();
                            }
                        }
                    }
                });

        runButton.setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(final ActionEvent e) {
                        try {
                            if(emulator.executeInstruction()) {
                                System.out.println(emulator.getState());
                            }
                            else {
                                System.out.println("done");
                            }
                        } catch (Exception e1) {
                            e1.printStackTrace();
                        }
                    }
                });

        final GridPane inputGridPane = new GridPane();

        GridPane.setConstraints(openButton, 0, 0);
        GridPane.setConstraints(runButton, 0, 1);

        inputGridPane.setHgap(6);
        inputGridPane.setVgap(6);
        inputGridPane.getChildren().addAll(openButton, runButton);

        final Pane rootGroup = new VBox(12);
        rootGroup.getChildren().addAll(inputGridPane);
        rootGroup.setPadding(new Insets(12, 12, 12, 12));

        stage.setScene(new Scene(rootGroup));
        stage.show();
    }

    private static void configureFileChooser(final FileChooser fileChooser) {
        fileChooser.setTitle("View file");
        fileChooser.setInitialDirectory(
                new File(System.getProperty("user.dir"))
        );
    }

}
