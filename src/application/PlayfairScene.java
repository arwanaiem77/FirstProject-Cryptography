package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class PlayfairScene extends Pane{
	PlayfairCipher obj =new PlayfairCipher();
	char[][] keyplayfair;
	StringBuilder Plaintext;
	StringBuilder Ciphertext;
	public PlayfairScene(Stage primaryStage,Scene oldScene) {

		Button back =new Button("Back");
		back.setStyle("-fx-background-color: #E65A1D; -fx-text-fill: white; -fx-font-size: 14px; -fx-padding: 10px 20px; -fx-border-radius: 5px; -fx-background-radius: 5px;");
		back.setOnAction(a ->{
			primaryStage.setScene(oldScene);		
			primaryStage.setFullScreen(true);
		});


		VBox vb =new VBox(10);
		Button key =new Button("KEY");
		Button seed =new Button("SEED");
		vb.getChildren().addAll(key,seed);
		vb.setAlignment(Pos.CENTER);
		
	key.setStyle("-fx-background-color: #1E2E5B; -fx-text-fill: white; -fx-font-size: 16px; -fx-padding: 10px 20px; -fx-border-radius: 8px; -fx-background-radius: 8px;");
	seed.setStyle("-fx-background-color: #1E2E5B; -fx-text-fill: white; -fx-font-size: 16px; -fx-padding: 10px 20px; -fx-border-radius: 8px; -fx-background-radius: 8px;");



		BorderPane bp =new BorderPane();
		bp.setPadding(new Insets(50,50,50,50));
		bp.setCenter(vb);
		bp.setBottom(back);

		key.setOnAction(a ->{
			TextField keyTF =new TextField();
			Button add =new Button("add:");
			HBox hb =new HBox();
			hb.getChildren().addAll(keyTF,add);
			hb.setAlignment(Pos.CENTER);
			bp.setRight(hb);
			add.setOnAction(e ->{
				keyplayfair=obj.keyWord(keyTF.getText());
			});			

		});
		seed.setOnAction(a ->{
			System.out.println(obj.seed());
			keyplayfair=obj.keyWord(obj.seed());

		});
		Label ptL =new Label("PlainText: ");
		TextField ptTF =new TextField();
		Button addP =new Button("add PlainText");
		HBox hbPT =new HBox();
		hbPT.getChildren().addAll(ptL,ptTF,addP);
		hbPT.setAlignment(Pos.CENTER);
		Button fileP =new Button("Read from file");
		Button encrypt =new Button("Encrypt");
		Label ctL =new Label("CipherText: ");
		TextField ctTF =new TextField();
		Button addC =new Button("add CipherText");
		HBox hbCT =new HBox();
		hbCT.getChildren().addAll(ctL,ctTF,addC);
		VBox vb1 =new VBox(10);
		Button fileC =new Button("Read from file");
		Button decrypt =new Button("decrypt");
		TextField res =new TextField();
		Button saveToFile =new Button("Save cipher to file");
		vb1.getChildren().addAll(hbPT,fileP,encrypt,hbCT,fileC,decrypt,res,saveToFile);
		bp.setLeft(vb1);
		vb1.setAlignment(Pos.CENTER);
ptL.setStyle("-fx-font-size: 16px; -fx-text-fill: #1E2E5B;");
ctL.setStyle("-fx-font-size: 16px; -fx-text-fill: #1E2E5B;");

addP.setStyle("-fx-background-color: #1E2E5B; -fx-text-fill: white; -fx-font-size: 16px; -fx-padding: 10px 20px; -fx-border-radius: 8px; -fx-background-radius: 8px;");
fileP.setStyle("-fx-background-color: #1E2E5B; -fx-text-fill: white; -fx-font-size: 16px; -fx-padding: 10px 20px; -fx-border-radius: 8px; -fx-background-radius: 8px;");
encrypt.setStyle("-fx-background-color: #1E2E5B; -fx-text-fill: white; -fx-font-size: 16px; -fx-padding: 10px 20px; -fx-border-radius: 8px; -fx-background-radius: 8px;");
addC.setStyle("-fx-background-color: #1E2E5B; -fx-text-fill: white; -fx-font-size: 16px; -fx-padding: 10px 20px; -fx-border-radius: 8px; -fx-background-radius: 8px;");
fileC.setStyle("-fx-background-color: #1E2E5B; -fx-text-fill: white; -fx-font-size: 16px; -fx-padding: 10px 20px; -fx-border-radius: 8px; -fx-background-radius: 8px;");
decrypt.setStyle("-fx-background-color: #1E2E5B; -fx-text-fill: white; -fx-font-size: 16px; -fx-padding: 10px 20px; -fx-border-radius: 8px; -fx-background-radius: 8px;");


		addP.setOnAction(a ->{
			Plaintext=new StringBuilder(ptTF.getText());
		});
		encrypt.setOnAction(a ->{
			if(keyplayfair!=null) {
				ctTF.setText(obj.encryption(Plaintext, keyplayfair).toString());
				Ciphertext=obj.encryption(Plaintext, keyplayfair);
			}

			else {
				System.out.println("no key");
			}
		});
		decrypt.setOnAction(a ->{
			res.setText(obj.decryption(Ciphertext, keyplayfair).toString());
		});
		fileP.setOnAction(a ->{
			FileChooser file =new FileChooser();	
			File c = file.showOpenDialog(primaryStage);
			if (c != null) {
				int countLines=0;
				try (Scanner scan = new Scanner(c)) {		
					StringBuilder str = new StringBuilder();
					while (scan.hasNextLine()) {
						str.append(scan.nextLine());
					}
					String s = str.toString();
					s=s.toUpperCase();
					StringBuilder sb =new StringBuilder();
					for(int i=0;i<str.length();i++) {
						if(str.charAt(i)==' ')
							continue;
						sb.append(str.charAt(i));
					}
					Plaintext=sb;
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
		
		fileC.setOnAction(a ->{
			FileChooser file =new FileChooser();	
			File c = file.showOpenDialog(primaryStage);
			if (c != null) {
				int countLines=0;
				try (Scanner scan = new Scanner(c)) {		
					StringBuilder str = new StringBuilder();
					while (scan.hasNextLine()) {
						str.append(scan.nextLine());
					}
					String s = str.toString();
					s=s.toUpperCase();
					StringBuilder sb =new StringBuilder();
					for(int i=0;i<str.length();i++) {
						if(str.charAt(i)==' ')
							continue;
						sb.append(str.charAt(i));
					}
					Ciphertext=sb;
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
		saveToFile.setOnAction(a ->{
			FileChooser file =new FileChooser();	
			File c = file.showOpenDialog(primaryStage);
			if (c != null) {
				int countLines=0;
				try  {	
					PrintWriter print =new PrintWriter(c);
					print.print(res.getText());
					print.close();
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
