package com.metrics.controller;




import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
/**
 * @Author : RASHMI
 **/

public class MyRVRestController {

    @Autowired
    MeterRegistry meterRegistry;

   /* @Autowired
    RVMiroCounters RVmyConters;*/

    private static final String ABC_ROOT 	= "/ABC/v1/";

     @RequestMapping(value = ABC_ROOT + "{myAppId}/configurations/{id}", method = RequestMethod.GET, produces = "application/json")


    public ResponseEntity<Object> getNiddConfigurations(@PathVariable(name = "myAppId") String myAppId, @PathVariable(name = "id") String id) {



        if (Integer.valueOf(id) == 1) {
               return createProblem(HttpStatus.FORBIDDEN, "FORBIDDEN");
          }
        else     if (Integer.valueOf(id) == 2) {
              return createProblem(HttpStatus.FORBIDDEN, "FORBIDDEN");
          }
          else     if (Integer.valueOf(id) == 3) {
              return createProblem(HttpStatus.BAD_REQUEST, "BAD_REQUEST5");
          }
          else     if (Integer.valueOf(id) == 4) {
              return createProblem(HttpStatus.CONFLICT, "CONFLICT");
          }
          else     if (Integer.valueOf(id) == 5) {
              return createProblem(HttpStatus.NO_CONTENT, "NO_CONTENT");
          }
          else     if (Integer.valueOf(id) == 6) {
              return createProblem(HttpStatus.UNAUTHORIZED, "UNAUTHORIZED");
          }
          else     if (Integer.valueOf(id) == 6) {
              return createProblem(HttpStatus.MULTI_STATUS, "UNAUTHORIZED");
          }
          else {
              return ResponseEntity.ok().body("DL SUCCESS"+myAppId+"instanceID:"+id );
          }

    }

   /* @Timed(value = "RV_DL",histogram = true,percentiles = {0.95,0.99},
            extraTags = { "myAppId","myAppId" })*/
    /*    @Timed(value = "RV.dl.counter.requests",histogram = true,percentiles = {0.95,0.99},
            extraTags = { "status","myAppId" },longTask = true)*/
     @RequestMapping(value = ABC_ROOT + "{myAppId}/dl/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Object> findtNiddConfigurations(@PathVariable(name = "myAppId") String myAppId, @PathVariable(name = "id") String id) {
        Timer.Sample sample = Timer.start(meterRegistry);
        ResponseEntity response;
        if (Integer.valueOf(id) == 1) {
            response= createProblem(HttpStatus.FORBIDDEN, "FORBIDDEN");
        }
        else     if (Integer.valueOf(id) == 2) {
            response= createProblem(HttpStatus.FORBIDDEN, "FORBIDDEN");
        }
        else     if (Integer.valueOf(id) == 3) {
            response= createProblem(HttpStatus.BAD_REQUEST, "BAD_REQUEST5");
        }
        else     if (Integer.valueOf(id) == 4) {
            response= createProblem(HttpStatus.CONFLICT, "CONFLICT");
        }
        else     if (Integer.valueOf(id) == 5) {
            response= createProblem(HttpStatus.NO_CONTENT, "NO_CONTENT");
        }
        else     if (Integer.valueOf(id) == 6) {
            response= createProblem(HttpStatus.UNAUTHORIZED, "UNAUTHORIZED");
        }
        else     if (Integer.valueOf(id) == 6) {
            response= createProblem(HttpStatus.MULTI_STATUS, "UNAUTHORIZED");
        }
        else {
            response= ResponseEntity.ok().body("DL SUCCESS "+myAppId+"instanceID:"+id );
        }
        sample.stop(meterRegistry.timer("MYAPP.metrics.RVDL.count", "scsId", myAppId,"statusCode",response.getStatusCode().toString()  ));
        return response;
    }
/*


    @Timed(value = "RV.ul.counter.requests",histogram = true,percentiles = {0.95,0.99},
            extraTags = { "status","myAppId" },longTask = true)
*/


    @RequestMapping(value = ABC_ROOT + "{myAppId}/ul/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Object> uploadNiddConfigurations(@PathVariable(name = "myAppId") String myAppId, @PathVariable(name = "id") String id) {
        Timer.Sample sample = Timer.start(meterRegistry);
        ResponseEntity response;
        if (Integer.valueOf(id) == 1) {
            response= createProblem(HttpStatus.FORBIDDEN, "FORBIDDEN");
        }
        else     if (Integer.valueOf(id) == 2) {
            response=  createProblem(HttpStatus.FORBIDDEN, "FORBIDDEN");
        }
        else     if (Integer.valueOf(id) == 3) {
            response=  createProblem(HttpStatus.BAD_REQUEST, "BAD_REQUEST5");
        }
        else     if (Integer.valueOf(id) == 4) {
            response=  createProblem(HttpStatus.CONFLICT, "CONFLICT");
        }
        else     if (Integer.valueOf(id) == 5) {
            response=  createProblem(HttpStatus.NO_CONTENT, "NO_CONTENT");
        }
        else     if (Integer.valueOf(id) == 6) {
            response=  createProblem(HttpStatus.UNAUTHORIZED, "UNAUTHORIZED");
        }
        else     if (Integer.valueOf(id) == 6) {
            response=  createProblem(HttpStatus.MULTI_STATUS, "UNAUTHORIZED");
        }
        else {
            response=  ResponseEntity.ok().body("UL SUCCESS "+myAppId+"instanceID:"+id );

        }
System.out.println("rashmi before setting my custome Timer-->");
        sample.stop(meterRegistry.timer("rashmi.timer", "scsId", myAppId.toString(),"statusCode",response.getStatusCode().toString()));

        System.out.println("rashmi after stooping the TIMER setting my custome Timer-->");

        return response;
    }


