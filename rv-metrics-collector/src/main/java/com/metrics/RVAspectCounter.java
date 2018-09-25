package com.metrics;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class RVAspectCounter {


   // @Pointcut("@annotation(com.metrics.annoters.CollectDLCount)")
   @Pointcut("execution(* com.metrics.controller.MyRVRestController.findtNiddConfigurations(..))")
   private void isDownLink() {}

    //@Pointcut("@annotation(com.metrics.annoters.annoters.CollectULCount)")
    @Pointcut("execution(* com.metrics.controller.MyRVRestController.uploadNiddConfigurations(..))")

    private void isUpLink() {}

   // @Pointcut("@annotation(com.metrics.annoters.annoters.CollectDLDataCount)")
    @Pointcut("execution(* com.metrics.controller.MyRVRestController.downloadDataNiddConfigurations(..))")

    private void isDownLinkData() {}

    @Pointcut("execution(* com.metrics.controller.MyRVRestController.uploadDataNiddConfigurations(..))")

    private void isUpLinkData() {}
    @Autowired
    MeterRegistry meterRegistry;

   @Around("isDownLink()")
   public Object countAllDownLinkRequests(ProceedingJoinPoint joinPoint) throws Throwable {
       System.out.println("countAllDownLinkRequests-->ENTERED");

       ResponseEntity result;

       //If you need timer per secong how many invocations etc, you can uncomment the below Timer, else counter will give you total count
     // Timer.Sample sample = Timer.start(meterRegistry);

       try {
           result = (ResponseEntity) joinPoint.proceed();
            int statusCode=result.getStatusCode().value();

            System.out.println("rashmi before setting my custome COUNTER-->");
            meterRegistry.counter("MYAPP.RVDL", "myAppId",(String)joinPoint.getArgs()[0],"statusCode", String.valueOf(statusCode)).increment();

          // sample.stop(meterRegistry.timer("MYAPP.RVDL.metrics", "myAppId", (String)joinPoint.getArgs()[0],"statusCode",String.valueOf(statusCode) ));

            System.out.println("rashmi after stooping the TIMER setting my custome Timer-->"+ meterRegistry.counter("rv.downLINK").count());
         }
        catch (Throwable t) {

           throw t;
       }


       return result;
   }




    // @Around("inAnnotated() && isUpLink()")
   @Around("isUpLink()")
    public Object countAllUpLinkRequests(ProceedingJoinPoint joinPoint) throws Throwable {
      System.out.println("countAllUpLinkRequests-->ENTERED");

      ResponseEntity result;
    // Timer.Sample sample = Timer.start(meterRegistry);

      try {
          result = (ResponseEntity) joinPoint.proceed();
          int statusCode=result.getStatusCode().value();

          System.out.println("UP LINKrashmi before setting my custom Timer-->");
         // sample.stop(meterRegistry.timer("MYAPP.RVUL.metrics", "myAppId", (String)joinPoint.getArgs()[0],"statusCode",String.valueOf(statusCode) ));
          meterRegistry.counter("MYAPP.RVUL", "myAppId",(String)joinPoint.getArgs()[0],"statusCode", String.valueOf(statusCode)).increment();

          System.out.println("rashmi after stooping the TIMER setting my custome Timer-->");
      }
      catch (Throwable t) {

          throw t;
      }


      return result;
  }



  @Around("isDownLinkData()")
    public Object countAllDownLinkDataRequests(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("countAllDownLinkDataRequests-->ENTERED");

        ResponseEntity result;
        //Timer.Sample sample = Timer.start(meterRegistry);

        try {
            result = (ResponseEntity) joinPoint.proceed();
            int statusCode=result.getStatusCode().value();

            System.out.println("rashmi before setting my custome Timer-->");
            //sample.stop(meterRegistry.timer("MYAPP.RVDL_DATA.metrics", "myAppId", (String)joinPoint.getArgs()[0],"statusCode",String.valueOf(statusCode) ));
            meterRegistry.counter("MYAPP.RVDL_DATA", "myAppId",(String)joinPoint.getArgs()[0],"statusCode", String.valueOf(statusCode)).increment();

            System.out.println("rashmi after stooping the TIMER setting my custome Timer-->");
        }
        catch (Throwable t) {

            throw t;
        }


        return result;
    }


    // @Around("inAnnotated() && isUpLink()")
    @Around("isUpLinkData()")
    public Object countAllUpLinkDataRequests(ProceedingJoinPoint joinPoint) throws Throwable {
        ResponseEntity result;
        //Timer.Sample sample = Timer.start(meterRegistry);

        try {
            result = (ResponseEntity) joinPoint.proceed();
            int statusCode=result.getStatusCode().value();

            System.out.println("rashmi before setting my custome Timer-->");
            //sample.stop(meterRegistry.timer("MYAPP.RVUL_DATA.metrics", "myAppId", (String)joinPoint.getArgs()[0],"statusCode",String.valueOf(statusCode) ));
            meterRegistry.counter("MYAPP.RVUL_DATA", "myAppId",(String)joinPoint.getArgs()[0],"statusCode", String.valueOf(statusCode)).increment();

            System.out.println("rashmi after stooping the TIMER setting my custome Timer-->");
        }
        catch (Throwable t) {

            throw t;
        }


        return result;
    }




}
