package com.onlinegasbooking.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.onlinegasbooking.entity.Cylinder;


/*******************************
 *          @author          Sakshi Gondole
 *          Description      It is a Cylinder - Service class. It provides service 
 *                           methods for adding and updating Cylinder data.
 *          Version          1.0     
 *          Created Date     11 - March - 2021
 ********************************/

public interface CylinderService {
	
	public Cylinder addCylinder(Cylinder cylinder,Integer cid);
	public Cylinder updateCylinder(Cylinder cylinder);
	public Cylinder deleteCylinderBYId(Integer cylinderTypeId);

}
