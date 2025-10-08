package com.upc.pre.peaceapp.iam.interfaces.rest.transform;


import com.upc.pre.peaceapp.iam.domain.model.commands.SignUpCommand;
import com.upc.pre.peaceapp.iam.interfaces.rest.resources.SignUpResource;

public class SignUpCommandFromResourceAssembler {

    public static SignUpCommand toCommandFromResource(SignUpResource resource) {
        return new SignUpCommand(resource.username(), resource.password(), resource.roles());
    }

}

