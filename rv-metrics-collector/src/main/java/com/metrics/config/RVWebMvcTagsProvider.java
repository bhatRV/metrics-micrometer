package com.metrics.config;


import io.micrometer.core.instrument.Tag;
import io.micrometer.core.lang.NonNullApi;
import io.micrometer.core.lang.Nullable;
import io.micrometer.spring.web.servlet.WebMvcTags;
import io.micrometer.spring.web.servlet.WebMvcTagsProvider;
import org.springframework.context.annotation.Bean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

@NonNullApi

public class RVWebMvcTagsProvider implements WebMvcTagsProvider {
    public RVWebMvcTagsProvider() {
    }
    @Bean
    public Iterable<Tag> httpLongRequestTags(@Nullable HttpServletRequest request, @Nullable Object handler) {
        System.out.println("httpLongRequestTags::WebMvcTags.method(request):"+WebMvcTags.method(request));
        System.out.println("httpLongRequestTags::handler:"+handler.toString());
        // return Arrays.asList(WebMvcTags.method(request), WebMvcTags.uri(request, (HttpServletResponse)null));
        return Arrays.asList(WebMvcTags.uri(request, (HttpServletResponse)null), WebMvcTags.uri(request, (HttpServletResponse)null));

        //return Arrays.asList(WebMvcTags.method(request), WebMvcTags.uri(request, (HttpServletResponse)null));
    }
    @Bean
    public Iterable<Tag> httpRequestTags(@Nullable HttpServletRequest request, @Nullable HttpServletResponse response, @Nullable Object handler, @Nullable Throwable ex) {
        System.out.println("httpRequestTags::WebMvcTags.method(request):"+WebMvcTags.method(request));

        System.out.println("httpRequestTags::WebMvcTags.method(response):"+WebMvcTags.status(response));
        System.out.println("httpRequestTags::request:"+request.toString());
        System.out.println("httpRequestTags::response:"+response.toString());

        //return Arrays.asList(WebMvcTags.method(request), WebMvcTags.uri(request, response), WebMvcTags.exception(ex), WebMvcTags.status(response));
        return Arrays.asList( WebMvcTags.uri(request, response), WebMvcTags.method(request), WebMvcTags.exception(ex), WebMvcTags.status(response));
    }
}

