package com.example.demo.handler;

import com.example.demo.model.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.lang.Nullable;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by son on 2019-02-20.
 */
@Slf4j
public class UserVOArgumentResolver implements HandlerMethodArgumentResolver {
	@Override
	public boolean supportsParameter(MethodParameter methodParameter) {
		return UserVO.class.isAssignableFrom(methodParameter.getParameterType());
	}

	@Override
	public Object resolveArgument(MethodParameter methodParameter, @Nullable ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, @Nullable WebDataBinderFactory webDataBinderFactory) throws Exception {
		final HttpServletRequest request = nativeWebRequest.getNativeRequest(HttpServletRequest.class);
		final String userId = StringUtils.isEmpty(request.getParameter("userId")) ? "guest" : request.getParameter("userId");
		final String userName = StringUtils.isEmpty(request.getParameter("userName")) ? "guest" : request.getParameter("userId");
		final Boolean isGuest = StringUtils.isEmpty(request.getParameter("isGuest")) ? true : Boolean.valueOf(request.getParameter("isGuest"));
		return new UserVO(userId, userName, isGuest);
	}
}
