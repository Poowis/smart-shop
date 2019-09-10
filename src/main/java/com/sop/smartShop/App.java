package com.sop.smartShop;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.google.gson.Gson;
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

		try {
			FileOutputStream fileOut = new FileOutputStream(new File("text"));
			ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
			objectOut.writeObject(stock);
			objectOut.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//		Gson gson = new Gson();
//		String json = gson.toJson(stock);
//		ProductCollection user = gson.fromJson(json, ProductCollection.class);
//		System.out.println(json);
//		System.out.println(stock.getList().get(0));
//		System.out.println(user.getList().get(0).get("product").getClass());
////		ArrayList asd = gson.fromJson(user.getList(), ArrayList.class);
//		System.out.println();
////		System.out.println(user.get(0));
	}

	@GetMapping(value = "/")
	public ArrayList<HashMap<String, Object>> list() {
		return stock.getList();
	}
	
	@PostMapping(value = "/set")
	public void setList(@RequestBody ArrayList<HashMap<String, Object>> list) {
		System.out.println(stock.getList());
		stock.setList(list);
		System.out.println(stock.getList());
		System.out.println(stock.get(0));
	}

	@GetMapping(value = "/orderedlist")
	public ResponseEntity<ArrayList<HashMap<String, Object>>> orderedList() {
		System.out.print(
				new ResponseEntity<ArrayList<HashMap<String, Object>>>(ordered.getList(), HttpStatus.OK).toString());
		return new ResponseEntity<ArrayList<HashMap<String, Object>>>(ordered.getList(), HttpStatus.OK);
	}

	@PostMapping(value = "/order")
	public String order(@RequestParam("id") int id) {
		Product temp = stock.remove(id);
		if (temp != null) {
			temp.setStatus("purchased");
			ordered.add(temp);
			return "Your order has been completed. check your order at /orderedList";
		} else {
			return "your order product is not exist";
		}

	}
}