import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.Database;
import view.Page;
import view.View;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Homework Folder Manager");
        primaryStage.setHeight(600);
        primaryStage.setWidth(800);
        Scene scene = new Scene(new Pane());
        primaryStage.setScene(scene);
        View.setScene(scene);
        View.switchPage(Page.USER_SELECTION);
        primaryStage.show();
    }

    public static void main(String[] args) {
        if (Database.isValid() || Database.open()) {
            launch(args);
            Database.close();
        } else {
            System.err.println("Echec de l'ouverture de la base de données");
        }
    }
}
