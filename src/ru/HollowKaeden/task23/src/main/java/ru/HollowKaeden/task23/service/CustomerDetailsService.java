package ru.HollowKaeden.task23.service;

import ru.HollowKaeden.task23.config.CustomerDetails;
import ru.HollowKaeden.task23.entity.Customer;
import ru.HollowKaeden.task23.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerDetailsService implements UserDetailsService {
    @Autowired
    private CustomerRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Customer> customer = repository.findByName(username);
        return customer.map(CustomerDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException(username + "не найден"));
    }

}
