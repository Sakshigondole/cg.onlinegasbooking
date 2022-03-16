package com.onlinegasbooking.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlinegasbooking.entity.Cylinder;
import com.onlinegasbooking.entity.SurrenderCylinder;

/*******************************
 *          @author          Sakshi Gondole
 *          Description      It is a repository class that provides the JPA Repository for   
 *                           Cylinder.      
 *         Version           1.0     
 *         Created Date      08 - March - 2021
 ********************************/
@Repository
public interface CylinderRepository extends JpaRepository<Cylinder, Integer> {


}
