package br.com.lsegala.helloworld.bean;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

public class SimpleProfiler {
    public Object profile(ProceedingJoinPoint call) throws Throwable {
        StopWatch clock = new StopWatch(String.format("profiling %s", call.getTarget()));
        try {
            clock.start(call.toShortString());
            return call.proceed();
        } finally {
            clock.stop();
            System.out.println(clock.prettyPrint());
        }
    }
}
