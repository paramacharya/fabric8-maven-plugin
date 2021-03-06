/**
 * Copyright 2016 Red Hat, Inc.
 *
 * Red Hat licenses this file to you under the Apache License, version
 * 2.0 (the "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 * implied.  See the License for the specific language governing
 * permissions and limitations under the License.
 */
package io.fabric8.maven.sample.spring.boot.dekorate;

import io.dekorate.docker.annotation.DockerBuild;
import io.dekorate.kubernetes.annotation.KubernetesApplication;
import io.dekorate.kubernetes.annotation.Label;
import io.dekorate.kubernetes.annotation.ServiceType;
import io.dekorate.openshift.annotation.OpenshiftApplication;
import io.dekorate.s2i.annotation.S2iBuild;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenshiftApplication(
    labels = @Label(key = "decorated-by", value = "dekorate"),
    group = "fabric8",
    serviceType = ServiceType.NodePort
)
@KubernetesApplication(
    labels = @Label(key = "decorated-by", value = "dekorate"),
    group = "fabric8",
    serviceType = ServiceType.NodePort
)
@DockerBuild(
    group = "fabric8",
    version = "latest",
    name = "fabric8-maven-sample-spring-boot-dekorate"
)
@S2iBuild(
    group = "fabric8",
    version = "latest",
    name = "fabric8-maven-sample-spring-boot-dekorate"
)
@SpringBootApplication
public class SpringDekorateApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDekorateApplication.class, args);
    }

}
