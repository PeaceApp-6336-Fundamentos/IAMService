package com.upc.pre.peaceapp.iam.infrastructure.hashing.bcrypt;

import com.upc.pre.peaceapp.iam.application.internal.outboundservices.hashing.HashingService;
import org.springframework.security.crypto.password.PasswordEncoder;

public interface BCryptHashingService extends HashingService, PasswordEncoder {

}