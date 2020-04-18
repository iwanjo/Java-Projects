package sample;

//Authors: Ziithe Ewen Hiwa and Ian Kamanu Wanjohi

//Program Overview:
//The first thing we did was create our Main class for our JavaFX application which extends
// javafx.application.Application, and override it’s start() method.


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;
public class Main extends Application {
    Stage window;
    Button myButton1;
    Button bookTaxi;
    Scene scene1, scene2, scene3, scene4, scene5;

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        //Our start method is crucial to the application We have five scenes in total in the application, and we are
        //able to switch through the different scenes. Our window is a stage, and in a stage you have different scenes.

        window = primaryStage;
        //Here we are setting the title of the GUI window.

        window.setTitle("AfroRides");
        //This is our first scene. First comes a welcome message as well as buttons, which when the user presses will take
        //them to different scenes. You can either go to the Registration Screen or the Booking Taxi button which will
        //take you to two different scenes.

        Label label1 = new Label("Welcome to AfroRides, your premium taxi solution");
        //Will take th user to the registration screen

        myButton1 = new Button("Click here to go to the registration screen");
        myButton1.setOnAction(e -> window.setScene(scene2));
        bookTaxi = new Button("Click here to Book your Taxi");
        //Here we are listening for an event. The moment that this is pressed, it will take the user to the third scene
        //where they will be able to choose their taxi type and move on.
        bookTaxi.setOnAction(e -> window.setScene(scene3));

        //Setting the layout of the GUI, as well as the order of the children elements.
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20, 20, 20, 20));
        layout.getChildren().addAll(label1, myButton1, bookTaxi);
        scene1 = new Scene(layout, 300, 400);

        //Second Scene
        //In this scene, is the registration page. The user will input their name, PIN, and location. The moment they click
        //sign up, they will be redirected to the third scene and book their taxi.
        Label label2 = new Label("Welcome to the Registration Page");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setVgap(10);
        grid.setHgap(10);
        grid.setPadding(new Insets(10));

        Label userName = new Label("Name: ");
        grid.add(userName, 0, 1);

        TextField userText = new TextField();
        userText.setPromptText("Name");
        grid.add(userText, 1, 1);

        Label userPass = new Label("PIN: ");
        grid.add(userPass, 0, 2);

        PasswordField userPin = new PasswordField();
        userPin.setPromptText("PIN");
        grid.add(userPin, 1, 2);

        Label userLocation = new Label("Location: ");
        grid.add(userLocation, 0, 3);

        TextField userResp = new TextField();
        userResp.setPromptText("Location");
        grid.add(userResp, 1, 3);

        Button registerBtn = new Button("Sign Up");
        registerBtn.setOnAction(e -> window.setScene(scene3));
        grid.add(registerBtn, 1, 4);
        //There is an option for the user to go back to the home screen if they wish to.
        Button button2 = new Button("Go Back to home screen");
        button2.setOnAction(e -> window.setScene(scene1));

        //Layout 2
        VBox layout2 = new VBox(10);
        layout2.setPadding(new Insets(20, 20, 20, 20));
        layout2.getChildren().addAll(label2, grid, button2);
        scene2 = new Scene(layout2, 300, 400);

        window.setScene(scene1);

        //Third Scene
        //Here the user will be able to book the three different types of taxi.
        Label bookingTaxi = new Label("Welcome to the Taxi Booking Screen");
        bookTaxi = new Button("Click here to choose your taxi");
        bookTaxi.setOnAction(e -> window.setScene(scene4));
        Button returnHome = new Button("Click here to go back to the home screen");
        returnHome.setOnAction(e -> window.setScene(scene1));

        ChoiceBox<String> choiceBox1 = new ChoiceBox<>();
        choiceBox1.getItems().add("Book an Executive Car");
        choiceBox1.getItems().add("Book A Group Car");
        choiceBox1.getItems().add("Book A Budget Car");
        VBox layout3 = new VBox(10);
        layout3.setPadding(new Insets(20, 20, 20, 20));
        layout3.getChildren().addAll(bookingTaxi, choiceBox1, bookTaxi, returnHome);
        scene3 = new Scene(layout3, 300, 400);


        //Fourth Scene
        //here the user will choose their current and destination locations from the dropdown.
        Label LocationChoice = new Label("Please choose your  current location from the dropdown");
        Button userLocationSelection = new Button("Confirm");
        userLocationSelection.setOnAction(e -> window.setScene(scene5));
        Button returnBack = new Button("Click here to go back to the home screen");
        returnHome.setOnAction(e -> window.setScene(scene1));

        //Available Locations come in the form of a dropdown menu.
        ChoiceBox<String> choiceBox2 = new ChoiceBox<>();
        choiceBox2.getItems().add("Kacyiru");
        choiceBox2.getItems().add("Kimironko");
        choiceBox2.getItems().add("Nyarutrarama");
        choiceBox2.getItems().add("CBD");
        choiceBox2.getItems().add("Remera");
        choiceBox2.getItems().add("Kabeza");

        Label destinationChoice = new Label("Please choose your Destination from the dropdown");
        ChoiceBox<String> choiceBox3 = new ChoiceBox<>();
        choiceBox3.getItems().add("Kacyiru");
        choiceBox3.getItems().add("Kimironko");
        choiceBox3.getItems().add("Nyarutrarama");
        choiceBox3.getItems().add("CBD");
        choiceBox3.getItems().add("Remera");
        choiceBox3.getItems().add("Kabeza");
        VBox layout4 = new VBox(10);
        layout4.setPadding(new Insets(20, 20, 20, 20));
        layout4.getChildren().addAll(LocationChoice, choiceBox2, destinationChoice, choiceBox3, userLocationSelection, returnBack);
        scene4 = new Scene(layout4, 300, 400);

        //Once the user has finished with the fourth scene, they have arrived at their destination, in this version
        //this is how we have chosen to implement it for simplicity and understanding.
        //Fifth Scene
        Label userDestination = new Label("You have arrived at your destination. Thank you for using AfroRides!");
        VBox layout5 = new VBox(10);
        layout5.setPadding(new Insets(20, 20, 20, 20));
        layout5.getChildren().addAll(userDestination);
        scene5 = new Scene(layout5, 300, 400);
        primaryStage.show();

    }

}


