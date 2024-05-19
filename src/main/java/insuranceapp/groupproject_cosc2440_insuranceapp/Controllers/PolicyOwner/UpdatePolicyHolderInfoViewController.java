package insuranceapp.groupproject_cosc2440_insuranceapp.Controllers.PolicyOwner;

import insuranceapp.groupproject_cosc2440_insuranceapp.Models.DatabaseDriver;
import insuranceapp.groupproject_cosc2440_insuranceapp.Models.PolicyHolder;
import insuranceapp.groupproject_cosc2440_insuranceapp.Models.PolicyHolderModel;
import insuranceapp.groupproject_cosc2440_insuranceapp.Models.PolicyOwnerModel;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class UpdatePolicyHolderInfoViewController implements Initializable {
    public TextField nameTxtField;
    public TextField pwdTxtField;
    public TextField phoneTxtField;
    public TextField emailTxtField;
    public TextField addressTxtField;
    public Button saveBtn;
    private PolicyHolder policyHolder;

    public UpdatePolicyHolderInfoViewController(PolicyHolder policyHolder) {
        this.policyHolder = policyHolder;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Update
        phoneTxtField.setText(PolicyHolderModel.getInstance().getPolicyHolder().getPhoneNumber());
        emailTxtField.setText(PolicyHolderModel.getInstance().getPolicyHolder().getEmail());
        addressTxtField.setText(PolicyHolderModel.getInstance().getPolicyHolder().getAddress());
        String password = PolicyHolderModel.getInstance().getDatabaseDriver().getPasswordById(PolicyHolderModel.getInstance().getPolicyHolder().getId());
        pwdTxtField.setText(password);
        String username = PolicyHolderModel.getInstance().getDatabaseDriver().getUsernameById(PolicyHolderModel.getInstance().getPolicyHolder().getId());
        nameTxtField.setText(username);
        nameTxtField.setEditable(false);
        saveBtn.setOnAction(event -> {
            //PolicyHolderModel.getInstance().getDatabaseDriver().updateAccountData(username,password,PolicyHolderModel.getInstance().getPolicyHolder().getId());
            PolicyHolderModel.getInstance().getPolicyHolder().setUsername(nameTxtField.getText());
            PolicyHolderModel.getInstance().getPolicyHolder().setEmail(emailTxtField.getText());
            PolicyHolderModel.getInstance().getPolicyHolder().setPhoneNumber(phoneTxtField.getText());
            PolicyHolderModel.getInstance().getPolicyHolder().setAddress(addressTxtField.getText());
            PolicyHolderModel.getInstance().getPolicyHolder().setPassword(pwdTxtField.getText());
            PolicyHolderModel.getInstance().getDatabaseDriver().updateNameAndPWPolicyHolderById(PolicyHolderModel.getInstance().getPolicyHolder().getId());
            PolicyHolderModel.getInstance().getDatabaseDriver().updateEmailAddressPhonePolicyHolderById(PolicyHolderModel.getInstance().getPolicyHolder().getId());
            PolicyHolderModel.getInstance().getPolicyHolderViewFactory().closeCurrentSubStage();
//            DatabaseDriver databaseDriver = new DatabaseDriver();
//            databaseDriver.recordActivityHistory("UPDATE POLICY HOLDER INFORMATION OF " + PolicyHolderModel.getInstance().getPolicyHolder().getId(), PolicyHolderModel.getInstance().getPolicyHolder().getId());
            PolicyHolderModel.getInstance().getDatabaseDriver().recordActivityHistory("UPDATE POLICY HOLDER INFORMATION OF " + PolicyHolderModel.getInstance().getPolicyHolder().getId(), PolicyHolderModel.getInstance().getPolicyHolder().getId());
            System.out.println("UPDATE POLICY HOLDER INFORMATION OF"  + PolicyHolderModel.getInstance().getPolicyHolder().getId());
        });
    }
}
