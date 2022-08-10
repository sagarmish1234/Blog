package com.project.blogserver.service;

import com.project.blogserver.entiity.UserEntity;
import com.project.blogserver.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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

    public List<UserEntity> loadUsersByName(String name) throws Exception{
        Optional<List<UserEntity>> users = userRepository.findByFullNameIgnoreCaseContaining(name);
        if(users.isPresent() && !(users.get().isEmpty())){
            return users.get();
        }
        throw new Exception("No users with the given name found");
    }

    public UserEntity saveUser(UserEntity user) {
        user.setCreatedAt(new Date());
        return userRepository.save(user);
    }

    public void deleteUserById(Long id){
        userRepository.deleteById(id);
    }

    public UserEntity updateUserById(Long id, UserEntity newUserEntity) throws Exception{
        UserEntity userEntity = this.loadUserById(id);
        userEntity.setArticles(newUserEntity.getArticles());
        userEntity.setCreatedAt(newUserEntity.getCreatedAt());
        userEntity.setFullName(newUserEntity.getFullName());
        userEntity.setPassword(newUserEntity.getPassword());
        userEntity.setPhone(newUserEntity.getPhone());
        userEntity.setEmail(newUserEntity.getEmail());
        userEntity.setRole(newUserEntity.getRole());
        return userEntity;
    }

    public UserEntity updateUserByUsername(String username,UserEntity newUserEntity) throws Exception{
        Optional<UserEntity> userEntity = userRepository.findByEmail(username);
        if(userEntity.isPresent()){
            userEntity.get().setArticles(newUserEntity.getArticles());
            userEntity.get().setCreatedAt(newUserEntity.getCreatedAt());
            userEntity.get().setFullName(newUserEntity.getFullName());
            userEntity.get().setPassword(newUserEntity.getPassword());
            userEntity.get().setPhone(newUserEntity.getPhone());
            userEntity.get().setEmail(newUserEntity.getEmail());
            userEntity.get().setRole(newUserEntity.getRole());
            return userEntity.get();
        }
        throw new Exception("No user found");

    }

}
