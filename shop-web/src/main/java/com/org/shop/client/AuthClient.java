package com.org.shop.client;

import com.org.shop.api.AuthApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "shop-auth",contextId = "ab1")
public interface AuthClient extends AuthApi {
}
