package org.said.services;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Random;

/**
 * Created by BigdataArchitect on 2018-01-23.
 */
@Service
public class UserServiceImpl implements UserService {

    static final Random RANDOM = new Random();
    @Override
    public String getUserServiceName() {
        return "IT department";
    }

    @Override
    public BigDecimal getRandomNumber() {
        long ll = RANDOM.nextLong();
        return new BigDecimal(ll);
    }
}
