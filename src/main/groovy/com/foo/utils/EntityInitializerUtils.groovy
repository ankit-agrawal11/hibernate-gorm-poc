package com.foo.utils

import com.foo.user.User
import grails.transaction.Transactional
import groovy.util.logging.Slf4j
import org.grails.orm.hibernate.HibernateDatastore

/**
 * Class to initialize all the Entities.
 */
@Slf4j
class EntityInitializerUtils {

    /**
     * Method to initialize all the entities.
     *
     * @param dbName {@Link String)
     * @param entities {@Link Class}
     */
//    @Transactional
    void initializeDomains() {
        Map configuration = [
                'hibernate.hbm2ddl.auto':'create-drop',
//                'hibernate.enable_lazy_load_no_trans':false,
                'dataSource.url':'jdbc:h2:mem:myDB',
//                'dataSource.pooled':true,
//                'dataSource.jmxExport':true,
                'dataSource.driverClassName':'org.h2.Driver',
//                'dataSource.transactional':false
        ]
        HibernateDatastore datastore = new HibernateDatastore( configuration, User)

        // In a real app you would probably have this injected and not have to retrieve it yourself...
        UserService userService = datastore.getService(UserService)

        println userService.count()
    }
}
