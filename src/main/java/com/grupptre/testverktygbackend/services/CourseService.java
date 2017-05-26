/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupptre.testverktygbackend.services;

import com.grupptre.testverktygbackend.models.Test;
import com.grupptre.testverktygbackend.repository.CourseRepository;
import java.util.List;

/**
 *
 * @author hampus
 */
public class CourseService {
    
      CourseRepository cr = new CourseRepository();
    
   public List<Test>getTestsFromCourse(int id){
      return cr.getTestsFromCourse(id);
    }
}
