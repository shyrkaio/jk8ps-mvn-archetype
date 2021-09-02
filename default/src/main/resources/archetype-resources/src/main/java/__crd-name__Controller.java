package ${package};

import io.fabric8.kubernetes.client.KubernetesClient;
import io.javaoperatorsdk.operator.api.*;
import io.javaoperatorsdk.operator.processing.event.EventSourceManager;
import io.javaoperatorsdk.operator.processing.event.internal.CustomResourceEvent;

import java.util.Optional;


@Controller
public class ${crd-name}Controller implements ResourceController<${crd-name}> {
    // add spec there
    private final KubernetesClient kubernetesClient;

    public ${crd-name}Controller(KubernetesClient client) {
        this.kubernetesClient = client;
      }
    
      @Override
      public void init(EventSourceManager eventSourceManager) {
        //eventSourceManager.registerEventSource("deployment-event-source", ...);
      }
    
      @Override
      public UpdateControl<${crd-name}> createOrUpdateResource(${crd-name} ${crd-name.toLowerCase()}, Context<${crd-name}> context) {
        Optional<CustomResourceEvent> latestCREvent =
            context.getEvents().getLatestOfType(CustomResourceEvent.class);
    
        return UpdateControl.noUpdate();
      }
    
      @Override
      public DeleteControl deleteResource(${crd-name} ${crd-name.toLowerCase()}, Context<${crd-name}> context) {        
        return DeleteControl.DEFAULT_DELETE;
      }

}