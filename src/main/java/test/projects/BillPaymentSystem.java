package test.projects;

public class BillPaymentSystem implements PaymentSystem {

    private InputSource billInput;
    private Display display;

    public void acceptPayment(Double desiredAmount) {
        Double payedAmount = 0.0;

        while (payedAmount < desiredAmount) {
            Double currentAmount = new Double(billInput.getInput());
            payedAmount = payedAmount + currentAmount;
            if (payedAmount < desiredAmount) {
                display.displayMessage((desiredAmount - payedAmount) + " left");
            }
        }
    }

    public void setDisplay(Display display) {
        this.display = display;
    }

    public void setBillInput(InputSource billInput) {
        this.billInput = billInput;
    }
}
