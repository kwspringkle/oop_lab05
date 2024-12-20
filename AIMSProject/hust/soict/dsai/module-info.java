/**
 *
 */
/**
 *
 */
module AIMSProject {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;
    requires java.desktop;
    requires javafx.swing;
    exports hust.soict.dsai.aims.javafx to javafx.graphics;
//
//    exports javaf.painter to javafx.graphics;
//    opens javaf.painter to javafx.fxml;

//    exports aims.screen;
    opens hust.soict.dsai.aims.aims.screen to javafx.fxml;
    opens hust.soict.dsai.aims.aims.media to javafx.base;
}   