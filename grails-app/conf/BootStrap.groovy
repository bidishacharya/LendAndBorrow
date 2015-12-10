import com.lb.auth.Role
import com.lb.auth.User
import com.lb.auth.UserRole

class BootStrap {

    def init = { servletContext ->

        /*def user = new User("Sachin Aryal","sahcin.aryal@sachin.edu.np","sachin","admin");
//        def user = new User("sachin","admin");
        user.save(flush: true)
        def role = new Role("ROLE_SUPER")
        role.save(flush: true)
        def user1 = new User("Kundan Rana","kundan.rana@sachin.edu.np","kundan","kundan");
//        def user1 = new User("kundan","kundan");
        user1.save(flush: true)
        def role1 = new Role("ROLE_ADMIN")
        role1.save(flush: true)
        def user2 = new User("Surya Timisina","surya.timisina@sachin.edu.np","surya","surya");
//        def user2 = new User("surya","surya");
        user2.save(flush: true)
        def role2 = new Role("ROLE_MEMBER")
        role2.save(flush: true)
        UserRole.create(user,role,true)
        UserRole.create(user1,role1,true)
        UserRole.create(user2,role2,true)*/

    }
    def destroy = {
    }
}
