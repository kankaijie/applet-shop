package com.org.shop.client;


import com.org.shop.api.UserApi;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;

@Repository
@FeignClient(value = "shop-user",contextId = "u1")
public interface UserClient extends UserApi {
}
