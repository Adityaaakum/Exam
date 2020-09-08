package com.capgem;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;

import com.capgem.controller.ExamController;
@Profile("test")
public class TestCases {

	
	       @Test
          public void test()
          {
        	  
	    	   ExamController controller= new ExamController();
	    	  
	    	           String result  =controller.getExamTime();
	    	           
	    	          
	    	           assertEquals(result, "sucessfully application started");
	    	   
          }
          
          
    
   
   
   
   
   
	
}
