import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;


public class main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        Label label0 = new Label("*** WelCome to the LIBRARY *** \n Chosse one of the optoins below");
        HBox hBox0 = new HBox(label0);
        hBox0.setSpacing(30);
        hBox0.setAlignment(Pos.CENTER);
        label0.setStyle("-fx-font-family: 'Segoe UI Black'");
        label0.setTextFill(Color.web("#096f5b"));

        Label label1 = new Label(" Add student");
        Button button1 = new Button("Click");
        button1.setTooltip(new Tooltip("Click to add a student"));
        button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Label l1 = new Label("Enter ID");
                TextField t1 = new TextField();
                Button b1 = new Button("Click");
                b1.setOnAction(event1 -> {
                    int id;
                    id = Integer.parseInt(t1.getText());
                    System.out.println(t1.getText());
                });
                HBox h1 = new HBox(l1,t1,b1);
                h1.setSpacing(10);

                Label l2 = new Label("Enter Name");
                TextField t2 = new TextField();
                Button b2 = new Button("Click");
                b2.setOnAction(event1 -> {
                    String n;
                    n = t2.getText();
                    System.out.println(t2.getText());
                });
                HBox h2 = new HBox(l2,t2,b2);
                h2.setSpacing(10);

                Label l3 = new Label("Enter LastName");
                TextField t3 = new TextField();
                Button b3 = new Button("Click");
                b3.setOnAction(event1 -> {
                    String ln;
                    ln = t3.getText();
                    System.out.println(t3.getText());
                });
                HBox h3 = new HBox(l3,t3,b3);
                h3.setSpacing(10);

                Label l4 = new Label("Enter Grade");
                TextField t4 = new TextField();
                Button b4 = new Button("Click");
                b4.setOnAction(event1 -> {
                    float gr;
                    gr = Float.parseFloat(t4.getText());
                    System.out.println(t4.getText());
                });
                HBox h4 = new HBox(l4,t4,b4);
                h4.setSpacing(10);

                Stage newWindow = new Stage();
                VBox root = new VBox(h1,h2,h3,h4);
                root.setAlignment(Pos.CENTER);
                Scene scene = new Scene(root,370,250);
                root.setStyle("-fx-background-color: linear-gradient(from 25% 25% to 100% 100%, #90cbd5, #1c5365)");
                newWindow.setTitle("ADD STUDENT");
                newWindow.setScene(scene);
                scene.getStylesheets().add("style1.css");
                newWindow.show();
            }});
        HBox hBox1 = new HBox(label1,button1);
        hBox1.setSpacing(10);


        Label label2 = new Label(" Search student");
        Button button2 = new Button("Click");
        button2.setTooltip(new Tooltip("Click to search a student"));
        button2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Label l1 = new Label("Enter ID OR Name OR \n LastName OR Grade");
                TextField t1 = new TextField();
                Button b1 = new Button("Click");
                b1.setOnAction(event1 -> {
                    String str;
                    str = t1.getText();
                    System.out.println(t1.getText());
                });
                HBox h1 = new HBox(l1,t1,b1);
                h1.setSpacing(10);

                Stage newWindow = new Stage();
                VBox root = new VBox(h1);
                root.setAlignment(Pos.CENTER);
                Scene scene = new Scene(root,450,150);
                root.setStyle("-fx-background-color: linear-gradient(from 25% 25% to 100% 100%, #90cbd5, #1c5365)");
                newWindow.setTitle("SEARCH STUDENT");
                newWindow.setScene(scene);
                scene.getStylesheets().add("style1.css");
                newWindow.show();
            }});
        HBox hBox2 = new HBox(label2,button2);
        hBox2.setSpacing(10);

        Label label3 = new Label(" Edit student");
        Button button3 = new Button("Click");
        button3.setTooltip(new Tooltip("Click to edit a student"));
        button3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Label l1 = new Label("Enter New ID");
                TextField t1 = new TextField();
                Button b1 = new Button("Click");
                b1.setOnAction(event1 -> {
                    int id;
                    id = Integer.parseInt(t1.getText());
                    System.out.println(t1.getText());
                });
                HBox h1 = new HBox(l1,t1,b1);
                h1.setSpacing(10);

                Label l2 = new Label("Enter New Name");
                TextField t2 = new TextField();
                Button b2 = new Button("Click");
                b2.setOnAction(event1 -> {
                    String n;
                    n = t2.getText();
                    System.out.println(t2.getText());
                });
                HBox h2 = new HBox(l2,t2,b2);
                h2.setSpacing(10);

                Label l3 = new Label("Enter New LastName");
                TextField t3 = new TextField();
                Button b3 = new Button("Click");
                b3.setOnAction(event1 -> {
                    String ln;
                    ln = t3.getText();
                    System.out.println(t3.getText());
                });
                HBox h3 = new HBox(l3,t3,b3);
                h3.setSpacing(10);

                Label l4 = new Label("Enter New Grade");
                TextField t4 = new TextField();
                Button b4 = new Button("Click");
                b1.setOnAction(event1 -> {
                    float gr;
                    gr = Float.parseFloat(t4.getText());
                    System.out.println(t4.getText());
                });
                HBox h4 = new HBox(l4,t4,b4);
                h4.setSpacing(10);

                Stage newWindow = new Stage();
                VBox root = new VBox(h1,h2,h3,h4);
                root.setAlignment(Pos.CENTER);
                Scene scene = new Scene(root,450,250);
                root.setStyle("-fx-background-color: linear-gradient(from 25% 25% to 100% 100%, #90cbd5, #1c5365)");
                newWindow.setTitle("EDIT STUDENT");
                newWindow.setScene(scene);
                scene.getStylesheets().add("style1.css");
                newWindow.show();
            }});
        HBox hBox3 = new HBox(label3,button3);
        hBox3.setSpacing(10);

        Label label4 = new Label(" Add book");
        Button button4 = new Button("Click");
        button4.setTooltip(new Tooltip("Click to add a book"));
        button4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Label l1 = new Label("Enter ID");
                TextField t1 = new TextField();
                Button b1 = new Button("Click");
                b1.setOnAction(event1 -> {
                    int id;
                    id = Integer.parseInt(t1.getText());
                    System.out.println(t1.getText());
                });
                HBox h1 = new HBox(l1,t1,b1);
                h1.setSpacing(10);

                Label l2 = new Label("Enter Book Name");
                TextField t2 = new TextField();
                Button b2 = new Button("Click");
                b2.setOnAction(event1 -> {
                    String n;
                    n = t2.getText();
                    System.out.println(t2.getText());
                });
                HBox h2 = new HBox(l2,t2,b2);
                h2.setSpacing(10);

                Label l3 = new Label("Enter Writer Name");
                TextField t3 = new TextField();
                Button b3 = new Button("Click");
                b3.setOnAction(event1 -> {
                    String wn;
                    wn = t3.getText();
                    System.out.println(t3.getText());
                });
                HBox h3 = new HBox(l3,t3,b3);
                h3.setSpacing(10);

                Label l4 = new Label("Enter Eddition");
                TextField t4 = new TextField();
                Button b4 = new Button("Click");
                b4.setOnAction(event1 -> {
                    int ed;
                    ed = Integer.parseInt(t4.getText());
                    System.out.println(t4.getText());
                });
                HBox h4 = new HBox(l4,t4,b4);
                h4.setSpacing(10);

                Stage newWindow = new Stage();
                VBox root = new VBox(h1,h2,h3,h4);
                root.setAlignment(Pos.CENTER);
                Scene scene = new Scene(root,400,250);
                root.setStyle("-fx-background-color: linear-gradient(from 25% 25% to 100% 100%, #90cbd5, #1c5365)");
                newWindow.setTitle("ADD BOOKS");
                newWindow.setScene(scene);
                scene.getStylesheets().add("style1.css");
                newWindow.show();
            }
        });
        HBox hBox4 = new HBox(label4,button4);
        hBox4.setSpacing(10);

        Label label5 = new Label(" Search book");
        Button button5 = new Button("Click");
        button5.setTooltip(new Tooltip("Click to search a book"));
        button5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Label l1 = new Label("Enter ID OR Name OR \nWriter OR Edition:");
                TextField t1 = new TextField();
                Button b1 = new Button("Click");
                b1.setOnAction(event1 -> {
                    String str;
                    str = t1.getText();
                    System.out.println(t1.getText());
                });
                HBox h1 = new HBox(l1,t1,b1);
                h1.setSpacing(10);

                Stage newWindow = new Stage();
                VBox root = new VBox(h1);
                root.setAlignment(Pos.CENTER);
                Scene scene = new Scene(root,450,150);
                root.setStyle("-fx-background-color: linear-gradient(from 25% 25% to 100% 100%, #90cbd5, #1c5365)");
                newWindow.setTitle("SEARCH BOOKS");
                newWindow.setScene(scene);
                scene.getStylesheets().add("style1.css");
                newWindow.show();
            }});
        HBox hBox5 = new HBox(label5,button5);
        hBox5.setSpacing(10);

        Label label6 = new Label(" Edit book");
        Button button6 = new Button("Click");
        button6.setTooltip(new Tooltip("Click to edit a book"));
        button6.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Label l1 = new Label("Enter New ID");
                TextField t1 = new TextField();
                Button b1 = new Button("Click");
                b1.setOnAction(event1 -> {
                    int id;
                    id = Integer.parseInt(t1.getText());
                    System.out.println(t1.getText());
                });
                HBox h1 = new HBox(l1,t1,b1);
                h1.setSpacing(10);

                Label l2 = new Label("Enter New Name");
                TextField t2 = new TextField();
                Button b2 = new Button("Click");
                b2.setOnAction(event1 -> {
                    String n;
                    n = t2.getText();
                    System.out.println(t2.getText());
                });
                HBox h2 = new HBox(l2,t2,b2);
                h2.setSpacing(10);

                Label l3 = new Label("Enter New Writer Name");
                TextField t3 = new TextField();
                Button b3 = new Button("Click");
                b3.setOnAction(event1 -> {
                    String wn;
                    wn = t3.getText();
                    System.out.println(t3.getText());
                });
                HBox h3 = new HBox(l3,t3,b3);
                h3.setSpacing(10);

                Label l4 = new Label("Enter New Edition");
                TextField t4 = new TextField();
                Button b4 = new Button("Click");
                b1.setOnAction(event1 -> {
                    int ed;
                    ed = Integer.parseInt(t4.getText());
                    System.out.println(t4.getText());
                });
                HBox h4 = new HBox(l4,t4,b4);
                h4.setSpacing(10);

                Stage newWindow = new Stage();
                VBox root = new VBox(h1,h2,h3,h4);
                root.setAlignment(Pos.CENTER);
                Scene scene = new Scene(root,450,250);
                root.setStyle("-fx-background-color: linear-gradient(from 25% 25% to 100% 100%, #90cbd5, #1c5365)");
                newWindow.setTitle("EDIT BOOKS");
                newWindow.setScene(scene);
                scene.getStylesheets().add("style1.css");
                newWindow.show();
            }});
        HBox hBox6 = new HBox(label6,button6);
        hBox6.setSpacing(10);

        Label label7 = new Label(" Borrowing book");
        Button button7 = new Button("Click");
        button7.setTooltip(new Tooltip("Click to borrow a book"));
        button7.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Label l1 = new Label("Enter Student ID");
                TextField t1 = new TextField();
                Button b1 = new Button("Click");
                b1.setOnAction(event1 -> {
                    String sid;
                    sid = t1.getText();
                    System.out.println(t1.getText());
                });
                HBox h1 = new HBox(l1,t1,b1);
                h1.setSpacing(10);

                Label l2 = new Label("Enter Book Name");
                TextField t2 = new TextField();
                Button b2 = new Button("Click");
                b2.setOnAction(event1 -> {
                    String bid;
                    bid = t2.getText();
                    System.out.println(t2.getText());
                });
                HBox h2 = new HBox(l2,t2,b2);
                h2.setSpacing(10);

                Stage newWindow = new Stage();
                VBox root = new VBox(h1,h2);
                root.setAlignment(Pos.CENTER);
                Scene scene = new Scene(root,400,250);
                root.setStyle("-fx-background-color: linear-gradient(from 25% 25% to 100% 100%, #90cbd5, #1c5365)");
                newWindow.setTitle("BOROWING BOOKS");
                newWindow.setScene(scene);
                scene.getStylesheets().add("style1.css");
                newWindow.show();
            }});
        HBox hBox7 = new HBox(label7,button7);
        hBox7.setSpacing(10);

        Label label8 = new Label(" Search borrowing book record");
        Button button8 = new Button("Click");
        button8.setTooltip(new Tooltip("Click to search borrowing book record"));
        button8.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            Label l1 = new Label("Enter Student OR Book ID");
            TextField t1 = new TextField();
            Button b1 = new Button("Click");
            b1.setOnAction(event1 -> {
                String str;
                str = t1.getText();
                System.out.println(t1.getText());
            });
            HBox h1 = new HBox(l1,t1,b1);
            h1.setSpacing(10);

            Stage newWindow = new Stage();
            VBox root = new VBox(h1);
            root.setAlignment(Pos.CENTER);
            Scene scene = new Scene(root,500,150);
            root.setStyle("-fx-background-color: linear-gradient(from 25% 25% to 100% 100%, #90cbd5, #1c5365)");
            newWindow.setTitle("SEARCH BOROWING BOOKS");
            newWindow.setScene(scene);
            scene.getStylesheets().add("style1.css");
            newWindow.show();
        }});
        HBox hBox8 = new HBox(label8,button8);
        hBox8.setSpacing(10);

        Label label9 = new Label(" Print all student");
        Button button9 = new Button("Click");
        button9.setTooltip(new Tooltip("Click to see all students"));
        button9.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Label l1 = new Label("*** PRINTING ALL STUDENTS ***");
                HBox h1 = new HBox(l1);
                h1.setSpacing(10);
                h1.setAlignment(Pos.CENTER);

                Stage newWindow = new Stage();
                VBox root = new VBox(h1);
                root.setAlignment(Pos.CENTER);
                Scene scene = new Scene(root,400,200);
                root.setStyle("-fx-background-color: linear-gradient(from 25% 25% to 100% 100%, #90cbd5, #1c5365)");
                newWindow.setTitle("PRINTING ALL STUDENTS");
                newWindow.setScene(scene);
                scene.getStylesheets().add("style1.css");
                newWindow.show();
            }});
        HBox hBox9 = new HBox(label9,button9);
        hBox9.setSpacing(10);

        Label label10 = new Label(" Print all book");
        Button button10 = new Button("Click");
        button10.setTooltip(new Tooltip("Click to see all books"));
        button10.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Label l1 = new Label("*** PRINTING ALL BOOKS ***");
                HBox h1 = new HBox(l1);
                h1.setSpacing(10);
                h1.setAlignment(Pos.CENTER);

                Stage newWindow = new Stage();
                VBox root = new VBox(h1);
                root.setAlignment(Pos.CENTER);
                Scene scene = new Scene(root,400,200);
                root.setStyle("-fx-background-color: linear-gradient(from 25% 25% to 100% 100%, #90cbd5, #1c5365)");
                newWindow.setTitle("PRINTING ALL BOOKS");
                newWindow.setScene(scene);
                scene.getStylesheets().add("style1.css");
                newWindow.show();
            }});
        HBox hBox10 = new HBox(label10,button10);
        hBox10.setSpacing(10);

        Label label11 = new Label(" Print all borrowing record");
        Button button11 = new Button("Click");
        button11.setTooltip(new Tooltip("Click to see all borrowing records"));
        button11.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Label l1 = new Label("*** PRINTING ALL BOROWING RECORDS ***");
                HBox h1 = new HBox(l1);
                h1.setSpacing(10);
                h1.setAlignment(Pos.CENTER);

                Stage newWindow = new Stage();
                VBox root = new VBox(h1);
                root.setAlignment(Pos.CENTER);
                Scene scene = new Scene(root,450,200);
                root.setStyle("-fx-background-color: linear-gradient(from 25% 25% to 100% 100%, #90cbd5, #1c5365)");
                newWindow.setTitle("PRINTING ALL BOROWING RECORDS");
                newWindow.setScene(scene);
                scene.getStylesheets().add("style1.css");
                newWindow.show();
            }});
        HBox hBox11 = new HBox(label11,button11);
        hBox11.setSpacing(10);

        VBox root = new VBox(hBox0,hBox1,hBox2,hBox3,hBox4,hBox5,hBox6,hBox7,hBox8,hBox9,hBox10,hBox11);
        Scene scene = new Scene(root,500,530);
        root.setSpacing(10);
        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-background-color: linear-gradient(from 25% 25% to 100% 100%, #90cbd5, #1c5365)");
        primaryStage.setScene(scene);
        scene.getStylesheets().add("style.css");
        primaryStage.setTitle("LIBRARY");
        primaryStage.show();
    }


}
