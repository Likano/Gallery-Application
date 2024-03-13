package com.example.assignment1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        // grid of thumbnails
        GridPane root = new GridPane();

        // Another layout
        Pane pane = new Pane();
        Stage stage1 = new Stage();
        Scene scene1 = new Scene(pane);
        stage1.setScene(scene1);
        stage.show();

        // An array of paths
        String[] paths = {
                "src/main/resources/com/example/assignment1/image1.jpeg",
                "src/main/resources/com/example/assignment1/image2.jpeg",
                "src/main/resources/com/example/assignment1/image3.jpeg",
                "src/main/resources/com/example/assignment1/image4.jpeg",
                "src/main/resources/com/example/assignment1/image5.jpeg",
                "src/main/resources/com/example/assignment1/image6.jpeg"
        };

        // fileInputStream dynamic way
        FileInputStream[] urls = new FileInputStream[6];
        for (int i=0; i<paths.length; i++){
            // assigning urls to the InputFileStream
            urls[i] = new FileInputStream(paths[i]);
        }

        // Loading multiple images dynamically way
        Image[] image = new Image[6];
        for (int i=0; i<urls.length; i++){
            // assigning urls to an image
            image[i] = new Image(urls[i]);

        }

        // displaying multiple imageview dynamically
        ImageView[] imageview = new ImageView[6];
        // assigning image paths
        for (int i=0; i<paths.length; i++)
        {
            imageview[i] = new ImageView(image[i]);
            // properties of imageview
            imageview[i].setX(10);
            imageview[i].setY(10);
            imageview[i].setFitWidth(160);
            imageview[i].setFitHeight(160);
            imageview[i].setPreserveRatio(true);

            // to make image view respond to mouseclick
            imageview[i].setPickOnBounds(true);

            imageview[i].setOnMouseClicked(event -> stage1.setScene(scene1));
        }
        // Gridpane properties rows and columns
        root.addRow(0,imageview[0],imageview[1],imageview[2]);
        root.addRow(1,imageview[3],imageview[4],imageview[5]);

        Scene scene = new Scene(root, 550,400);

        // linking stylesheet
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        stage.setTitle("Gallery Application");
        stage.setScene(scene);
        stage.show();
    }

    // creating a image view for full screen view
    private ImageView forFullScreen(String urls){
        Image img = new Image(getClass().getResourceAsStream(urls));
        ImageView imageViews = new ImageView(img);
        imageViews.setFitHeight(550);
        imageViews.setFitWidth(400);
        return imageViews;
    }

    // stage for fullscreen
    private void  fullSize(String url){
        Stage fullSize = new Stage();
        Image pic = new Image(getClass().getResourceAsStream(url));
        ImageView View = new ImageView(pic);

        Pane pane = new Pane(View);
        Scene scene = new Scene(pane);
        fullSize.setScene(scene);
        fullSize.setTitle("Full Screen");
        fullSize.show();
    }

    public static void main(String[] args) {
        launch();
    }
}