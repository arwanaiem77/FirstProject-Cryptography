package application;

	import javafx.geometry.Insets;
import javafx.geometry.Pos;
	import javafx.scene.Scene;
	import javafx.scene.control.Button;
import javafx.scene.image.*;
import javafx.scene.layout.HBox;
	import javafx.scene.layout.*;
	import javafx.stage.Stage;
public class MyScene extends Pane {

		public MyScene(Stage primaryStage) {
			
			BorderPane bp =new BorderPane();
			HBox hb1 =new HBox(20);
			hb1.setStyle("-fx-background-color: #f9f7f1;");
			hb1.setAlignment(Pos.CENTER);
			VBox vb =new VBox(15);
			vb.setAlignment(Pos.CENTER);
			ImageView iv0=new ImageView("img.png");
			iv0.setFitHeight(300);
			iv0.setFitWidth(300);
			HBox hb0=new HBox(70);
			ImageView iv1=new ImageView("class.png");
			ImageView iv2=new ImageView("parag.png");
			iv1.setFitHeight(180);
			iv1.setFitWidth(900);
			iv2.setFitHeight(90);
			iv2.setFitWidth(800);	
			vb.getChildren().addAll(iv1,iv2);

			hb0.getChildren().addAll(iv0,vb);

			HBox hb2 =new HBox();
			hb2.setStyle("-fx-background-color: #20a89d;");
			hb1.setStyle("-fx-background-color: #f9f7f1;");
			hb1.setPrefHeight(700); 
			bp.setTop(hb1);
			hb2.setStyle("-fx-background-color: #1E2E5B;");
			hb2.setPrefHeight(100); 
			bp.setBottom(hb2);
			
			ImageView iv3=new ImageView("hill.png");
			iv3.setFitHeight(200);
			iv3.setFitWidth(200);
			ImageView iv4=new ImageView("playfair.png");
			iv4.setFitHeight(200);
			iv4.setFitWidth(200);
			ImageView iv5=new ImageView("shift.png");
			iv5.setFitHeight(200);
			iv5.setFitWidth(200);
			ImageView iv6=new ImageView("enhanced.png");
			iv6.setFitHeight(200);
			iv6.setFitWidth(200);
			ImageView iv7=new ImageView("brute.png");
			iv7.setFitHeight(200);
			iv7.setFitWidth(200);
			

			HBox hb =new HBox(15);
			Scene scene =new Scene(bp,1100,700);
			Button hill =new Button("",iv3);
			Button playfair =new Button("",iv4);
			Button shift =new Button("",iv5);
			Button enhanced =new Button("",iv6);
			Button brute =new Button("",iv7);
			hb.setAlignment(Pos.CENTER);
			VBox vb2 =new VBox(200);
			vb2.getChildren().addAll(hb0,hb);
			hb1.getChildren().add(vb2);

			hb.getChildren().addAll(hill,playfair,shift,enhanced,brute);
			hill.setOnAction(a ->{
				Scene scenee =new Scene(new HillScene(primaryStage,scene),1100,700);

			});
			playfair.setOnAction(a ->{
				Scene scenee =new Scene(new PlayfairScene(primaryStage,scene),1100,700);

			});
			shift.setOnAction(a ->{
				Scene scenee =new Scene(new ShiftScene(primaryStage,scene),1100,700);

			});
			brute.setOnAction(a ->{
				Scene scenee =new Scene(new BruteForceScene(primaryStage,scene),1100,700);


			});
			enhanced.setOnAction(a ->{
				Scene scenee =new Scene(new EnhancedScene(primaryStage,scene),1100,700);

			});
			primaryStage.setScene(scene);			
			primaryStage.setFullScreen(true);
			primaryStage.show();
		}
		

	}




