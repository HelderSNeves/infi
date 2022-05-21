package org.FactorySolutions.FactoryManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.eclipse.milo.opcua.sdk.client.OpcUaClient;
import org.eclipse.milo.opcua.sdk.client.nodes.UaVariableNode;
import org.eclipse.milo.opcua.stack.core.types.builtin.*;


import java.util.HashMap;

public class ReadNode implements ClientOPCUA {

	ArrayList<Boolean> list = new ArrayList<Boolean>(Arrays.asList(new Boolean[0]));

    public ReadNode() {
    }

    public List<String> createList() {
        List<String> list = new ArrayList<String>();
        list.add("|var|CODESYS Control Win V3 x64.Application.GVL.W1in0_SensorP");
        list.add("|var|CODESYS Control Win V3 x64.Application.GVL.Load0_SensorP");
        list.add("|var|CODESYS Control Win V3 x64.Application.GVL.Load0_SensorRMinus");
        list.add("|var|CODESYS Control Win V3 x64.Application.GVL.Load0_SensorRPlus");
        list.add("|var|CODESYS Control Win V3 x64.Application.GVL.Load1_SensorP");
        list.add("|var|CODESYS Control Win V3 x64.Application.GVL.Load2_SensorP");
        list.add("|var|CODESYS Control Win V3 x64.Application.GVL.W1in1_SensorP");
        list.add("|var|CODESYS Control Win V3 x64.Application.GVL.W1out1_SensorP");
        list.add("|var|CODESYS Control Win V3 x64.Application.GVL.N1_SensorP");
        list.add("|var|CODESYS Control Win V3 x64.Application.GVL.N1_SensorRMinus");
        list.add("|var|CODESYS Control Win V3 x64.Application.GVL.N1_SensorRPlus");
        list.add("|var|CODESYS Control Win V3 x64.Application.GVL.N2_SensorP");
        list.add("|var|CODESYS Control Win V3 x64.Application.GVL.N2_SensorRMinus");
        list.add("|var|CODESYS Control Win V3 x64.Application.GVL.N2_SensorRPlus");
        list.add("|var|CODESYS Control Win V3 x64.Application.GVL.N3_SensorP");
        list.add("|var|CODESYS Control Win V3 x64.Application.GVL.N3_SensorRMinus");
        list.add("|var|CODESYS Control Win V3 x64.Application.GVL.N3_SensorRPlus");
        list.add("|var|CODESYS Control Win V3 x64.Application.GVL.N4_SensorP");
        list.add("|var|CODESYS Control Win V3 x64.Application.GVL.N4_SensorRMinus");
        list.add("|var|CODESYS Control Win V3 x64.Application.GVL.N4_SensorRPlus");
        list.add("|var|CODESYS Control Win V3 x64.Application.GVL.M11_SensorP");
        list.add("|var|CODESYS Control Win V3 x64.Application.GVL.M11_SensorTool");
        list.add("|var|CODESYS Control Win V3 x64.Application.GVL.M11_SensorXplus");
        list.add("|var|CODESYS Control Win V3 x64.Application.GVL.M11_SensorXminus");
        list.add("|var|CODESYS Control Win V3 x64.Application.GVL.M11_SensorZplus");
        list.add("|var|CODESYS Control Win V3 x64.Application.GVL.M11_SensorZminus");
        list.add("|var|CODESYS Control Win V3 x64.Application.GVL.M12_SensorP");
        list.add("|var|CODESYS Control Win V3 x64.Application.GVL.M12_SensorTool");
        list.add("|var|CODESYS Control Win V3 x64.Application.GVL.M12_SensorXplus");
        list.add("|var|CODESYS Control Win V3 x64.Application.GVL.M12_SensorXminus");
        list.add("|var|CODESYS Control Win V3 x64.Application.GVL.M12_SensorZplus");
        list.add("|var|CODESYS Control Win V3 x64.Application.GVL.M12_SensorZminus");
        list.add("|var|CODESYS Control Win V3 x64.Application.GVL.M13_SensorP");
        list.add("|var|CODESYS Control Win V3 x64.Application.GVL.M13_SensorTool");
        list.add("|var|CODESYS Control Win V3 x64.Application.GVL.M13_SensorXplus");
        list.add("|var|CODESYS Control Win V3 x64.Application.GVL.M13_SensorXminus");
        list.add("|var|CODESYS Control Win V3 x64.Application.GVL.M13_SensorZplus");
        list.add("|var|CODESYS Control Win V3 x64.Application.GVL.M13_SensorZminus");
        list.add("|var|CODESYS Control Win V3 x64.Application.GVL.M23_SensorP");
        list.add("|var|CODESYS Control Win V3 x64.Application.GVL.M23_SensorTool");
        list.add("|var|CODESYS Control Win V3 x64.Application.GVL.M23_SensorXplus");
        list.add("|var|CODESYS Control Win V3 x64.Application.GVL.M23_SensorXminus");
        list.add("|var|CODESYS Control Win V3 x64.Application.GVL.M23_SensorZplus");
        list.add("|var|CODESYS Control Win V3 x64.Application.GVL.M23_SensorZminus");
        list.add("|var|CODESYS Control Win V3 x64.Application.GVL.M21_SensorP");
        list.add("|var|CODESYS Control Win V3 x64.Application.GVL.M21_SensorTool");
        list.add("|var|CODESYS Control Win V3 x64.Application.GVL.M21_SensorXplus");
        list.add("|var|CODESYS Control Win V3 x64.Application.GVL.M21_SensorXminus");
        list.add("|var|CODESYS Control Win V3 x64.Application.GVL.M21_SensorZplus");
        list.add("|var|CODESYS Control Win V3 x64.Application.GVL.M21_SensorZminus");
        list.add("|var|CODESYS Control Win V3 x64.Application.GVL.M22_SensorP");
        list.add("|var|CODESYS Control Win V3 x64.Application.GVL.M22_SensorTool");
        list.add("|var|CODESYS Control Win V3 x64.Application.GVL.M22_SensorXplus");
        list.add("|var|CODESYS Control Win V3 x64.Application.GVL.M22_SensorXminus");
        list.add("|var|CODESYS Control Win V3 x64.Application.GVL.M22_SensorZplus");
        list.add("|var|CODESYS Control Win V3 x64.Application.GVL.M22_SensorZminus");
        list.add("|var|CODESYS Control Win V3 x64.Application.GVL.E2_SensorP");
        list.add("|var|CODESYS Control Win V3 x64.Application.GVL.E3_SensorP");
        list.add("|var|CODESYS Control Win V3 x64.Application.GVL.E3_SensorRMinus");
        list.add("|var|CODESYS Control Win V3 x64.Application.GVL.E3_SensorRPlus");
        list.add("|var|CODESYS Control Win V3 x64.Application.GVL.S1_SensorP");
        list.add("|var|CODESYS Control Win V3 x64.Application.GVL.S2_SensorP");
        list.add("|var|CODESYS Control Win V3 x64.Application.GVL.W2_SensorP");
        list.add("|var|CODESYS Control Win V3 x64.Application.GVL.W3_SensorP");
        list.add("|var|CODESYS Control Win V3 x64.Application.GVL.W3_SensorRMinus");
        list.add("|var|CODESYS Control Win V3 x64.Application.GVL.W3_SensorRPlus");
        list.add("|var|CODESYS Control Win V3 x64.Application.GVL.W2in1_SensorP");
        list.add("|var|CODESYS Control Win V3 x64.Application.GVL.W2out1_SensorP");
        list.add("|var|CODESYS Control Win V3 x64.Application.GVL.W2out1_SensorP1");
        list.add("|var|CODESYS Control Win V3 x64.Application.GVL.U0_SensorP");
        list.add("|var|CODESYS Control Win V3 x64.Application.GVL.U0_SensorRMinus");
        list.add("|var|CODESYS Control Win V3 x64.Application.GVL.U0_SensorRPlus");
        list.add("|var|CODESYS Control Win V3 x64.Application.GVL.U1_SensorP");
        list.add("|var|CODESYS Control Win V3 x64.Application.GVL.U1_SensorPPlus");
        list.add("|var|CODESYS Control Win V3 x64.Application.GVL.U1_SensorPMinus");
        list.add("|var|CODESYS Control Win V3 x64.Application.GVL.U2_SensorP");
        list.add("|var|CODESYS Control Win V3 x64.Application.GVL.U2_SensorPPlus");
        list.add("|var|CODESYS Control Win V3 x64.Application.GVL.U2_SensorPMinus");
        list.add("|var|CODESYS Control Win V3 x64.Application.GVL.U3_SensorP");
        list.add("|var|CODESYS Control Win V3 x64.Application.GVL.U3_SensorPPlus");
        list.add("|var|CODESYS Control Win V3 x64.Application.GVL.U3_SensorPMinus");
        list.add("|var|CODESYS Control Win V3 x64.Application.GVL.U11_SensorP");
        list.add("|var|CODESYS Control Win V3 x64.Application.GVL.U12_SensorP");
        list.add("|var|CODESYS Control Win V3 x64.Application.GVL.U13_SensorP");
        list.add("|var|CODESYS Control Win V3 x64.Application.GVL.U21_SensorP");
        list.add("|var|CODESYS Control Win V3 x64.Application.GVL.U22_SensorP");
        list.add("|var|CODESYS Control Win V3 x64.Application.GVL.U23_SensorP");
        list.add("|var|CODESYS Control Win V3 x64.Application.GVL.U31_SensorP");
        list.add("|var|CODESYS Control Win V3 x64.Application.GVL.U32_SensorP");
        list.add("|var|CODESYS Control Win V3 x64.Application.GVL.U33_SensorP");
        
        
        
        return list;
    }

    public HashMap<String, Boolean> getSensorData(OpcUaClient client) throws Exception {
        HashMap<String, Boolean> values = new HashMap<String, Boolean>();
        List<String> identifiers = createList();
        for (int i = 0; i < identifiers.size(); i++) {
            UaVariableNode nodeRead = client.getAddressSpace().getVariableNode(
                    new NodeId(4, identifiers.get(i)));
            values.put(identifiers.get(i), (Boolean) nodeRead.readValue().getValue().getValue());
        }
        return values;
    }

    @Override
    public void run(OpcUaClient client, CompletableFuture<OpcUaClient> future) throws Exception {
        // synchronous connect
        client.connect().get();
        boolean var = false;
        HashMap<String, Boolean> sensorData = getSensorData(client);
        for (String i:sensorData.keySet()) {
           var = sensorData.get(i);
           list.add(var);
           //System.out.print(i+" ");
           //System.out.println(var);
           future.complete(client);
        }

    }
    
    public ArrayList<Boolean> get_list(){
		return list;
    	
    }

}