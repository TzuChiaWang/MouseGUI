package com.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class MouseGUI extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane root = new Pane();

        // 設置背景顏色
        Rectangle background = new Rectangle(1000, 800, Color.WHITESMOKE);
        root.getChildren().add(background);

        // 加載圖片
        Image image = new Image("file:src/main/resources/com/example/NTUST.png");
        ImageView imageView = new ImageView(image);

        // 設置圖片初始位置
        imageView.setX(250);
        imageView.setY(250);

         // 縮小圖片
         imageView.setFitWidth(500);
         imageView.setFitHeight(500);
         imageView.setPreserveRatio(true);

        // 添加滑鼠拖動事件
        imageView.setOnMousePressed(event -> {
            imageView.setUserData(
                    new double[] { event.getSceneX(), event.getSceneY(), imageView.getX(), imageView.getY() });
        });

        imageView.setOnMouseDragged(event -> {
            double[] data = (double[]) imageView.getUserData();
            double deltaX = event.getSceneX() - data[0];
            double deltaY = event.getSceneY() - data[1];
            imageView.setX(data[2] + deltaX);
            imageView.setY(data[3] + deltaY);
        });

        root.getChildren().add(imageView);

        Scene scene = new Scene(root, 1000, 800);
        primaryStage.setScene(scene);
        primaryStage.setTitle("NTUST Mouse GUI");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}