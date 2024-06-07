package miu.edu.cs.demomongo;

import lombok.RequiredArgsConstructor;
import miu.edu.cs.demomongo.model.Account;
import miu.edu.cs.demomongo.model.User;
import miu.edu.cs.demomongo.repo.AccountRepository;
import miu.edu.cs.demomongo.repo.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

import static java.util.Arrays.stream;

@SpringBootApplication
@RequiredArgsConstructor
public class DemoMongoApplication implements CommandLineRunner {
    private final AccountRepository accountRepository;
    private final UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(DemoMongoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        User user1 = new User( "usr_1",  "john.doe",  "password123");
        Account account1 = new Account( "acc_1",  "Savings Account",  "bank");
        Account account2 = new Account("acc_2",  "Social Media Profile",  "social");
        user1.setAccounts(List.of(account1, account2));
        accountRepository.save(account1); accountRepository.save(account2);
        System.out.println(userRepository.save(user1));
        User user2 = new User("usr_2",  "brightlsom",  "password456");
        Account account3 = new Account( "acc_3", "Savings Account",  "bank");
        Account  account4 = new Account( "acc_4",  "Current Account", "current");
        user2.setAccounts(List.of(account3, account4));
        accountRepository.save(account3);
        accountRepository.save(account4);
        System.out.println(userRepository.save(user2));
        userRepository.findAll()
                .stream()
                .forEach(System.out::println);
        System.out.println(userRepository.findByUsername("john.doe"));
        System.out.println(userRepository.findUserBasedOnName("john.doe"));
        System.out.println(accountRepository.findUserAccountBasedOnNameType("Savings Account", "bank"));




        }
}
