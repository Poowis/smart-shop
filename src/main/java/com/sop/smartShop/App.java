package com.sop.smartShop;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import com.sop.doll.DollCollection;
import com.sop.doll.DollFactory;
import com.sop.doll.Doll;


@SpringBootApplication
@RestController
@EnableAutoConfiguration
public class App {

	DollCollection stock;

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	public App() {
		super();
		stock = new DollCollection();
		stock.add(DollFactory.create());
		stock.add(DollFactory.create());
	}

	@RequestMapping(value = "rm/{text}", method = RequestMethod.GET)
	public String rmg(@PathVariable("text") String text) {
		return String.format("{\"message\":\"rmg %s\"}", text);

	}

	@RequestMapping(value = "rm/{text}", method = RequestMethod.POST)
	public String rmp(@PathVariable("text") String text) {
		return String.format("{\"message\":\"rmp %s\"}", text);

	}

	@GetMapping(value = "g/{text}")
	public String g(@PathVariable("text") String text) {
		return String.format("{\"message\":\"g %s\"}", text);

	}

	@GetMapping(value = "/")
	public List<Doll> list() {
		return stock.getList();

	}
	
	@PostMapping(value = "/buy")
	public void buy(@RequestParam("id") int id) {
		System.out.print(id);
		stock.removeById(id);

	}
}