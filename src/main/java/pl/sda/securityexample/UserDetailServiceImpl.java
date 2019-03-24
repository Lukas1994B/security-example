package pl.sda.securityexample;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    private List<User> users = Arrays.asList(
            new User("user1", "pass1"),
            new User("user2", "pass2"),
            new User("user3", "pass3"),
            new User("user4", "pass4")
    );



    @Override
    public UserDetails loadUserByUsername(String userName)
            throws UsernameNotFoundException {
       return users.stream()
                .filter(user -> userName.equals(user.getUsername()))
                .findFirst()
                .orElseThrow(() -> new UsernameNotFoundException("No such user: " + userName));
    }
}
