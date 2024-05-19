package insuranceapp.groupproject_cosc2440_insuranceapp.Controllers.InsuranceSurveyor;

import insuranceapp.groupproject_cosc2440_insuranceapp.Models.Dependent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class DependentCard implements Initializable {
    @FXML
    private Label id;

    @FXML
    private Label userName;

    @FXML
    private Label insuranceCard;

    @FXML
    private Label view_more;

    private Dependent dependent;

    public DependentCard(Dependent dependent) {
        this.dependent = dependent;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        updatePolicyHolderCard();
    }

    public void updatePolicyHolderCard() {
        id.setText(dependent.getId());
        userName.setText(dependent.getFullName());
        insuranceCard.setText(dependent.getInsuranceCard());

        view_more.setOnMouseClicked(mouseEvent -> {
            onButtonViewClick(dependent.getId());
        });
    }

    public void onButtonViewClick(String id) {
        System.out.println("Click" + id);
    }
}
