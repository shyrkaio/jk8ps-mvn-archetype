package ${package}.events;

import ${package}.${crd-name};

import io.fabric8.kubernetes.api.model.apps.Deployment;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.Watcher;
import io.fabric8.kubernetes.client.WatcherException;
import io.javaoperatorsdk.operator.processing.event.AbstractEventSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static io.javaoperatorsdk.operator.processing.KubernetesResourceUtils.getUID;
import static io.javaoperatorsdk.operator.processing.KubernetesResourceUtils.getVersion;


public class ${crd-name}EventSource extends AbstractEventSource implements Watcher<${crd-name}> {


    private static final Logger log = LoggerFactory.getLogger(${crd-name}EventSource.class);

    private final KubernetesClient client;

    public static ${crd-name}EventSource createAndRegisterWatch(KubernetesClient client) {
        ${crd-name}EventSource operatorEventSource = new ${crd-name}EventSource(client);
        operatorEventSource.registerWatch();
        return operatorEventSource;
    }

    private ${crd-name}EventSource(KubernetesClient client) {
        this.client = client;
    }

    private void registerWatch() {
        // on chile ressources
        // client.apps().xxx().inAnyNamespace().withLabel("app.kubernetes.io/created-by";, ...).watch(this);
        var instanceClient = client.customResources(${crd-name}.class);
        instanceClient.inAnyNamespace().watch(this);
    }

    @Override
    public void eventReceived(Action action, ${crd-name} instance) {
        log.info("Event received for action: {}, ${crd-name}: {}", action.name(), instance.getMetadata().getName());
        if (action == Action.ERROR) {
            log.warn(
                    "Skipping {} event for custom resource uid: {}, version: {}",
                    action,
                    getUID(instance),
                    getVersion(instance));
            return;
        }
        eventHandler.handleEvent(new ${crd-name}Event(action, instance, this));
    }

    @Override
    public void onClose(WatcherException e) {
        if (e == null) {
            return;
        }
        if (e.isHttpGone()) {
            log.warn("Received error for watch, will try to reconnect.", e);
            registerWatch();
        } else {
            // Note that this should not happen normally, since fabric8 client handles reconnect.
            // In case it tries to reconnect this method is not called.
            log.error("Unexpected error happened with watch. Will exit.", e);
            System.exit(1);
        }
    }

}