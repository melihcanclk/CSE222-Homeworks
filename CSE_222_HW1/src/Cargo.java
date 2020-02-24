public class Cargo {
    private Customer sender;
    private Customer receiver;
    private int cargoNo;
    StatusOfCargo statusOfCargo;
    private Branch startBranch;
    private Branch endBranch;

    public Cargo() {
    }

    public Cargo(Customer sender, Customer receiver, int cargoNo, StatusOfCargo statusOfCargo, Branch startBranch, Branch endBranch) {
        this.sender = sender;
        this.receiver = receiver;
        this.cargoNo = cargoNo;
        this.statusOfCargo = statusOfCargo;
        this.startBranch = startBranch;
        this.endBranch = endBranch;
    }

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
        return  "Sender:" + sender +
                " ,Receiver:" + receiver +
                " ,CargoNo:" + cargoNo +
                " ,StatusOfCargo:" + statusOfCargo +
                " ,StartBranch:" + startBranch +
                " ,EndBranch:" + endBranch;
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
