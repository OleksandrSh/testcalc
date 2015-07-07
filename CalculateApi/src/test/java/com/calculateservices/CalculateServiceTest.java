package com.calculateservices;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonMappingException;
import org.junit.Test;

import com.calculate.services.CalculateService;
import com.calculate.services.model.CalcEntity;
import com.owlike.genson.Genson;


public class CalculateServiceTest {

	@Test
	public void testCalculate() throws  Exception {
		CalculateService calc= new CalculateService();
		CalcEntity  request=new CalcEntity();
		request.setExpressionsForCalculate("2+2");
		assertEquals("4", calc.getDatas(request));
		request.setExpressionsForCalculate("22+22+22+22+22");
		assertEquals("110", calc.getDatas(request));
		request.setExpressionsForCalculate("55/66-132*11+555");
		assertEquals("-897 ",calc.getDatas(request));
		request.setExpressionsForCalculate("200*66-132*11+555");
		assertEquals("12303", calc.getDatas(request));
	}


	
	
	
	
	
}
