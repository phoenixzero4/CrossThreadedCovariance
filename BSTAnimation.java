
package february;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Duration;

public class BSTAnimation extends Application {

	@Override
	public void start(Stage primaryStage) {
		BST<Integer> tree = new BST<>();
		
		BorderPane pane = new BorderPane();
		BTView view = new BTView(tree);
		pane.setCenter(view);
		
		TextField tfKey = new TextField();
		tfKey.setPrefColumnCount(4);
		tfKey.setAlignment(Pos.BASELINE_RIGHT);
		Button btInsert = new Button("Insert");
		Button btDelete = new Button("Delete");
		HBox hbox = new HBox(5);
		hbox.getChildren().addAll(new Label("Enter a key: "), tfKey, btInsert, btDelete);
		hbox.setAlignment(Pos.CENTER);
		pane.setBottom(hbox);
		
		Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(2), new EventHandler<ActionEvent>() {
					private int i = 1;
					
					@Override
					public void handle(ActionEvent event) {
						view.setStatus("Please enter an integer less than 100");
						i++;
					}
				}));
		
		btInsert.setOnAction(e -> {
			int key = Integer.parseInt(tfKey.getText());
			if(key > 100) {
				view.setStatus("");
				timeline.setCycleCount(3);
				timeline.play();
				
			}else {
			if(tree.search(key)) {	// key exists in tree
				view.displayTree();
				view.setStatus(key + " is already in the tree");
			} else {
				tree.insert(key);
				view.displayTree();
				view.setStatus(key + " inserted in tree");
			}
			}
		});
		
		btDelete.setOnAction(e -> {
			int key = Integer.parseInt(tfKey.getText());
			if(!tree.search(key)) {
				
				view.displayTree();
				view.setStatus(key + " is not in tree");
			} else {
				tree.delete(key);
				view.displayTree();
				view.setStatus(key + " removed");
			}
		});
		
		Scene scene = new Scene(pane, 500, 250);
		primaryStage.setTitle("Binary Search Tree");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
