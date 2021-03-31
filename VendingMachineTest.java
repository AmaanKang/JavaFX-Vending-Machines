import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * This class builds an application that creates two vending machine objects and displays various functions of the objects in graphical user interface
 *
 * @author Amandeep Kaur
 *
 * Date Created: July 14, 2020
 */
public class VendingMachineTest extends Application {

    VendingMachine v1;//vending machine 1
    VendingMachine v2;//vending machine 2

    Label l1,l2,l3,l4,l5,l6;//declares labels
    Button b1,b2,b3;//declares buttons
    TextField t1,t2;//declares TextField

    /**
     * deposits the money in the machine by pressing the 'Enter money' button
     * @param evt event
     */
    private void enterMoney(ActionEvent evt){
        l6.setText(" ");
        if(t1.getText().equals("1")){
            v1.enterMoney(Double.parseDouble(t2.getText()));
            l1.setText("Vending Machine 1: " + "\n" + v1);
        }
        else if(t1.getText().equals("2")){
            v2.enterMoney(Double.parseDouble(t2.getText()));
            l2.setText("Vending Machine 2: " + "\n" + v2);
        }
    }

    /**
     * returns the change when 'Get change' button is pressed
     * @param evt event
     */
    private void getChange(ActionEvent evt){
        l6.setText(" ");
        if(t1.getText().equals("1")){
            v1.coinReturn();
            l1.setText("Vending Machine 1: " + "\n" + v1);
        }
        else if(t1.getText().equals("2")){
            v2.coinReturn();
            l2.setText("Vending Machine 2: " + "\n" + v2);
        }
    }

    /**
     * vends an items on pressing the 'Vend an item' button
     * @param evt event
     */
    private void vendItem(ActionEvent evt) {
        if (t1.getText().equals("1")) {
            if (v1.getUnusedCredit() >= v1.getProductPrice() && v1.getProductQuantity() > 0) {
                v1.vendItem();
                l1.setText("Vending Machine 1: " + "\n" + v1);
                l6.setStyle("-fx-text-fill:rgb(32,252,3);");
                l6.setText("Item vended: " + "Chocolate Bar");
            }else{
                l6.setStyle("-fx-text-fill:rgb(252,3,40);");
                l6.setText("***Please check your unused credit and the number of items left***");
            }
        }
        else if (t1.getText().equals("2")) {
            if (v2.getUnusedCredit() >= v2.getProductPrice() && v2.getProductQuantity() > 0) {
                v2.vendItem();
                l2.setText("Vending Machine 2: " + "\n" + v2);
                l6.setStyle("-fx-text-fill:rgb(32,252,3);");
                l6.setText("Item vended: " + "Chips Packet");

            }else{
                l6.setStyle("-fx-text-fill:rgb(252,3,40);");
                l6.setText("***Please check your unused credit and the number of items left***");
            }
        }

    }
    /**
     * This class creates GUI components, the model and adds event handlers.
     *
     * @param stage The main stage
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception {
        Pane root = new Pane();
        Scene scene = new Scene(root, 600, 400); // set the size
        stage.setTitle("Two Vending Machines"); // set the window title
        stage.setScene(scene);

        /**
         * Create the model
         */

        v1 = new VendingMachine();//creates first vending machine

        v2 = new VendingMachine();//creates second vending machine

        /*Vending Machine 1
         sets the private variables to the arguments passed
         */
        v1.setAmountMoney(0);
        v1.setProductName("chocolate bars");
        v1.setProductPrice(1.99);
        v1.setProductQuantity(20);
        v1.setUnusedCredit(3.99);

        /*Vending Machine 2
        sets the variables to the passed arguments
         */
        v2.setProductQuantity(20);
        v2.setUnusedCredit(5.99);
        v2.setProductPrice(2.99);
        v2.setProductName("Chips Pack");
        v2.setAmountMoney(0);

        // Create the GUI components
        Canvas canvas = new Canvas(600,400);//canvas on which view is shown
        l1 = new Label(" Vending Machine 1 "+"\n"+v1);//displays string representation of machine 1
        l2 = new Label(" Vending Machine 2 "+"\n"+v2);//displays string representation of machine 2
        l3 = new Label("Which machine would you choose:");
        t1 = new TextField();//number of machine(1 or 2) to be entered
        l4 = new Label("If you want to deposit money, please enter \n an amount here or leave it blank: ");
        t2 = new TextField();//amount of money to be entered
        l5 = new Label("What would you like to do: ");
        b1 = new Button("Enter money");
        b2 = new Button("Get change");
        b3 = new Button("Vend an item");
        l6 = new Label("");//displays message when an item is vended or the reason behind the vend being unsuccessful


        // Add components to the root
        root.getChildren().addAll(canvas,l1,l2,l3,b1,b2,b3,t1,l4,l5,t2,l6);

        // Configure the components (colors, fonts, size, location)

        l1.relocate(10,20);
        l1.setFont(new Font("Arial",15));
        l1.setStyle("-fx-text-fill:rgb(3,198,252);");
        l2.relocate(300,20);
        l2.setFont(new Font("Arial",15));
        l2.setStyle("-fx-text-fill:rgb(202,3,252);");
        l3.relocate(10,130);
        l4.relocate(10,180);
        l5.relocate(10,250);
        t1.relocate(250,130);
        t2.relocate(250,180);
        b1.relocate(30,290);
        b2.relocate(180,290);
        b3.relocate(300,290);
        l6.relocate(10,330);
        l6.setFont(new Font("Arial",15));


        // 5. Add Event Handlers and do final setup
        b1.setOnAction(this::enterMoney);
        b2.setOnAction(this::getChange);
        b3.setOnAction(this::vendItem);
        // 6. Show the stage
        stage.show();
    }

    /**
     *
     * @param args unused
     */
    public static void main(String[] args) {
        launch(args);
    }
}

