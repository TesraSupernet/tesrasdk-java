package com.github.TesraSupernet.smartcontract.nativevm.abi;

import com.github.TesraSupernet.common.Address;

import java.util.ArrayList;
import java.util.List;


public class Struct {
    public List list = new ArrayList();
    public Struct(){

    }
    public Struct add(Object... objs){
        for(int i=0;i<objs.length;i++){
            list.add(objs[i]);
        }
        return this;
    }
}
