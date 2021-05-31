package com.todo.yolo.services;

import com.todo.yolo.domain.Authority;
import com.todo.yolo.domain.TodoUser;
import com.todo.yolo.repositories.AuthorityRepository;
import com.todo.yolo.repositories.TodoUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class AuthService implements UserDetailsService {

    @Autowired
    TodoUserRepository todoUserRepository;

    @Autowired
    AuthorityRepository authorityRepository;

    @Autowired
    PasswordEncoder passwordEncoder;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return todoUserRepository.findUserByUsername(username);
    }

    public void registerNewTodoUser(TodoUser todoUser){
        Authority authority=authorityRepository.findAuthorityByAuthority("USER");

        Authority[] authorities= new Authority[]{authority};

        todoUser.setUsername(todoUser.getUsername());
        todoUser.setAuthorities(Arrays.asList(authorities));

        todoUser.setEnabled(true);
        todoUser.setAccountNonExpired(true);
        todoUser.setAccountNonLocked(true);
        todoUser.setCredentialsNonExpired(true);

        todoUser.setPassword(passwordEncoder.encode(todoUser.getPassword()));

        todoUserRepository.save(todoUser);

    }
}
