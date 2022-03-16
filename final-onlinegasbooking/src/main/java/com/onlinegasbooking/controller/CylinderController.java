package com.onlinegasbooking.controller;




import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.onlinegasbooking.entity.Customer;
import com.onlinegasbooking.entity.Cylinder;
import com.onlinegasbooking.repository.CustomerRepository;
import com.onlinegasbooking.repository.SurrenderCylinderRepository;
import com.onlinegasbooking.service.CylinderService;

/************************************************************************************
 * @author Sakshi Gondole
 * Description It is a Cylindercontroller class
 *         that provides RestMappings inorder to connect with the swagger.
 *         Version 1.0 Created 
 *         Date 11 March 2022
 ************************************************************************************/

@RestController
public class CylinderController {
	@Autowired
	private CylinderService cylinderService;

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	public SurrenderCylinderRepository surrenderCylinderRepository;
	
    //Post Methods
	//Add Customer to database
	@PostMapping("/customer")
	public Customer addCustomer(@Valid @RequestBody Customer customer) {
		return customerRepository.save(customer);
	}
	
	//Get Methods
	//Get Customer Id to database
	@GetMapping("/customer/{cid}")
	public Customer getCustomer(@Valid @PathVariable("cid") Integer cId ) {
		return customerRepository.findById(cId).get();
	}
	
    //PostMapping
	//Add Customer Id to database
	@PostMapping("/cylinder/{custid}")
	public Cylinder addCylinder(@RequestBody Cylinder cylinder, @PathVariable("custid") Integer cId) {
		return cylinderService.addCylinder(cylinder,cId);
	}
    
	//PutMapping
	//update Cylinder if it is required
	@PutMapping("/cylinder")
	public Cylinder update(@RequestBody Cylinder cylinder) {
		return cylinderService.updateCylinder(cylinder);
	}
    
	//DeleteMapping
	//Delete Cylinder if required
	@DeleteMapping("/cylinder/{cylindertypeid}")
	public Cylinder deleteCylinder(@PathVariable("cylindertypeid") Integer cylinderTypeId) {
		return cylinderService.deleteCylinderBYId(cylinderTypeId);
	}

}
