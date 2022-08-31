package com.blogserver.authservice.service;

import com.blogserver.authservice.entity.UserEntity;
import com.blogserver.authservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserEntity> user = userRepository.findByEmail(username);
        if(user.isPresent()){
            return new User(user.get().getEmail(),user.get().getPassword(),new ArrayList<>());
        }
        throw new UsernameNotFoundException("User not found");
    }

    public UserEntity loadUserById(Long id) throws UsernameNotFoundException{
        Optional<UserEntity> user = userRepository.findById(id);
        if(user.isPresent()){
            return user.get();
        }
        throw new UsernameNotFoundException("User not found");
    }

    public UserEntity loadUserByEmail(String email) throws Exception{
        Optional<UserEntity> user = userRepository.findByEmail(email);
        if(user.isPresent()){
            return user.get();
        }
        throw new Exception("User not found");
    }

    public List<UserEntity> loadUsersByName(String name) throws Exception{
        Optional<List<UserEntity>> users = userRepository.findByFullNameIgnoreCaseContaining(name);
        if(users.isPresent() && !(users.get().isEmpty())){
            return users.get();
        }
        throw new Exception("No users with the given name found");
    }

    public UserEntity saveUser(UserEntity user) {
        user.setCreatedAt(new Date());
        user.setRole("User");
        return userRepository.save(user);
    }

    public void deleteUserById(Long id) throws Exception{
        UserEntity user = this.loadUserById(id);
        userRepository.deleteById(id);
    }

    public UserEntity updateUserById(Long id, UserEntity newUserEntity) throws Exception{
        UserEntity userEntity = this.loadUserById(id);
        if(!userEntity.getEmail().equals(newUserEntity.getEmail()))
            throw new Exception("Not authorized to update");
        userEntity.setFullName(newUserEntity.getFullName());
        userEntity.setPassword(newUserEntity.getPassword());
        userEntity.setPhone(newUserEntity.getPhone());
        userEntity.setImage(newUserEntity.getImage());
        return userEntity;
    }

    public UserEntity updateUserByUsername(String username,UserEntity newUserEntity) throws Exception{
        Optional<UserEntity> userEntity = userRepository.findByEmail(username);
        if (!userEntity.isPresent()) {
            throw new Exception("No user found");
        }
        if (!userEntity.get().getEmail().equals(newUserEntity.getEmail())) {
            throw new Exception("Not authorized to update");
        }
        userEntity.get().setFullName(newUserEntity.getFullName());
        userEntity.get().setPassword(new BCryptPasswordEncoder().encode(newUserEntity.getPassword()));
        userEntity.get().setPhone(newUserEntity.getPhone());
        userEntity.get().setImage(newUserEntity.getImage());
        return userEntity.get();

    }

    public Boolean patternCheck(String big, String small) {
        if (small.length() > big.length()|| small.charAt(0)!=big.charAt(0))
            return false;
        int i = 0, j = 0;
        while (i < big.length() && j < small.length()) {
            if (big.charAt(i) == small.charAt(j)) {
                i++;
                j++;
            } else {
                i++;
            }
        }
        if (j == small.length())
            return true;
        return false;
    }

    public List<UserEntity> loadUsersStartingWith(String name) throws Exception {
        List<UserEntity> userEntity = userRepository.findAll();
        userEntity = userEntity.stream().filter(e -> patternCheck(e.getFullName().toLowerCase(), name.toLowerCase())).collect(Collectors.toList());
        if (userEntity.isEmpty()) {
            throw new Exception("No users found");
        }
        return userEntity;
    }

}