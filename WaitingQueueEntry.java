class WaitingQueueEntry {  
    private String customerName;
    private String mobileNumber;
    private String busNumber;
    private String reservationDate;

    public WaitingQueueEntry(String customerName, String mobileNumber, String busNumber, String reservationDate) {
        this.customerName = customerName;
        this.mobileNumber = mobileNumber;
        this.busNumber = busNumber;
        this.reservationDate = reservationDate;
    }

    // Getters for the fields
    public String getCustomerName() {
        return customerName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getBusNumber() {
        return busNumber;
    }

    public String getReservationDate() {
        return reservationDate;
    }
    public void assignSeat(int seatNumber) {
    }
 public String toFileString() {
        return customerName + "," + mobileNumber + "," + busNumber + "," + reservationDate;
    }
}
