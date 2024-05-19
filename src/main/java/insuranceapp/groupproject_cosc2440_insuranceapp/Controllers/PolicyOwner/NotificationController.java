package insuranceapp.groupproject_cosc2440_insuranceapp.Controllers.PolicyOwner;

import insuranceapp.groupproject_cosc2440_insuranceapp.Models.PolicyOwnerModel;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class NotificationController implements Initializable {
    public Label notificationMsgLbl;
    public Button closeWindowBtn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        switch(PolicyOwnerModel.getInstance().getViewFactory().getNotificationMsg().toString()) {
            case "Add Claim Success" -> {
                notificationMsgLbl.setText("Add claim successfully!");
            }
            case "Add Claim Failed" -> {
                notificationMsgLbl.setText("Add claim failed!");
            }
        }
        closeWindowBtn.setOnAction(event -> {
            PolicyOwnerModel.getInstance().getPolicyOwnerViewFactory().closeCurrentSubStage();
        });
    }
}
