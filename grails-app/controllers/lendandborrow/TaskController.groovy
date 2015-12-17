package lendandborrow

import grails.plugin.springsecurity.annotation.Secured

@Secured('permitAll')
class TaskController {
    def springSecurityService

    def index() {

            if(springSecurityService.isLoggedIn()) {
                redirect(controller: 'task',action: 'dashboard')
            }else {
                redirect(controller: 'login', action: 'auth')
            }
        }

    def dashboard(){

    }
}
