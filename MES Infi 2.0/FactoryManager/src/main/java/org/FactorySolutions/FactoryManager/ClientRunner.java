package org.FactorySolutions.FactoryManager;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Security;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.eclipse.milo.opcua.sdk.client.OpcUaClient;
import org.eclipse.milo.opcua.stack.client.security.DefaultClientCertificateValidator;
import org.eclipse.milo.opcua.stack.core.Stack;
import org.eclipse.milo.opcua.stack.core.security.DefaultTrustListManager;
import org.eclipse.milo.opcua.stack.core.types.builtin.LocalizedText;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.eclipse.milo.opcua.stack.core.types.builtin.unsigned.Unsigned.uint;

public class ClientRunner {

    static {
        Security.addProvider(new BouncyCastleProvider());
    }

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private final CompletableFuture<OpcUaClient> future = new CompletableFuture<>();

    private DefaultTrustListManager trustListManager;

    private final ClientOPCUA clientOPCUA;

    public ClientRunner(ClientOPCUA clientOPCUA) throws Exception {
        this.clientOPCUA = clientOPCUA;

    }

    private OpcUaClient createClient() throws Exception {
        Path securityTempDir = Paths.get(System.getProperty("java.io.tmpdir"), "client", "security");
        Files.createDirectories(securityTempDir);
        if (!Files.exists(securityTempDir)) {
            throw new Exception("unable to create security dir: " + securityTempDir);
        }

        File pkiDir = securityTempDir.resolve("pki").toFile();

        LoggerFactory.getLogger(getClass())
                .info("security dir: {}", securityTempDir.toAbsolutePath());
        LoggerFactory.getLogger(getClass())
                .info("security pki dir: {}", pkiDir.getAbsolutePath());

        KeyStoreLoader loader = new KeyStoreLoader().load(securityTempDir);

        trustListManager = new DefaultTrustListManager(pkiDir);

        DefaultClientCertificateValidator certificateValidator =
                new DefaultClientCertificateValidator(trustListManager);

        return OpcUaClient.create(
                clientOPCUA.getEndpointUrl(),
                endpoints ->
                        endpoints.stream()
                                .filter(clientOPCUA.endpointFilter())
                                .findFirst(),
                configBuilder ->
                        configBuilder
                                .setApplicationName(LocalizedText.english("eclipse milo opc-ua client"))
                                .setApplicationUri("urn:eclipse:milo:examples:client")
                                .setKeyPair(loader.getClientKeyPair())
                                .setCertificate(loader.getClientCertificate())
                                .setCertificateChain(loader.getClientCertificateChain())
                                .setCertificateValidator(certificateValidator)
                                .setIdentityProvider(clientOPCUA.getIdentityProvider())
                                .setRequestTimeout(uint(5000))
                                .build()
        );
    }

    public void run() {
        try {
            OpcUaClient client = createClient();


            future.whenCompleteAsync((c, ex) -> {
                if (ex != null) {
                    logger.error("Error running example: {}", ex.getMessage(), ex);
                }

                try {
                    client.disconnect().get();
                    Stack.releaseSharedResources();
                } catch (InterruptedException | ExecutionException e) {
                    logger.error("Error disconnecting: {}", e.getMessage(), e);
                }


            });

            try {
                clientOPCUA.run(client, future);
                future.get(15, TimeUnit.SECONDS);
            } catch (Throwable t) {
                logger.error("Error running client example: {}", t.getMessage(), t);
                future.completeExceptionally(t);
            }
        } catch (Throwable t) {
            logger.error("Error getting client: {}", t.getMessage(), t);

            future.completeExceptionally(t);


        }


    }

}