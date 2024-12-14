module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires org.junit.jupiter.api; // 添加 JUnit 模块


    opens com.example.demo.controller to javafx.fxml;
    exports com.example.demo.controller;
    opens com.example.demo.Actor to javafx.fxml;
    opens com.example.demo.Plane to javafx.fxml;
    opens com.example.demo.Projectiles to javafx.fxml;
    opens com.example.demo.Levels to javafx.fxml;
    opens com.example.demo.uiux to javafx.fxml;
}