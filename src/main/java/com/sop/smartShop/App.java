package com.sop.smartShop;

import java.util.ArrayList;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sop.toy.Doll;
import com.sop.toy.DollCollection;

@SpringBootApplication
@RestController
@EnableAutoConfiguration
public class App {

	private static final String PATH = "doll.json";
	DollCollection dc;

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	public App() {
		super();
		dc = DollCollection.getInstance();
		dc.setPath(PATH);
	}

	@GetMapping(value = "/")
	public ResponseEntity<ArrayList<Doll>> getList() {
		return new ResponseEntity<ArrayList<Doll>>(dc.getList(), HttpStatus.OK);
	}
	
	@GetMapping(value = "/{index}")
	public ResponseEntity<Doll> getDoll(@PathVariable int index) {
		return new ResponseEntity<Doll>(dc.getDoll(index), HttpStatus.OK);
	}
	
	@PostMapping(value = "/create")
	public ResponseEntity<Doll> createDoll(@RequestBody Doll doll) {
		return new ResponseEntity<Doll>(dc.createDoll(doll), HttpStatus.OK);
	}
	
	@PutMapping(value = "/update/{index}")
	public ResponseEntity<Doll> updateDoll(@PathVariable int index, @RequestBody Doll doll) {
		return new ResponseEntity<Doll>(dc.updateDoll(index, doll), HttpStatus.OK);
	}
	
	@PostMapping(value = "/delete/{index}")
	public ResponseEntity<Doll> deleteDoll(@PathVariable int index) {
		return new ResponseEntity<Doll>(dc.removeDoll(index), HttpStatus.OK);
	}


}