package com.upc.pre.peaceapp.iam.domain.services;


import com.upc.pre.peaceapp.iam.domain.model.commands.SeedRolesCommand;

public interface RoleCommandService {
    void handle(SeedRolesCommand command);
}
