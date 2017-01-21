package sample.controller;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.FileChooser;
import sample.model.*;

import java.io.File;
import java.io.IOException;

public class Controller {
    private File selectedFile;
    private ImageChanger imageChanger;

    @FXML
    private Pane canvas;

    @FXML
    public void initialize(){
        FileHandler handler = new FileHandler();
        imageChanger = new ImageChanger();
        imageChanger.setFileHandler(handler);
    }

    public void chooseFile(){
        configureFileChooser();
        if(selectedFile != null)
            showImage(selectedFile.getAbsolutePath());
    }

    private void configureFileChooser(){
        selectedFile = null;
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Otwórz Plik");
        selectedFile = fileChooser.showOpenDialog(null);
    }

    private void showImage(String path){
        String url = "file:///" + path;
        Image img = new Image(url);
        BackgroundImage bgImg = new BackgroundImage(img,
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false));
        canvas.setBackground(new Background(bgImg));
    }

    public void changeToSepia(){
        if(selectedFile != null) {
            imageChanger.setPixelChanger(new Sepia());
            String input = selectedFile.getAbsolutePath();
            String output = FileNameCreator.createFileName(input, "sepia");

            try {
                imageChanger.convertImage(input, output);
                showImage(output);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else
            System.out.println("Please, choose the image");
    }

    public void changeToNegative(){
        if(selectedFile != null) {
            imageChanger.setPixelChanger(new Negative());
            String input = selectedFile.getAbsolutePath();
            String output = FileNameCreator.createFileName(input, "negative");
            try {
                imageChanger.convertImage(input, output);
                showImage(output);
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
        else
            System.out.println("Please, choose the image");
    }

    public void changeToOriginal(){
        if(selectedFile != null)
            showImage(selectedFile.getAbsolutePath());
        else
            System.out.println("Please choose the image");
    }

    public void clearCanvas(){
        canvas.setBackground(null);
        selectedFile = null;
    }

}
