/*
 * Copyright (C) 2018. Huawei Technologies Co., LTD. All rights reserved.
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of Apache License, Version 2.0.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * Apache License, Version 2.0 for more details.
 */
package com.smn.request.auth;

import com.smn.common.Constants;
import com.smn.config.SmnConfiguration;
import com.smn.http.HttpMethod;
import com.smn.request.AbstractRequest;
import com.smn.response.AbstractResponse;
import com.smn.response.auth.IamAuthResponse;

/**
 * the request for iam auth
 *
 * @author zhangyx
 * @version 2.0.0
 */
public class IamAuthRequest extends AbstractRequest<IamAuthResponse> {

    private SmnConfiguration smnConfiguration;

    public HttpMethod getHttpMethod() {
        return HttpMethod.POST;
    }

    public String getUrl() {
        return Constants.HTTPS + Constants.IAM + "."
                + smnConfiguration.getRegionName() + "."
                + Constants.ENDPOINT + Constants.IAM_TOKEN_URI;

    }

    public String getBodyParams() {
        return "{" +
                "    \"auth\": {" +
                "        \"identity\": {" +
                "            \"methods\": [" +
                "                \"password\"" +
                "            ]," +
                "            \"password\": {" +
                "                \"user\": {" +
                "                    \"name\": \"" + smnConfiguration.getUserName() + "\"," +
                "                    \"password\": \"" + smnConfiguration.getPassword() + "\"," +
                "                    \"domain\": {" +
                "                        \"name\": \"" + smnConfiguration.getDomainName() + "\"" +
                "                    }" +
                "                }" +
                "            }" +
                "        }," +
                "        \"scope\": {" +
                "            \"project\": {" +
                "                \"name\": \"" + smnConfiguration.getRegionName() + "\"" +
                "            }" +
                "        }" +
                "    }" +
                "}";
    }

    public void setSmnConfiguration(SmnConfiguration smnConfiguration) {
        this.smnConfiguration = smnConfiguration;
    }
}