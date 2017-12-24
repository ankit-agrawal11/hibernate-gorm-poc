package com.foo.utils

import com.foo.user.User
import grails.gorm.services.Service

@Service(User)
interface UserService {
    int count()

    User saveUser(User user)
}
