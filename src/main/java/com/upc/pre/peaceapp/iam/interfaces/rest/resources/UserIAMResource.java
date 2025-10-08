package com.upc.pre.peaceapp.iam.interfaces.rest.resources;

import java.util.List;

public record UserIAMResource(Long id, String username, List<String> roles) {
}
