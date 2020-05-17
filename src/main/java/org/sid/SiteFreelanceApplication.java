package org.sid;

import java.util.Random;

import org.sid.dao.CategoryRepository;
import org.sid.dao.ProductRepository;
import org.sid.entities.Category;
import org.sid.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import net.bytebuddy.utility.RandomString;

@SpringBootApplication
public class SiteFreelanceApplication implements CommandLineRunner {
	@Autowired
	private ProductRepository p;
	@Autowired
	private CategoryRepository c;

	public static void main(String[] args) {
		SpringApplication.run(SiteFreelanceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		c.save(new Category(null, "Computers", null, null));
		c.save(new Category(null, "Printers", null, null));
		c.save(new Category(null, "SmartPhone", null, null));
		c.findAll().forEach(cc -> {
			for (int i = 0; i < 10; i++) {
				Random rnd = new Random();
				Product pp = new Product();
				pp.setAvailable(rnd.nextBoolean());
				pp.setPromotion(rnd.nextBoolean());
				pp.setName(RandomString.make(6));
				pp.setCategory(cc);
				pp.setCurrentPrice(100 + rnd.nextInt(1000));
				p.save(pp);
			}

		});
	}

}
