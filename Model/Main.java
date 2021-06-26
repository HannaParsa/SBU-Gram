package Model;

import Server.Server;
import javafx.application.Application;
import javafx.stage.Stage;
import Server.Socket;

import java.io.IOException;

public class Main extends Application {
    public static User currentUser;
    public static User toShowProfile;
    int Height = 600 , Width = 400 ;

    public static String currentUsername = "hanna";
    public static String currentPublisher ="following1";
    @Override
    public void start(Stage primaryStage) throws Exception{
        //new Thread(new Server()).start();
        PageLoader.initStage(primaryStage);
        new PageLoader().load("sample");
        Socket.connectToServer();

    }


    public static void main(String[] args) throws IOException, ClassNotFoundException {
        launch(args);
    }
    @Override
    public void stop(){
        System.out.println("program closed");
    }
}

