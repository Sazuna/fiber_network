package fiber_network;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.paint.*;
import javafx.scene.canvas.*;
import javafx.scene.Group;

public class Main extends Application {

	
	public static void main(String[] args)
	{
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Fiber network's schema");
		Group root = new Group();

		World w = new World();
		w.stepOne();
		
		int size = w.getSize();
		Scene scene = new Scene(root, size, size, Color.WHITE);
		
		final Canvas canvas = new Canvas(size, size);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		
		gc.setFill(Color.BLUE);
		
		
		
		for (Link l: w.getLinks())
		{
			gc.strokeLine(l.getNode1().getX(), l.getNode1().getY(), l.getNode2().getX(), l.getNode2().getY());
		}
		
		gc.setFill(Color.RED);

		for (Node n: w.getNodes())
		{
			System.out.println(n);
			gc.fillOval(n.getX(), n.getY(), 3, 3);
		}
		
		root.getChildren().add(canvas);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
