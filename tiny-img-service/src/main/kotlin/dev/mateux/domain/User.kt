package dev.mateux.domain

import jakarta.ws.rs.core.SecurityContext
import org.eclipse.microprofile.jwt.JsonWebToken

data class User(
    val username: String,
    val publicId: String
) {
    companion object {
        fun fromSecurityContext(context: SecurityContext): User {
            val token = context.userPrincipal as JsonWebToken

            return User(
                username = context.userPrincipal.name,
                publicId = token.subject
            )
        }
    }
}
