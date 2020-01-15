/*
 * Copyright (C) 2019-2020 The TesraSupernet Authors
 * This file is part of The TesraSupernet library.
 *
 *  The TesraSupernet is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU Lesser General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  The TesraSupernet is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU Lesser General Public License for more details.
 *
 *  You should have received a copy of the GNU Lesser General Public License
 *  along with The TesraSupernet.  If not, see <http://www.gnu.org/licenses/>.
 *
 */

package com.github.TesraSupernet.core.governance;

import com.alibaba.fastjson.JSON;
import com.github.TesraSupernet.common.Address;
import com.github.TesraSupernet.io.BinaryReader;
import com.github.TesraSupernet.io.BinaryWriter;
import com.github.TesraSupernet.io.Serializable;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class AuthorizeInfo implements Serializable {
    public String peerPubkey;
    public Address address;
    public long consensusPos;
    public long freezePos;
    public long newPos;
    public long withdrawPos;
    public long withdrawFreezePos;
    public long withdrawUnfreezePos;

    public AuthorizeInfo(){}

    @Override
    public void deserialize(BinaryReader reader) throws IOException {
        this.peerPubkey = reader.readVarString();
        try {
            this.address = reader.readSerializable(Address.class);
            this.consensusPos = reader.readLtsg();
            this.freezePos = reader.readLtsg();
            this.newPos = reader.readLtsg();
            this.withdrawPos = reader.readLtsg();
            this.withdrawFreezePos = reader.readLtsg();
            this.withdrawUnfreezePos = reader.readLtsg();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void serialize(BinaryWriter writer) throws IOException {

    }

    public String toJson(){
        Map map = new HashMap();
        map.put("peerPubkey",peerPubkey);
        map.put("address",address.toBase58());
        map.put("consensusPos",consensusPos);
        map.put("freezePos",freezePos);
        map.put("newPos",newPos);
        map.put("withdrawPos",withdrawPos);
        map.put("withdrawFreezePos",withdrawFreezePos);
        map.put("withdrawUnfreezePos",withdrawUnfreezePos);
        return JSON.toJSONString(map);
    }
}
