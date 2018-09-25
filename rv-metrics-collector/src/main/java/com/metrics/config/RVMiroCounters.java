package com.metrics.config;


import com.metrics.config.SampleRegistries;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.composite.CompositeMeterRegistry;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class RVMiroCounters {
    Counter dlCounter;
    Counter dlCounterfailure;

    Counter ulCounter;
    Counter uldCounter;

    public void RVMiroCounters() {
        System.out.println("RVMiroCounters : construct ,does nothing");

    }

    @PostConstruct
    public void RVMiroCountersInitilization() {
        System.out.println("PostConstruct : called for RVMiroCounters ");

        CompositeMeterRegistry registry = new CompositeMeterRegistry();
        // register a counter of questionable usefulness
        registry.add(SampleRegistries.prometheus());
     //  registry.add(SampleRegistries.jmx());

        dlCounter= registry.counter("RV_dl_requests_success", "method", "RVDL","errorCode", "200","errorSubCode","");
        dlCounterfailure=registry.counter("RV_dl_requests_failure", "method", "RVDL","errorCode", "403","errorSubCode","300");

        registry.counter("RV_dl_requests", "method", "RVDL","errorCode", "403","errorSubCode","300");
        ulCounter = registry.counter("RV_ul_requests", "method", "RVUL");
        uldCounter = registry.counter("RV_uld_requests", "method", "RVULDATA");
        registry.config().commonTags("errorCode", "errorSubCode", "region", "us-east-1");

        System.out.println("rashmiCounters : created fine from RVMiroCounters : "+registry.getMeters().toString() + "\n"+ registry.config());

        dlCounter.increment(2.0);

    }
}
