package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by son on 2019-02-18.
 */
@AllArgsConstructor
public class UserVO {
	@Getter
	private String userId;
	@Getter
	private String userName;
	@Getter
	private boolean isGuest;
}
