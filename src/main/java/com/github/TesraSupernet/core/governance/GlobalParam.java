package com.github.TesraSupernet.core.governance;

import com.github.TesraSupernet.io.BinaryReader;
import com.github.TesraSupernet.io.BinaryWriter;
import com.github.TesraSupernet.io.Serializable;
import com.github.TesraSupernet.io.utils;

import java.io.IOException;

public class GlobalParam implements Serializable {
    public int candidateFeeSplitNum;
    public int A;
    public int B;
    public int yita;
    public GlobalParam(){}
    public GlobalParam(int CandidateFeeSplitNum, int A, int B, int Yita){
        this.candidateFeeSplitNum = CandidateFeeSplitNum;
        this.A = A;
        this.B = B;
        this.yita = Yita;
    }

    @Override
    public void deserialize(BinaryReader reader) throws IOException {
        this.candidateFeeSplitNum = (int)utils.readVarInt(reader);
        this.A = (int)utils.readVarInt(reader);
        this.B = (int)utils.readVarInt(reader);
        this.yita = (int)utils.readVarInt(reader);
    }

    @Override
    public void serialize(BinaryWriter binaryWriter) throws IOException {

    }
}