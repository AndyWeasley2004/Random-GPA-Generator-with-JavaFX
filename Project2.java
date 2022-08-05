package day;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.jar.Attributes.Name;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Tooltip;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;


class Student{
	String name;
	String password;
	double GPA;
	
	public double getGPA() {
		return GPA;
	}
	public void setGPA(double GPA) {
		this.GPA = GPA;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Student() {
		
	}
	public Student(String name, String password) {
		this.name = name;
		this.password = password;
	}

public static String gpaGenerator() {
	boolean judge = true;
	String gPA = new String();
	while(judge) {
		double score = (4-3+1)*Math.random()+3;
			if(score > 4) {
				continue;
			}else {
		DecimalFormat sec = new DecimalFormat(".00");
		gPA = sec.format(score);
		judge = false;
		}
	  }
	return gPA;
}
	
}
	
class ErrorWindow{
	private final Stage errorPage = new Stage();
	
	public ErrorWindow() {
		BorderPane bp2 = new BorderPane();
		Label warn = new Label("Your Username or Password is Wrong!");
		warn.setFont(Font.font(16));
		warn.setTextFill(Color.RED);
		Button close = new Button("OK");
		bp2.setCenter(warn);
		bp2.setBottom(close);
		BorderPane.setAlignment(close, Pos.CENTER);
		BorderPane.setMargin(warn, new Insets(15, 0, 0, 0));
		BorderPane.setMargin(close, new Insets(0, 0, 30, 0));
		close.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				errorPage.close();
			}
		});
		Scene scene = new Scene(bp2);
		errorPage.setScene(scene);
		errorPage.setTitle("Attention");
		errorPage.setHeight(150);
		errorPage.setWidth(300);
		errorPage.setResizable(false);
		errorPage.initModality(Modality.APPLICATION_MODAL);
		errorPage.show();

	}
}


public class Project2 extends Application{
	Student Allison = new Student("Allison","12345");
	Student Amber = new Student("Amber","27314");
	Student Andy = new Student("Andy","27314");
	Student Anthony = new Student("Anthony","27314");
	Student Cassiel = new Student("Cassiel","27314");
	Student Darrius = new Student("Darrius","27314");
	Student Healer = new Student("Healer","98765");
	Student Ivy = new Student("Ivy","27314");
	Student Jerry = new Student("Jerry","27314");
	Student Linn = new Student("Linn","27314");
	Student Lisa = new Student("Lisa","27314");
	Student Leo = new Student("Leo","27314");
	Student Leona = new Student("Leona","27314");
	Student Luke = new Student("Luke","12345");
	Student Michael = new Student("Michael","12345");
	Student Ray = new Student("Ray","12345");
	
			ComboBox<String> Name = new ComboBox<>();
			
			Student[] nameList = new Student[]{null,Allison,Amber,Andy,Anthony,Cassiel,Darrius,Healer,Ivy,
					Jerry,Linn,Lisa,Leo,Leona,Luke,Michael,Ray};
			
			String[] boxContent = new String[] {"","Allison","Amber","Andy","Anthony","Cassiel",
					"Darrius","Healer","Ivy","Jerry","Linn","Lisa","Leo","Leona",
					"Luke","Michael","Ray"};		

	public static void main(String[] args) {
		
		launch(args);
	}


	@Override
	public void start(Stage stage) throws Exception {
		Name.setVisibleRowCount(16);
		Name.getItems().addAll(boxContent);
		
		Button clear = new Button("Clear");
		Button login = new Button("Log in");
		Text title = new Text("Student Management Login");
		title.setFont(Font.font(18));
		Label l_Name = new Label("Name:   ");
		l_Name.setFont(Font.font(16));
		Label l_Password = new Label("Password:   ");
		l_Password.setFont(Font.font(16));
//		TextField t_userName = new TextField();
		Name.setTooltip(new Tooltip("Please select your name"));
		PasswordField t_Password = new PasswordField();
		t_Password.setTooltip(new Tooltip("Please enter your password"));

		GridPane gp = new GridPane();
		BorderPane bp = new BorderPane();
		bp.setCenter(gp);
		bp.setTop(title);
		BorderPane.setAlignment(title, Pos.CENTER);
		BorderPane.setMargin(title, new Insets(25, 0, 0, 0));
		gp.setStyle("-fx-background-color: #F0FFFF");
		bp.setStyle("-fx-background-color: #F0FFFF");
		gp.setAlignment(Pos.CENTER);
		gp.add(l_Name, 0, 1);
		gp.add(Name, 1, 1);//第一列第零行，不是像素点了，gridpane是网格布局
		gp.add(l_Password, 0, 2);
		gp.add(t_Password, 1, 2);
		gp.setHgap(20);
		gp.setVgap(15);
		gp.add(clear, 0, 3);
		gp.add(login, 1, 3);
		gp.setHgap(20);
		gp.setVgap(15);
		GridPane.setMargin(login, new Insets(0, 0, 0, 100));
		GridPane.setMargin(clear, new Insets(0, 0, 0, 30));
		Scene s1 = new Scene(bp);

		
		KeyCombination kc = new KeyCodeCombination(KeyCode.ENTER, KeyCombination.CONTROL_ANY);
		s1.getAccelerators().put(kc, new Runnable() {
			
			@Override
			public void run() {
				login.fire();				
			}
		});
		
		KeyCombination kc1 = new KeyCodeCombination(KeyCode.W,KeyCombination.CONTROL_DOWN);
		s1.getAccelerators().put(kc1, new Runnable() {
			
			@Override
			public void run() {
				stage.close();				
			}
		});
		stage.setScene(s1);
		stage.setTitle("MVI 12-2 Student");
		stage.setHeight(260);
		stage.setWidth(500);
		stage.setResizable(false);
				stage.show();	
				
				clear.setOnAction(new EventHandler<ActionEvent>() {
					
					@Override
					public void handle(ActionEvent event) {
						Name.getSelectionModel().selectFirst();
						t_Password.setText("");
						l_Name.setTextFill(Color.BLACK);
						l_Password.setTextFill(Color.BLACK);
					}
				});
				
				login.setOnAction(new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent event) {
						String password = (String) t_Password.getText();
						String temp = Name.getValue();
					    int i = Arrays.binarySearch(boxContent, temp);
						String verify = nameList[i].getPassword();
						
							if(password.equals(verify)) {
								Stage Home = new Stage();
								VBox word = new VBox();
								word.setStyle("-fx-background-color: #FFC0CB");

								Text infor = new Text("Name:    "+ Name.getValue());
								infor.setFont(Font.font(30));
								
								Text grade = new Text("Final Grade:   " + Student.gpaGenerator());
								
								grade.setFont(Font.font(30));
								
								word.getChildren().addAll(infor,grade);
								word.setAlignment(Pos.CENTER);
								Scene s2 = new Scene(word);
								Home.setScene(s2);
								Home.setTitle("MVI 12-2 Student");
								Home.setHeight(300);
								Home.setWidth(550);
								Home.setResizable(false);
							
								Home.show();
								stage.close();
							}
							else {
							ErrorWindow ew = new ErrorWindow();

							Name.setPromptText("");
							t_Password.setText("");
							l_Name.setTextFill(Color.RED);
							l_Password.setTextFill(Color.RED);

								}
						}		
				});
	}
}


