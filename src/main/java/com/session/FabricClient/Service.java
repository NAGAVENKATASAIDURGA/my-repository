package com.session.FabricClient;

import org.springframework.beans.factory.annotation.Autowired;

import io.fabric8.kubernetes.client.ConfigBuilder;
import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientException;

@org.springframework.stereotype.Service
public class Service {
public void list() {
	io.fabric8.kubernetes.client.Config config = new ConfigBuilder()
	        .withMasterUrl("https://1E89E26F973960F5C47B8793A530FE11.gr7.us-east-1.eks.amazonaws.com")
	        .build();
	try (KubernetesClient client = new DefaultKubernetesClient()) {

	    client.pods().inNamespace("default").list().getItems().forEach(
	            pod -> System.out.println(pod.getMetadata().getName())
	    );

	} catch (KubernetesClientException ex) {
	    // Handle exception
	    ex.printStackTrace();
	}
}
}
