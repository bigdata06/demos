package org.said.services;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * Created by BigdataArchitect on 2018-01-23.
 */
@Service
public interface UserService {

    String getUserServiceName();
    BigDecimal getRandomNumber();
}
