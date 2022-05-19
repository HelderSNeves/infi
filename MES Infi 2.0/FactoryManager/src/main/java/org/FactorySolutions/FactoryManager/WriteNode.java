package org.FactorySolutions.FactoryManager;

import java.util.concurrent.CompletableFuture;

import org.eclipse.milo.opcua.sdk.client.OpcUaClient;

import org.eclipse.milo.opcua.sdk.client.nodes.UaVariableNode;
import org.eclipse.milo.opcua.stack.core.types.builtin.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class WriteNode implements ClientOPCUA {
    private final int namespaceIndex;

    private final String identifier;

    public int getNamespaceIndex() {
        return namespaceIndex;
    }

    public String getIdentifier() {
        return identifier;
    }

    public WriteNode(int namespaceIndex, String identifier){
        this.namespaceIndex=namespaceIndex;
        this.identifier=identifier;
    }

    private final Logger logger = LoggerFactory.getLogger(getClass());

    public void run(OpcUaClient client, CompletableFuture<OpcUaClient> future, int namespaceIndex, String identifier) throws Exception {
        // synchronous connect
        client.connect().get();

        UaVariableNode nodeWrite = client.getAddressSpace().getVariableNode(
                new NodeId(namespaceIndex, identifier)
        );

        nodeWrite.writeValue(new DataValue(new Variant(true)));

        logger.info("Write={}", nodeWrite.readValue().getValue().getValue());

        future.complete(client);
    }

}