    @RequestMapping(value = ABC_ROOT + "{myAppId}/uld/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Object> uploadDataNiddConfigurations(@PathVariable(name = "myAppId") String myAppId, @PathVariable(name = "id") String id) {
        if (Integer.valueOf(id) == 1) {
            return createProblem(HttpStatus.FORBIDDEN, "FORBIDDEN");
        }
        else     if (Integer.valueOf(id) == 2) {
            return createProblem(HttpStatus.FORBIDDEN, "FORBIDDEN");
        }
        else     if (Integer.valueOf(id) == 3) {
            return createProblem(HttpStatus.BAD_REQUEST, "BAD_REQUEST5");
        }
        else     if (Integer.valueOf(id) == 4) {
            return createProblem(HttpStatus.CONFLICT, "CONFLICT");
        }
        else     if (Integer.valueOf(id) == 5) {
            return createProblem(HttpStatus.NO_CONTENT, "NO_CONTENT");
        }
        else     if (Integer.valueOf(id) == 6) {
            return createProblem(HttpStatus.UNAUTHORIZED, "UNAUTHORIZED");
        }
        else     if (Integer.valueOf(id) == 6) {
            return createProblem(HttpStatus.MULTI_STATUS, "UNAUTHORIZED");
        }
        else {
            return ResponseEntity.ok().body("ULD SUCCESS "+myAppId+"instanceID:"+id );
        }

    }

      @RequestMapping(value = ABC_ROOT + "{myAppId}/dld/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Object> downloadDataNiddConfigurations(@PathVariable(name = "myAppId") String myAppId, @PathVariable(name = "id") String id) {
        if (Integer.valueOf(id) == 1) {
            return createProblem(HttpStatus.FORBIDDEN, "FORBIDDEN");
        }
        else     if (Integer.valueOf(id) == 2) {
            return createProblem(HttpStatus.FORBIDDEN, "FORBIDDEN");
        }
        else     if (Integer.valueOf(id) == 3) {
            return createProblem(HttpStatus.BAD_REQUEST, "BAD_REQUEST5");
        }
        else     if (Integer.valueOf(id) == 4) {
            return createProblem(HttpStatus.CONFLICT, "CONFLICT");
        }
        else     if (Integer.valueOf(id) == 5) {
            return createProblem(HttpStatus.NO_CONTENT, "NO_CONTENT");
        }
        else     if (Integer.valueOf(id) == 6) {
            return createProblem(HttpStatus.UNAUTHORIZED, "UNAUTHORIZED");
        }
        else     if (Integer.valueOf(id) == 6) {
            return createProblem(HttpStatus.MULTI_STATUS, "UNAUTHORIZED");
        }
        else {
            return ResponseEntity.ok().body("ULD SUCCESS "+myAppId+"instanceID:"+id );
        }

    }
    private ResponseEntity<Object> createProblem(HttpStatus httpStatus, String details) {
        ProblemDetails body = new ProblemDetails();
        body.setStatus(httpStatus.value());
        body.setDetails(details);
        return ResponseEntity.status(httpStatus).body(body);
    }


     @RequestMapping(value = ABC_ROOT + "{myAppId}/configurations", method = RequestMethod.GET)
    public ResponseEntity<Object> createNiddConfiguration(@PathVariable(name = "myAppId") String myAppId) {

         if (myAppId.equals("25") ) {
            return badRequest("Either msidn or externalId needs to be provided");
        }
        if (myAppId.equals("35") ) {
            return ResponseEntity.ok().body("SUCCESS CASEE!!!!!");
        }
         if(myAppId.equals("75")) {
            return createProblem(HttpStatus.CONFLICT, "Nidd Configuration already exists for the externalId or msisdns");
        }

        try {
          //  NIA nia = s.writeRequest(nir).get(60, TimeUnit.SECONDS);
            return createProblem(HttpStatus.FORBIDDEN, "success CASE still returning error");
            }
         catch (Exception e) {
            return createProblem(HttpStatus.INTERNAL_SERVER_ERROR, "internal error: " + e.getMessage());
        }
    }

    private ResponseEntity<Object> badRequest(String details) {
        return createProblem(HttpStatus.BAD_REQUEST, details);
    }


    @RequestMapping(method = RequestMethod.GET, value="/get/metrics")

    @ResponseBody
     public ResponseEntity<Object> getMymetrics(String myLocalVariable)   {


            return ResponseEntity.ok().body(myLocalVariable);

    }


}
