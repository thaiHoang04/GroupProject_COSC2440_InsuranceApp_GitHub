package insuranceapp.groupproject_cosc2440_insuranceapp.Controllers.InsuranceSurveyor;

import insuranceapp.groupproject_cosc2440_insuranceapp.Models.PolicyHolder;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class PolicyHolderCard implements Initializable {
    @FXML
    private Label id;

    @FXML
    private Label userName;

    @FXML
    private Label insuranceCard;

    @FXML
    private Label view_more;

    private PolicyHolder holder;

    public PolicyHolderCard(PolicyHolder holder) {
        this.holder = holder;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        updatePolicyHolderCard();
    }

    public void updatePolicyHolderCard() {
        id.setText(holder.getId());
        userName.setText(holder.getFullName());
        insuranceCard.setText(holder.getInsuranceCard());

        view_more.setOnMouseClicked(mouseEvent -> {
            onButtonViewClick(holder.getId());
        });
    }

    public void onButtonViewClick(String id) {
        System.out.println("Click" + id);
    }

}
