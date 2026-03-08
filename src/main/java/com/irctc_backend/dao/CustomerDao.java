package com.irctc_backend.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import com.irctc_backend.hash.Customer;

public class CustomerDao {

	@Autowired
	private RedisTemplate redisTemplate;

	public String saveUserOnRedis(Customer customer) {
		redisTemplate.opsForHash().put("Customer", customer.getId(), customer);
		return "User Saved";
	}

	public String getAllUserOnRedis() {
		redisTemplate.opsForHash().values("Customer");
		return "User Saved";
	}

	public String getSingleUserOnRedis(String id) {
		redisTemplate.opsForHash().get("Customer", id);
		return "User Saved";
	}

}
