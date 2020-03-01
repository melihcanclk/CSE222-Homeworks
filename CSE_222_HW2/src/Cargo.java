import java.util.ArrayList;

/**
 * Class for Cargo's
 */
public class Cargo {
    /**
     * Customer type sender
     */
    private Customer sender;
    /**
     * Customer Type receiver
     */
    private Customer receiver;
    /**
     * int type CargoNumber
     */
    private int cargoNo;
    /**
     * StatusOfCargo type statusOfCargo
     */
    StatusOfCargo statusOfCargo;
    /**
     * Branch Type startBranch
     */
    private Branch startBranch;
    /**
     * Branch Type endBranch
     */
    private Branch endBranch;

    /**
     * No Parameter Cargo constructor
     */
    public Cargo() {
    }

    /**
     * 6 parameter Cargo constructor
     * @param sender Customer type sender
     * @param receiver Customer Type receiver
     * @param cargoNo int type CargoNumber
     * @param statusOfCargo StatusOfCargo type statusOfCargo
     * @param startBranch Branch Type startBranch
     * @param endBranch Branch Type endBranch
     */
    public Cargo(Customer sender, Customer receiver, int cargoNo, StatusOfCargo statusOfCargo, Branch startBranch, Branch endBranch) {
        this.sender = sender;
        this.receiver = receiver;
        this.cargoNo = cargoNo;
        this.statusOfCargo = statusOfCargo;
        this.startBranch = startBranch;
        this.endBranch = endBranch;
    }

    /**
     * Getter for sender
     * @return Customer type sender
     */
    public Customer getSender() {
        return sender;
    }
    /**
     * Setter for sender
     * @param sender Customer type Sender
     */
    public void setSender(Customer sender) {
        this.sender = sender;
    }
    /**
     * Getter for receiver
     * @return Customer type receiver
     */
    public Customer getReceiver() {
        return receiver;
    }

    /**
     * Setter for receiver
     * @param receiver Customer type receiver
     */
    public void setReceiver(Customer receiver) {
        this.receiver = receiver;
    }
    /**
     * Getter for startBranch
     * @return Branch type startBranch
     */
    public Branch getStartBranch() {
        return startBranch;
    }

    /**
     * Setting startBranch
     * @param start Branch type startBranch
     */
    public void setStartBranch(Branch start) {
        this.startBranch = start;
    }
    /**
     * Getter for startBranch
     * @return Branch type endBranch
     */
    public Branch getEndBranch() {
        return endBranch;
    }

    /**
     * Setting endbranch
     * @param end Branch type endBranch
     */
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
    /**
     * Getter for cargoNo
     * @return int type cargoNo
     */
    public int getCargoNo() {
        return cargoNo;
    }
    /**
     * Setter for startBranch
     * @param cargoNo int type cargoNo
     */
    public void setCargoNo(int cargoNo) {
        this.cargoNo = cargoNo;
    }

    /**
     * getting Status of cargo
     * @return StatusOfCargo type status of cargo
     */
    public StatusOfCargo getStatusOfCargo() {
        return statusOfCargo;
    }

    /**
     * Setting Status of cargo
     * @param statusOfCargo StatusOfCargo type statusOfCargo
     */
    public void setStatusOfCargo(StatusOfCargo statusOfCargo) {
        this.statusOfCargo = statusOfCargo;
    }


}
