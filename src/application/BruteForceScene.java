package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class BruteForceScene extends Pane {
	BruteForceCipher obj =new BruteForceCipher();
	String Ciphertext;
	public BruteForceScene(Stage primaryStage,Scene oldScene) {
		Button back =new Button("Back");
    	back.setStyle("-fx-background-color: #E65A1D; -fx-text-fill: white; -fx-font-size: 14px; -fx-padding: 10px 20px; -fx-border-radius: 5px; -fx-background-radius: 5px;");
		back.setOnAction(a ->{
			primaryStage.setScene(oldScene);		
			primaryStage.setFullScreen(true);
		});
		
		
		VBox vb =new VBox();
		
		
		BorderPane bp =new BorderPane();
		bp.setCenter(vb);
		bp.setBottom(back);
		
				
		Label ctL =new Label("CipherText: ");
		TextField ctTF =new TextField();
		Button addC =new Button("add CipherText");
		HBox hbCT =new HBox();
		hbCT.getChildren().addAll(ctL,ctTF,addC);
		VBox vb1 =new VBox(10);
		Button fileC =new Button("Read from file");
		Button decrypt =new Button("decrypt");
		TextField res =new TextField();
		vb1.getChildren().addAll(hbCT,fileC,decrypt,res);
		bp.setLeft(vb1);
		vb1.setAlignment(Pos.CENTER);
		VBox vb2 =new VBox(6);
		bp.setCenter(vb2);
		ctL.setStyle("-fx-font-size: 16px; -fx-text-fill: #1E2E5B;");
		addC.setOnAction(a ->{
			Ciphertext=ctTF.getText();
		});
		decrypt.setOnAction(a ->{
			  vb2.getChildren().clear(); 
			    String ciphertext = ctTF.getText();
			    
			    for (int key = 0; key < 26; key++) { 
			        TextField tf = new TextField();
			        
			        tf.setText("Key " + key + ": " + obj.decrypt(ciphertext, key));
			        vb2.getChildren().add(tf);
			    }
		});
	
		fileC.setOnAction(a ->{
			FileChooser file =new FileChooser();	
			File c = file.showOpenDialog(primaryStage);
			if (c != null) {
				try (Scanner scan = new Scanner(c)) {		
					StringBuilder str = new StringBuilder();
					while (scan.hasNextLine()) {
						str.append(scan.nextLine());
					}
					StringBuilder sb =new StringBuilder();
					for(int i=0;i<str.length();i++) {
						sb.append(str.charAt(i));
					}
					System.out.println(sb.toString());
					Ciphertext=sb.toString();
					Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("SUCCESS!");
						alert.setContentText("The Users added successfully");
						alert.showAndWait();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (NumberFormatException e) {
					e.printStackTrace();
				}

			}
		});
		
		
		Scene scene =new Scene(bp,1100,700);
		primaryStage.setScene(scene);		
		primaryStage.setFullScreen(true);
		primaryStage.show();
	}	

}
