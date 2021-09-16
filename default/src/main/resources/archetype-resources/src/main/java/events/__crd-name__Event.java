package ${package}.events;

import ${package}.${crd-name};

import io.fabric8.kubernetes.client.Watcher;

import io.javaoperatorsdk.operator.processing.event.DefaultEvent;

public class ${crd-name}Event extends DefaultEvent {

    private final Watcher.Action action;
    private final ${crd-name} instance;

    public ${crd-name}Event(
            Watcher.Action action, ${crd-name} resource,
            ${crd-name}EventSource myEventSource) {

        super(resource.getMetadata().getOwnerReferences().get(0).getUid(), myEventSource);
        this.action = action;
        this.instance = resource;
    }

    public Watcher.Action getAction() {
        return action;
    }

    public String resourceUid() {
        return get${crd-name}().getMetadata().getUid();
    }

    @Override
    public String toString() {
        return "CustomResourceEvent{"
                + "action="
                + action
                + ", resource=[ name="
                + get${crd-name}().getMetadata().getName()
                + ", kind="
                + get${crd-name}().getKind()
                + ", apiVersion="
                + get${crd-name}().getApiVersion()
                + " ,resourceVersion="
                + get${crd-name}().getMetadata().getResourceVersion()
                + ", markedForDeletion: "
                + (get${crd-name}().getMetadata().getDeletionTimestamp() != null
                && !get${crd-name}().getMetadata().getDeletionTimestamp().isEmpty())
                + " ]"
                + '}';
    }

    public ${crd-name} get${crd-name}() {
        return instance;
    }
}
