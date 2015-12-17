package com.lb.auth

import lendandborrow.TransactionHistory

class User implements Serializable {

	private static final long serialVersionUID = 1

	transient springSecurityService

	String name
	String email
	String username
	String password
	boolean enabled = true
	boolean accountExpired
	boolean accountLocked
	boolean passwordExpired

	static hasMany = [transactionHistory:TransactionHistory]

	User(String name,String email,String username, String password) {
//		this()
		this.name=name
		this.email=email
		this.username = username
		this.password = password
	}

	@Override
	int hashCode() {
		username?.hashCode() ?: 0
	}

	@Override
	boolean equals(other) {
		is(other) || (other instanceof User && other.username == username)
	}

	@Override
	String toString() {
		username
	}

	Set<Role> getAuthorities() {
		UserRole.findAllByUser(this)*.role
	}

	boolean beforeInsertRunOnce = false
	boolean beforeUpdateRunOnce = false


	def beforeInsert() {
		if (! beforeInsertRunOnce) {
			beforeInsertRunOnce = true
			encodePassword()
		}
	}

	def afterInsert() {
		beforeInsertRunOnce = false
	}


	def beforeUpdate() {
		if (isDirty('password') && ! beforeUpdateRunOnce ) {
			beforeUpdateRunOnce = true
			encodePassword()
		}
	}

	def afterUpdate() {
		beforeUpdateRunOnce = false
	}

	protected void encodePassword() {
		password = springSecurityService?.passwordEncoder ? springSecurityService.encodePassword(password) : password
	}

	static transients = ['springSecurityService']

	static constraints = {
		username blank: false, unique: true
		password blank: false
	}

	static mapping = {
		password column: '`password`'
	}
}
