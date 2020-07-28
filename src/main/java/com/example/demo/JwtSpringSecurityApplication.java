package com.example.demo;

import com.example.demo.dao.CategoryRepository;
import com.example.demo.dao.ProductRepository;
import com.example.demo.dao.TaskRepository;
import com.example.demo.entities.*;
import com.example.demo.services.AccountService;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Random;
import java.util.stream.Stream;

@SpringBootApplication
public class JwtSpringSecurityApplication implements CommandLineRunner {
    @Autowired
    private ProductRepository p;
    @Autowired
    private CategoryRepository c;
    @Autowired
    private RepositoryRestConfiguration repositoryRestConfiguration;

    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private AccountService accountService;
    public static void main(String[] args) {
        SpringApplication.run(JwtSpringSecurityApplication.class, args);
    }
   @Bean
   public BCryptPasswordEncoder getBCPE(){
        return new BCryptPasswordEncoder();
   }
    @Override
    public void run(String... args) throws Exception {
        accountService.saveUser(new AppUser(null,"admin","1234",null));
        accountService.saveUser(new AppUser(null,"user","1234",null));
        accountService.saveRole(new AppRole(null,"ADMIN"));
        accountService.saveRole(new AppRole(null,"USER"));
        accountService.addRoleToUse("admin","ADMIN");
        accountService.addRoleToUse("admin","USER");
        Stream.of("T1","T2","T3").forEach(t->{
          taskRepository.save(new Task(null,t));
        });
        taskRepository.findAll().forEach(t->{
            System.out.println(t.getTaskName());
        });

        repositoryRestConfiguration.exposeIdsFor(Product.class, Category.class);
        c.save(new Category(null, "Computers", null,null, null));
        c.save(new Category(null, "Printers", null,null, null));
        c.save(new Category(null, "SmartPhone", null, null, null));
        c.findAll().forEach(cc -> {
            for (int i = 0; i < 10; i++) {
                Random rnd = new Random();
                Product pp = new Product();
                pp.setAvailable(rnd.nextBoolean());
                pp.setPromotion(rnd.nextBoolean());
                pp.setName(RandomString.make(6));
                pp.setCategory(cc);
                pp.setCurrentPrice(100 + rnd.nextInt(1000));
                pp.setPhotoName("unknown.png");
                pp.setSelected(rnd.nextBoolean());
                p.save(pp);

                Order order = new Order();


            }
        });
}}