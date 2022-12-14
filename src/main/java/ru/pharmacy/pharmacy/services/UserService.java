package ru.pharmacy.pharmacy.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.pharmacy.pharmacy.entiteis.Role;
import ru.pharmacy.pharmacy.entiteis.User;
import ru.pharmacy.pharmacy.entiteis.UserEntity;
import ru.pharmacy.pharmacy.repositories.RoleRepository;
import ru.pharmacy.pharmacy.repositories.UserRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    PasswordEncoder passwordEncoder =
            PasswordEncoderFactories.createDelegatingPasswordEncoder();
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByName(username);

        if (user == null){
            throw new UsernameNotFoundException("User not found lol :>");
        }
        return user;
    }

    public UserEntity  findUserById(Long userId){
        Optional<UserEntity> userFromDb = userRepository.findById(userId);
        return userFromDb.orElse(new UserEntity());
    }

    public List<UserEntity> allUsers(){
        return userRepository.findAll();
    }
    public boolean saveUser(UserEntity user) {
        UserEntity userFromDB = userRepository.findByName(user.getName());

        if (userFromDB != null) {
            return false;
        }

        user.setRole(Collections.singleton(new Role(1L, "ROLE_USER")));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return true;
    }

    public boolean deleteUser(Long userId) {
        if (userRepository.findById(userId).isPresent()) {
            userRepository.deleteById(userId);
            return true;
        }
        return false;
    }

    public List<User> usergtList(Long idMin) {
        return em.createQuery("SELECT u FROM User u WHERE u.id > :paramId", User.class)
                .setParameter("paramId", idMin).getResultList();
    }

}
