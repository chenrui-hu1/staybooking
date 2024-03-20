package com.hcr.staybooking.service.impl;


import com.hcr.staybooking.dto.AuthorityRepository;
import com.hcr.staybooking.dto.UserRepository;
import com.hcr.staybooking.entity.Authority;
import com.hcr.staybooking.entity.User;
import com.hcr.staybooking.entity.UserRole;
import com.hcr.staybooking.service.IRegisterService;
import com.hcr.staybooking.exception.UserAlreadyExistException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RegisterServiceImpl implements IRegisterService {
    private UserRepository userRepository;
    private AuthorityRepository authorityRepository;

    private PasswordEncoder passwordEncoder;


//    @Autowired
    public RegisterServiceImpl(UserRepository userRepository, AuthorityRepository authorityRepository,  PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.authorityRepository = authorityRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void add(User user, UserRole role) throws UserAlreadyExistException {
        if (userRepository.existsById(user.getUsername())) {
            throw new UserAlreadyExistException("User already exists");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEnabled(true);
        userRepository.save(user);
        authorityRepository.save(new Authority(user.getUsername(), role.name()));
    }

}
