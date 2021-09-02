package ${package};

import io.fabric8.kubernetes.api.model.Namespaced;
import io.fabric8.kubernetes.client.CustomResource;
import io.fabric8.kubernetes.model.annotation.Group;
import io.fabric8.kubernetes.model.annotation.Version;

@Group("${package};")
@Version("v1alpha")
public class ${crd-name} extends CustomResource<${crd-name}Spec, ${crd-name}Status> implements Namespaced {}