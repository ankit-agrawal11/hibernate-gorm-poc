package com.foo.user

import grails.databinding.BindingFormat
import grails.gorm.annotation.Entity
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import org.grails.datastore.gorm.GormEntity

@Entity
@ToString(includes = ['id', 'username'], includePackage = false)
@EqualsAndHashCode
class User implements GormEntity<User> {

    boolean accountExpired
    boolean accountLocked
    boolean enabled = true
    boolean passwordExpired

    @BindingFormat('MM/dd/yyyy')
    Date birthdate

    Date dateCreated
    Date lastUpdated

    String email
    String firstName
    String gender
    String lastName
    String password
    String username

    static constraints = {
        email blank: false, email: true, unique: true
        gender inList: ['male', 'female', 'unspecified'], size: 4..11, nullable: true
        password blank: false, password: true
        username blank: false, unique: true
        birthdate nullable: true, max: new Date().clearTime()
        firstName maxSize: 100, nullable: true
        lastName maxSize: 100, nullable: true
        dateCreated bindable: false
        lastUpdated bindable: false
    }

    static mapping = {
    }

    def beforeInsert() {
        this.email = this.email.toLowerCase()

    }

    def beforeUpdate() {
        this.email = this.email.toLowerCase()
    }

    String getFullName() {
       return firstName + ' ' + lastName
    }
}
