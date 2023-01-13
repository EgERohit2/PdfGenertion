package com.example.demo.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Employee;
import com.example.demo.service.EmployeeServiceImplementation;
import com.example.demo.util.PdfGenerator;
import com.lowagie.text.DocumentException;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeServiceImplementation employeeServiceImplementation;

//	@GetMapping()
//	public List<Employee> getAllData() {
//		return employeeServiceImplementation.getAll();
//	}

	@PostMapping()
	public String postAllData(@RequestBody Employee employee) {
		employeeServiceImplementation.postAll(employee);
		return "posted";
	}

	@GetMapping()
	public void generateFile(HttpServletResponse response) throws DocumentException, IOException {
		response.setContentType("application/pdf");
	    DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD:HH:MM:SS");
	    String currentDateTime = dateFormat.format(new Date());
	    String headerkey = "Content-Disposition";
	    String headervalue = "attachment; filename=student" + currentDateTime + ".pdf";
	    response.setHeader(headerkey, headervalue);
	    List<Employee> listOfEmployee = employeeServiceImplementation.getAll();
	    PdfGenerator generator = new PdfGenerator();
	    generator.generate(listOfEmployee, response);
	    
	}
	@PutMapping("/{id}")
	public String updateAllData(@RequestBody Employee employee, @PathVariable int id) {
		employeeServiceImplementation.updateAll(employee, id);
		return "updated";
	}
	
	@DeleteMapping("/{id}")
	public String deleteAllData(@PathVariable int id) {
		employeeServiceImplementation.deleteAll(id);
		return "deleted";
	}
}
