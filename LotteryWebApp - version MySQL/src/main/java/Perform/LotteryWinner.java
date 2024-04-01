package Perform;

public class LotteryWinner {
    private String firstName;
    private String lastName;
    private double amount;

    public LotteryWinner(String firstName, String lastName, double amount) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.amount = amount;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public double getAmount() {
        return amount;
    }
}
