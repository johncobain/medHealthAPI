package br.edu.ifba.inf015.medHealthAPI.services;

import br.edu.ifba.inf015.medHealthAPI.dtos.user.UserFormDto;
import br.edu.ifba.inf015.medHealthAPI.models.entities.User;
import br.edu.ifba.inf015.medHealthAPI.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User register(UserFormDto userForm){
        User user = new User(userForm);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
}
