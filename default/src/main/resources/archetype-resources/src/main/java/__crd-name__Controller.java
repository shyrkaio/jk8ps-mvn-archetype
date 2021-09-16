package ${package};

import ${package}.events.${crd-name}EventSource;
import ${package}.events.${crd-name}Event;

import io.fabric8.kubernetes.client.KubernetesClient;
import io.javaoperatorsdk.operator.api.*;
import io.javaoperatorsdk.operator.processing.event.EventSourceManager;
import io.javaoperatorsdk.operator.processing.event.internal.CustomResourceEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;


@Controller
public class ${crd-name}Controller implements ResourceController<${crd-name}> {

    private static final Logger log = LoggerFactory.getLogger(${crd-name}Controller.class);


// add spec there
    private final KubernetesClient kubernetesClient;

    public ${crd-name}Controller(KubernetesClient client) {
        this.kubernetesClient = client;
      }
    
      @Override
      public void init(EventSourceManager eventSourceManager) {
        log.info("Init");
        ${crd-name}EventSource operatorEvenSource = ${crd-name}EventSource.createAndRegisterWatch(kubernetesClient);
        eventSourceManager.registerEventSource("${crd-name}-event-source", operatorEvenSource);
      }
    
      @Override
      public UpdateControl<${crd-name}> createOrUpdateResource(${crd-name} instance, Context<${crd-name}> context) {
        Optional<${crd-name}Event> latestCREvent =
            context.getEvents().getLatestOfType(${crd-name}Event.class);

        //doSomething(instance);

        log.info("status : {}", instance.getStatus());

        return UpdateControl.noUpdate();//UpdateControl.updateCustomResourceAndStatus(instance);
      }
    
      @Override
      public DeleteControl deleteResource(${crd-name} ${crd-name.toLowerCase()}, Context<${crd-name}> context) {        
        return DeleteControl.DEFAULT_DELETE;
      }

}