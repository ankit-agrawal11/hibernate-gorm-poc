package com.foo

import com.foo.user.User
import com.foo.utils.EntityInitializerUtils
import org.grails.orm.hibernate.HibernateDatastore

/**
 * Starting point of the application.
 */
class Application {
    static void main(String[] args) {
        println('Starting application...')

        EntityInitializerUtils entityInitializerUtils = new EntityInitializerUtils()
        entityInitializerUtils.initializeDomains()

    }
}
