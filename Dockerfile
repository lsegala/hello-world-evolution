FROM openjdk:10.0.1 as builder

RUN jlink \
    --add-modules java.base \
    --verbose \
    --strip-debug \
    --compress 2 \
    --no-header-files \
    --no-man-pages \
    --output /opt/jre-minimal

FROM panga/alpine:3.7-glibc2.25

COPY --from=builder /opt/jre-minimal /opt/jre-minimal

ENV LANG=C.UTF-8 \
    PATH=${PATH}:/opt/jre-minimal/bin

ADD target/*.jar /opt/app/modules/

ARG JVM_OPTS
ENV JVM_OPTS=${JVM_OPTS}

CMD java ${JVM_OPTS} --upgrade-module-path /opt/app/modules --module br.com.lsegala.hello/br.com.lsegala.hello.App $NAME