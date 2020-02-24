public class Cargo {
    /**
     * Sender Customer that send the cargo
     */
    private Customer sender;
    /**
     * Receiver Customer that take the cargo
     */
    private Customer receiver;
    /**
     * Cargo Number to allow Customer check its cargo
     */
    private int cargoNo;
    /**
     * Status of cargo
     */
    StatusOfCargo statusOfCargo;
    /**
     * Starting branch of cargo
     */
    private Branch startBranch;
    /**
     * Ending branch of cargo
     */
    private Branch endBranch;

<<<<<<< HEAD
    /**
     * No parameter constructor of cargo class
     */
    public Cargo() {

    }

    /**
     * Getting sender of cargo
     * @return Customer who Sender of cargo
     */
=======
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

>>>>>>> 0b6c4ef0af0f1256785a0a5c1b2b30261b0faeee
    public Customer getSender() {
        return sender;
    }

    /**
     * Setting sender of the cargo
     * @param sender Sender of the cargo
     */
    public void setSender(Customer sender) {
        this.sender = sender;
    }

    /**
     * Getting Receiver of the cargo
     * @return Customer who Receiver of the cargo
     */
    public Customer getReceiver() {
        return receiver;
    }

    /**
     * Setting Receiver of the cargo
     * @param receiver Receiver of the cargo
     */
    public void setReceiver(Customer receiver) {
        this.receiver = receiver;
    }

    /**
     * Getting Start Branch of Cargo
     * @return Branch that Start Point of cargo
     */
    public Branch getStartBranch() {
        return startBranch;
    }

    /**
     * Setting Start branch of the cargo
     * @param start Starting branch
     */
    public void setStartBranch(Branch start) {
        this.startBranch = start;
    }

    /**
     * Getting End of the branch
     * @return Branch that cargo end
     */
    public Branch getEndBranch() {
        return endBranch;
    }

    /**
     * Setting end branch
     * @param end end branch will be set
     */
    public void setEndBranch(Branch end) {
        this.endBranch = end;
    }

    @Override
    public String toString() {
<<<<<<< HEAD
        return  "\nCargoNo:" + cargoNo+
                "\nSender:" + sender +
                "\nReceiver:" + receiver +
                "\nStatusOfCargo:" + statusOfCargo +
                "\nStartBranch:" + startBranch +
                "\nEndBranch:" + endBranch;
    }

    /**
     * 6 Parameter Constructor
     * @param sender Customer type sender that sends cargo
     * @param receiver Customer type receiver that sends cargo
     * @param cargoNo Cargo no for following cargo
     * @param statusOfCargo status of cargo(whether it is arrived or not)
     * @param startBranch Branch type start branch
     * @param endBranch Branch type end branch
     */
    public Cargo(Customer sender, Customer receiver, int cargoNo, StatusOfCargo statusOfCargo, Branch startBranch, Branch endBranch) {
        this.sender = sender;
        this.receiver = receiver;
        this.cargoNo = cargoNo;
        this.statusOfCargo = statusOfCargo;
        this.startBranch = startBranch;
        this.endBranch = endBranch;
=======
        return  "Sender:" + sender +
                " ,Receiver:" + receiver +
                " ,CargoNo:" + cargoNo +
                " ,StatusOfCargo:" + statusOfCargo +
                " ,StartBranch:" + startBranch +
                " ,EndBranch:" + endBranch;
>>>>>>> 0b6c4ef0af0f1256785a0a5c1b2b30261b0faeee
    }

    /**
     * Getting Cargo Number
     * @return int type Cargo number
     */
    public int getCargoNo() {
        return cargoNo;
    }

    /**
     * Setting Cargo Number
     * @param cargoNo int setting Cargo Number
     */
    public void setCargoNo(int cargoNo) {
        this.cargoNo = cargoNo;
    }

    /**
     * Getting Status of Cargo
     * @return StatusOfCargo type status of cargo if it is arrived or not
     */
    public StatusOfCargo getStatusOfCargo() {
        return statusOfCargo;
    }

    /**
     * Setting Status of Cargo
     * @param statusOfCargo StatusOfCargo type status of cargo
     */
    public void setStatusOfCargo(StatusOfCargo statusOfCargo) {
        this.statusOfCargo = statusOfCargo;
    }
}
