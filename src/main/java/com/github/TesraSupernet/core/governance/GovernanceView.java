package com.github.TesraSupernet.core.governance;

import com.github.TesraSupernet.common.UInt256;
import com.github.TesraSupernet.io.BinaryReader;
import com.github.TesraSupernet.io.BinaryWriter;
import com.github.TesraSupernet.io.Serializable;

import java.io.IOException;

public class GovernanceView implements Serializable {
    public int view;
    public int height;
    public UInt256 txhash;
    public GovernanceView(){
    }
    GovernanceView(int view,int height,UInt256 txhash){
        this.view = view;
        this.height = height;
        this.txhash = txhash;
    }
    @Override
    public void deserialize(BinaryReader reader) throws IOException {
        this.view = reader.readInt();
        this.height = reader.readInt();
        try {
            this.txhash = reader.readSerializable(UInt256.class);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void serialize(BinaryWriter writer) throws IOException {
        writer.writeInt(view);
        writer.writeInt(height);
        writer.writeSerializable(txhash);
    }
}
