package com.github.TesraSupernet.core.sidechaingovernance;

import com.github.TesraSupernet.common.Address;
import com.github.TesraSupernet.io.BinaryReader;
import com.github.TesraSupernet.io.BinaryWriter;
import com.github.TesraSupernet.io.Serializable;
import com.github.TesraSupernet.io.utils;

import java.io.IOException;

public class NodeToSideChainParams implements Serializable {
    public String peerPubkey;
    public Address address;
    public String sideChainId;
    public NodeToSideChainParams(){}
    public NodeToSideChainParams(String peerPubkey, Address address, String sideChainId){
        this.peerPubkey = peerPubkey;
        this.address = address;
        this.sideChainId = sideChainId;
    }

    @Override
    public void deserialize(BinaryReader reader) throws IOException {
        this.peerPubkey = reader.readVarString();
        this.address = utils.readAddress(reader);
        this.sideChainId = reader.readVarString();
    }

    @Override
    public void serialize(BinaryWriter writer) throws IOException {

    }
}
