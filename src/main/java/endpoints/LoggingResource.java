package endpoints;

import database.Database;
import models.Log;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("logging")
public class LoggingResource {

    @GET
    public Response getAllLogs() {
        List<Log> customers = Database.getLogs();
        return Response.ok(customers).build();
    }

    @GET
    @Path("{logId}")
    public Response getLog(@PathParam("logId") int logId) {
        Log log = Database.getLog(logId);
        return log != null ? Response.ok(log).build() : Response.status(Response.Status.NOT_FOUND).build();
    }

    @POST
    public Response addLog(Log log) {
        Database.addLog(log);
        return Response.noContent().build();
    }

    @DELETE
    @Path("{logId}")
    public Response deleteLog(@PathParam("logId") int logId) {
        Database.deleteLog(logId);
        return Response.noContent().build();
    }
}