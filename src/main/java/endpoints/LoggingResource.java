package endpoints;

import database.Database;
import models.LogEntity;
import models.LogModel;
import services.SecretsService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("logging")
public class LoggingResource {

    private SecretsService secretsService;

    public LoggingResource() {
        this.secretsService = new SecretsService();
    }

    @GET
    public Response getAllLogs() {
        List<LogEntity> logs = Database.getLogs();
        return Response.ok(logs).build();
    }

    @GET
    @Path("{startDateString}/{endDateString}")
    public Response getAllLogsFromStartdateToEnddate(@PathParam("startDateSting") String startDateString,
            @PathParam("endDateString") String endDateString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        LocalDate startDate = LocalDate.parse(startDateString, formatter);
        LocalDate endDate = LocalDate.parse(endDateString, formatter);

        List<LogEntity> logs = Database.getLogsFromStartdateToEnddate(startDate, endDate);
        return Response.ok(logs).build();
    }

    @GET
    @Path("{logId}")
    public Response getLog(@PathParam("logId") int logId) {
        LogEntity log = Database.getLog(logId);
        return log != null ? Response.ok(log).build() : Response.status(Response.Status.NOT_FOUND).build();
    }

    @POST
    @Path("/{sourceSecret}")
    public Response addLog(LogModel logModel, @PathParam("sourceSecret") String sourceSecret) {
        if (this.secretsService.isValidKey(logModel.getSource(), sourceSecret)) {
            LogEntity logEntity = new LogEntity(logModel.getMessage(), logModel.getSource());
            Database.addLog(logEntity);
            return Response.noContent().build();
        } else {
            return Response.status(Response.Status.NOT_ACCEPTABLE).build();
        }
    }

    @DELETE
    @Path("{logId}")
    public Response deleteLog(@PathParam("logId") int logId) {
        Database.deleteLog(logId);
        return Response.noContent().build();
    }
}