package com.sop.smartShop;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import com.sop.doll.DollFactory;
import com.sop.product.Product;
import com.sop.product.ProductCollection;

@SpringBootApplication
@RestController
@EnableAutoConfiguration
public class App {

	ProductCollection stock;
	ProductCollection ordered;

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	public App() {
		super();
		stock = new ProductCollection("product");
		ordered = new ProductCollection("orderded");

		stock.add(new Product(DollFactory.create(), "in stock", 499.00));
		stock.add(new Product(DollFactory.create("racecar", "vehicle", "car", "red"), "in stock", 299.00));
		stock.add(new Product(DollFactory.create("airplane", "vehicle", "plane", "white"), "in stock", 399.00));
	}

	@GetMapping(value = "/")
	public ArrayList<HashMap<String, Object>> list() {
		return stock.getList();
	}

	@GetMapping(value = "/orderedlist")
	public ArrayList<HashMap<String, Object>> orderedList() {
		return ordered.getList();
	}

	@PostMapping(value = "/order")
	public String order(@RequestParam("id") int id) {
		Product temp = stock.pop(id);
		if (temp != null) {
			temp.setStatus("purchased");
			ordered.add(temp);
			return "Your order has been completed. check your order at /orderedList";
		} else {
			return "your order product is not exist";
		}

	}
}