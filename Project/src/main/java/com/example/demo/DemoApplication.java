package com.example.demo;

import com.example.demo.dao.AppDAO;
import com.example.demo.entity.Category;
import com.example.demo.entity.Product;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
//    @Bean
//    public CommandLineRunner commandLineRunner(AppDAO appDAO){
//        return runner->{
//            createCategoryWithProduct(appDAO);
//        };
//    }
//
//    private void createCategoryWithProduct(AppDAO appDAO) {
//        Category tempCategory = new Category(1,"abc.jpg","Tivi-1");
//        Product tempProduct = new Product("SONY","abc.jpg","dsad",12354,"dasd",0);
//        Product tempProduct1 = new Product("SONY2","abc.jpgd","dsadwd",123254,"dasddd",1);
//        tempCategory.add(tempProduct);
//        tempCategory.add(tempProduct1);
//        appDAO.save(tempCategory);
//        System.out.println("DA XONG");
//    }
}
