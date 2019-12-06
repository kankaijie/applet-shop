package com.org.shop.client;

import com.org.shop.api.UserApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name= "shop-user",contextId = "u3")
public interface UserClient extends UserApi {
}
