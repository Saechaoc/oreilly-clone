package com.chris.oreillyclone.service;

import com.chris.oreillyclone.exception.UserException;
import com.chris.oreillyclone.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImplementation implements UserService {

    // Inject required dependencies using @Autowired or constructor-based injection
    // Implement the methods

    @Override
    public User findUserById(Long userId) throws UserException {
        // Your logic here
        return null;
    }

    @Override
    public User findUserByJWT(String jwt) throws UserException {
        // Your logic here
        return null;
    }
}
