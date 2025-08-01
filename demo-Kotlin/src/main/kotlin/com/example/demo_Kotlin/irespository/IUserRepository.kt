package com.example.demo_Kotlin.irespository

import com.example.demo_Kotlin.dto.IUserDto
import com.example.demo_Kotlin.entity.security.User

import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository


@Repository
interface IUserRepository : IBaseRepository<User, Long> {

    @Query(
        value = """
            SELECT 
                u.id, 
                u.username AS username, 
                CONCAT(p.first_name, ' ', p.last_name) AS personName, 
                p.email AS personEmail, 
                u.state,
                ur.role_id AS roleId
            FROM user u
            INNER JOIN person p ON p.id = u.person_id
            INNER JOIN user_role ur ON ur.user_id = u.id
            INNER JOIN role r ON r.id = ur.role_id
            WHERE u.username = :username AND u.password = :password
        """,
        nativeQuery = true
    )
    fun getUserWithRole(
        @Param("username") username: String,
        @Param("password") password: String
    ): List<IUserDto>


}
