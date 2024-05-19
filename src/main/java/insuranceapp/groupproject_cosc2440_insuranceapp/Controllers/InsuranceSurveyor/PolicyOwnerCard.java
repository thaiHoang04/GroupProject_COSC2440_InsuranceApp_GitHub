package insuranceapp.groupproject_cosc2440_insuranceapp.Controllers.InsuranceSurveyor;

import insuranceapp.groupproject_cosc2440_insuranceapp.Models.PolicyOwner;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class PolicyOwnerCard implements Initializable {
    @FXML
    private Label id;

    @FXML
    private Label userName;

    @FXML
    private Label setFee;

    @FXML
    private Label view_more;

    private PolicyOwner owner;

    public PolicyOwnerCard(PolicyOwner owner) {
        this.owner = owner;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        updatePolicyOwnerCard();
    }

    public void updatePolicyOwnerCard() {
        id.textProperty().bind(owner.idProperty());
        userName.textProperty().bind(owner.nameProperty());
        setFee.textProperty().bind(owner.feeProperty().asString());

        view_more.setOnMouseClicked(mouseEvent -> {
            onButtonViewClick(owner);
        });
    }

    public void onButtonViewClick(PolicyOwner owner) {
        System.out.println("Click" + owner.getId());
    }
}
