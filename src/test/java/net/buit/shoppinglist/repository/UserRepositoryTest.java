package net.buit.shoppinglist.repository;

import net.buit.shoppinglist.model.AuthProvider;
import net.buit.shoppinglist.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    TestEntityManager testEntityManager;

    @Autowired
    UserRepository userRepository;

    @Test
    public void findByEmail_none_found() {
        getFilledAndSavedUser("Test1", "test1@test.com");
        getFilledAndSavedUser("Test2", "test2@test.com");

        Optional<User> foundUser = userRepository.findByEmail("test3@test.com");

        assertThat(foundUser.isPresent()).isFalse();
    }

    @Test
    public void findByEmail_none_one() {
        getFilledAndSavedUser("Test1", "test1@test.com");
        User user2 = getFilledAndSavedUser("Test2", "test2@test.com");

        Optional<User> foundUser = userRepository.findByEmail("test2@test.com");

        assertThat(foundUser.isPresent()).isTrue();
        assertThat(foundUser.get().getEmail()).isEqualTo(user2.getEmail());
    }

    @Test
    public void existsByEmail_none_found() {
        getFilledAndSavedUser("Test1", "test1@test.com");
        getFilledAndSavedUser("Test2", "test2@test.com");

        boolean exists = userRepository.existsByEmail("test3@test.com");

        assertThat(exists).isFalse();
    }

    @Test
    public void existsByEmail_none_one() {
        getFilledAndSavedUser("Test1", "test1@test.com");
        User user2 = getFilledAndSavedUser("Test2", "test2@test.com");

        boolean exists = userRepository.existsByEmail("test2@test.com");

        assertThat(exists).isTrue();
    }

    private User getFilledAndSavedUser(String name, String email)
    {
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setEmailVerified(false);
        user.setProvider(AuthProvider.google);

        testEntityManager.persistAndFlush(user);

        return user;
    }
}
