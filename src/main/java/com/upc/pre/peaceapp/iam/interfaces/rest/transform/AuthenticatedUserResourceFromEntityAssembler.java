package com.upc.pre.peaceapp.iam.interfaces.rest.transform;

import com.upc.pre.peaceapp.iam.domain.model.aggregates.User;
import com.upc.pre.peaceapp.iam.domain.model.entities.Role;
import com.upc.pre.peaceapp.iam.domain.model.valueobjects.Roles;
import com.upc.pre.peaceapp.iam.interfaces.rest.resources.AuthenticatedUserResource;

public class AuthenticatedUserResourceFromEntityAssembler {

    public static AuthenticatedUserResource toResourceFromEntity(User user, String token) {

        // Tomar un rol (ej: el primero). Ajusta según tu modelo de Role.
        String roleName = String.valueOf(user.getRoles().stream()
                .findFirst()
                .map(Role::getName)   // 👈 asumiendo que Role tiene getName() que devuelve "ROLE_USER", etc.
                .orElse(Roles.valueOf("ROLE_USER")));

        return new AuthenticatedUserResource(
                user.getId(),
                user.getUsername(),
                roleName,
                token
        );
    }
}
