package com.calculate.services;

import org.apache.log4j.Logger;

import com.calculate.services.calcmanager.CalcManager;
import com.calculate.services.model.CalcEntity;


import javax.ws.rs.*;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;



@Path("calculate")
public class CalculateService extends AbstractService {
    private static final Logger Log = Logger.getLogger(CalculateService.class);

    


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	@Path("all")
    public Response  getDatas(CalcEntity request) {
    	Object result = null;
    try {
		   result = new CalcManager().getCalc(request);
		} catch (Exception e) {
			Log.error(e.getMessage(), e);
			result = createErrorMessage(e.getMessage());
			return Response.status(Status.INTERNAL_SERVER_ERROR)
					.type(MediaType.APPLICATION_JSON).entity(result).build();
		}
		return Response.status(Status.OK).type(MediaType.APPLICATION_JSON)
				.entity(result).build();
    }

    


	

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("deleteeall")
    public Response hideAllNoteLogsData(@QueryParam("delete") boolean hide) {
        try {
          /* doing delete something */
        } catch (Exception e) {
            Log.error(e.getMessage(), e);
            return Response.status(Response.Status.NOT_FOUND).type(MediaType.APPLICATION_JSON).entity(createErrorMessage(e.getMessage())).build();
        }

        return Response.status(Response.Status.OK).build();
    }

}
