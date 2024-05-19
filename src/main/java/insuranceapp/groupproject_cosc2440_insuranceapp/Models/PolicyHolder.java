package insuranceapp.groupproject_cosc2440_insuranceapp.Models;

public class PolicyHolder extends Beneficiary {
    private String password;
    private String username;
    public PolicyHolder(String id, String fullName, String insuranceCard, String phoneNumber, String email, String address, String policyOwnerId) {
        super(id, fullName, insuranceCard, phoneNumber, email, address, policyOwnerId);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
