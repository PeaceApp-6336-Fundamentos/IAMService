package com.upc.pre.peaceapp.iam.interfaces.rest.transform;


import com.upc.pre.peaceapp.iam.domain.model.aggregates.User;
import com.upc.pre.peaceapp.iam.domain.model.entities.Role;
import com.upc.pre.peaceapp.iam.interfaces.rest.resources.UserIAMResource;

public class UserResourceFromEntityAssembler {
    public static UserIAMResource toResourceFromEntity(User user) {
        var roles = user.getRoles().stream().map(Role::getStringName).toList();
        return new UserIAMResource(user.getId(), user.getUsername(), roles);
    }
}

