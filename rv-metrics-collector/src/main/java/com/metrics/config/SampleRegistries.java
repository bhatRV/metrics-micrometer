package com.metrics.config;





        import com.sun.net.httpserver.HttpServer;

        import io.micrometer.core.instrument.Clock;
        import io.micrometer.core.instrument.MeterRegistry;
        import io.micrometer.core.lang.Nullable;

      /*  import io.micrometer.jmx.JmxConfig;
        import io.micrometer.jmx.JmxMeterRegistry;*/

        import io.micrometer.prometheus.PrometheusConfig;
        import io.micrometer.prometheus.PrometheusMeterRegistry;


        import java.io.IOException;
        import java.io.OutputStream;
        import java.net.InetSocketAddress;
        import java.time.Duration;

public class SampleRegistries {
    public static MeterRegistry pickOne() {
        throw new RuntimeException("Pick some other method on SampleRegistries to ship sample metrics to the system of your choice");
    }

    /**
     * To use pushgateway instead:
     * new PushGateway("localhost:9091").pushAdd(registry.getPrometheusRegistry(), "samples");
     *
     * @return A prometheus registry.
     */
    public static PrometheusMeterRegistry prometheus() {
        PrometheusMeterRegistry prometheusRegistry = new PrometheusMeterRegistry(new PrometheusConfig() {
            @Override
            public Duration step() {
                return Duration.ofSeconds(10);
            }

            @Override
            @Nullable
            public String get(String k) {
                return null;
            }
        });

        try {
            HttpServer server = HttpServer.create(new InetSocketAddress(8091), 0);
            System.out.println("Entered the SampleREgistry Code");
            server.createContext("/actuator/prometheus", httpExchange -> {
                String response = prometheusRegistry.scrape();
                httpExchange.sendResponseHeaders(200, response.length());
                OutputStream os = httpExchange.getResponseBody();
                os.write(response.getBytes());
                os.close();
            });

            new Thread(server::start).run();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return prometheusRegistry;
    }


/*
    public static JmxMeterRegistry jmx() {
        return new JmxMeterRegistry(new JmxConfig() {
            @Override
            public Duration step() {
                return Duration.ofSeconds(10);
            }

            @Override
            @Nullable
            public String get(String k) {
                return null;
            }
        }, Clock.SYSTEM);
    }

    */
}
