public class Cargo {
    private Customer sender;
    private Customer receiver;
    private int cargoNo;
    StatusOfCargo statusOfCargo;
    private Branch startBranch;
    private Branch endBranch;

    public Customer getSender() {
        return sender;
    }

    public void setSender(Customer sender) {
        this.sender = sender;
    }

    public Customer getReceiver() {
        return receiver;
    }

    public void setReceiver(Customer receiver) {
        this.receiver = receiver;
    }

    public Branch getStartBranch() {
        return startBranch;
    }

    public void setStartBranch(Branch start) {
        this.startBranch = start;
    }

    public Branch getEndBranch() {
        return endBranch;
    }

    public void setEndBranch(Branch end) {
        this.endBranch = end;
    }

    @Override
    public String toString() {
        return "Cargo{" +
                "sender=" + sender +
                ", receiver=" + receiver +
                ", cargoNo=" + cargoNo +
                ", statusOfCargo=" + statusOfCargo +
                ", startBranch=" + startBranch +
                ", endBranch=" + endBranch +
                '}';
    }

    public int getCargoNo() {
        return cargoNo;
    }

    public void setCargoNo(int cargoNo) {
        this.cargoNo = cargoNo;
    }


    public StatusOfCargo getStatusOfCargo() {
        return statusOfCargo;
    }

    public void setStatusOfCargo(StatusOfCargo statusOfCargo) {
        this.statusOfCargo = statusOfCargo;
    }
}
