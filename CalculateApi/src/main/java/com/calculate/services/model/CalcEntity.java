package com.calculate.services.model;

import java.util.HashMap;
import java.util.Map;

public class CalcEntity {
	private String serviceAddress;
	private String  expressionsForCalculate;
	private Map parametrs;
	
	public String getExpressionsForCalculate() {
		return expressionsForCalculate;
	}

	public void setExpressionsForCalculate(String expressionsForCalculate) {
		this.expressionsForCalculate = expressionsForCalculate;
	}

	
	

    /**
     * 
     * @return
     *     The serviceAddress
     */
    public String getServiceAddress() {
        return serviceAddress;
    }

    /**
     * 
     * @param serviceAddress
     *     The serviceAddress
     */
    public void setServiceAddress(String serviceAddress) {
        this.serviceAddress = serviceAddress;
    }
    
    public Map getParametrs() {
        return this.parametrs;
    }

    public void setParametrs(Map parametrs) {
        this.parametrs=parametrs;
    }


}
