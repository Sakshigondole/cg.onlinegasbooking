package com.onlinegasbooking.serviceimplementation;


import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinegasbooking.entity.Customer;
import com.onlinegasbooking.entity.Cylinder;
import com.onlinegasbooking.repository.CustomerRepository;
import com.onlinegasbooking.repository.CylinderRepository;
import com.onlinegasbooking.repository.SurrenderCylinderRepository;
import com.onlinegasbooking.service.CylinderService;

/*******************************
 *          @author          Sakshi Gondole
 *          Description      It is a service class that provides the services for  
                             a cylinder, fetching cylinder type and Id for a day.         
 *         Version           1.0     
 *         Created Date      08 - March - 2021
 ********************************/

@Service
public class CylinderServiceImplementation implements CylinderService{
	@Autowired
	private CylinderRepository cylinderRepository;
	
	@Autowired
	public CustomerRepository customerRespository;
	
	@Autowired
	public SurrenderCylinderRepository surrenderCylinderRepository;
	
	/********************************
 	 *  Method : addCylinder
 	 *  Description : To add the category.
 	 *  			  Used inbuilt save() method to add category .
 	 *  @param cid : category which should be added.
 	 *
 	 *Created date : 11/03/2022
*******************************/
	
	@Transactional
	public Cylinder addCylinder (Cylinder cylinder,Integer cid) {
		
		Optional<Customer> optionalCustomer = this.customerRespository.findById(cid);
		
		optionalCustomer.get().setCylinder(cylinderRepository.save(cylinder)); 
		// cylinder.setCustomer(optionalCustomer.get());
		return customerRespository.save(optionalCustomer.get()).getCylinder();
	}
	/********************************
  	 *  Method : updateCylinder
  	 *  Description : To update the category.
  	 *  			  Used inbuilt save() method to add category .
  	 *  @param cid : category which should be updated.
  	 *
  	 *Created date : 11/03/2022
     *******************************/   
	
	public Cylinder updateCylinder(Cylinder cylinder) {
		return  cylinderRepository.save(cylinder);
	}
	public Cylinder deleteCylinder(Integer cylinderTypeId) {
		return null;
		
	}
	@Override
	public Cylinder deleteCylinderBYId(Integer cylinderTypeId) {
		
		Optional<Cylinder> optionalCylinder = cylinderRepository.findById(cylinderTypeId);
		Customer customer = optionalCylinder.get().getCustomer();
		customer.setCylinder(null);
		customerRespository.save(customer);
		cylinderRepository.delete(optionalCylinder.get());
		return optionalCylinder.get();
	}
	
}


