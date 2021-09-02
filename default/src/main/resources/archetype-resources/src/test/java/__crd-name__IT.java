package ${package};

import io.fabric8.kubernetes.client.*;
import io.javaoperatorsdk.operator.Operator;
import io.javaoperatorsdk.operator.config.runtime.DefaultConfigurationService;
import org.junit.*;


public class ${crd-name}IT {


    final static String TEST_NS = "${crd-name}-test";

    @Test
    public void test() {

        Config config = new ConfigBuilder().withNamespace(TEST_NS).build();
        KubernetesClient client = new DefaultKubernetesClient(config);

        Operator operator = new Operator(client, DefaultConfigurationService.instance());
        operator.register(new ${crd-name}Controller(client));
        
        Assert.assertSame("foo","foo");
    }

}