package lendandborrow

import com.lb.auth.User

class TransactionHistory {

    static  belongsTo = [task:Task,user:User]
    static constraints = {
    }
}
