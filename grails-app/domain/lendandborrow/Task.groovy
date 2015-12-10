package lendandborrow

import com.lb.auth.User

class Task {

    String itemName;
    String itemDescription;
    Date requestDate;
    Date returnDate;
    User lender;
    User borrower;

    static constraints = {
        itemName nullable: false
        itemDescription nullable: true,maxSize: 200
        requestDate nullable: false
        returnDate nullable: false
        lender nullable: true
        borrower nullable: true
    }
}
