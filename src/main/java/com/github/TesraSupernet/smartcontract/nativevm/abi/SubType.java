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

package com.github.TesraSupernet.smartcontract.nativevm.abi;

import com.alibaba.fastjson.JSON;
import com.github.TesraSupernet.common.ErrorCode;
import com.github.TesraSupernet.sdk.exception.SDKException;

import java.util.List;

public class SubType {
    public List<Parameter> parameters;

    public List<Parameter> getParameters() {
        return parameters;
    }
    public void setParamsValue(Object... objs) throws Exception{
        if(objs.length != parameters.size()){
            throw new SDKException(ErrorCode.ParamError);
        }
        for (int i = 0; i < objs.length; i++) {
            parameters.get(i).setValue(objs[i]);
        }
    }
    public Parameter getParameter(String name) {
        for (Parameter e : parameters) {
            if (e.getName().equals(name)) {
                return e;
            }
        }
        return null;
    }
    public void clearParamsValue() {
        for (Parameter e : parameters) {
            e.setValue(null);
        }
    }
    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
