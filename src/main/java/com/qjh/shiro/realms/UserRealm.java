package com.qjh.shiro.realms;

import com.qjh.crud.bean.Student;
import com.qjh.crud.service.StudentService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

public class UserRealm extends AuthorizingRealm {

	@Autowired
	StudentService service;

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		System.out.println("first realm");
		
		int userName = Integer.parseInt((String) token.getPrincipal());
		Student stu = service.getById(userName);

		if (null == stu) {
			throw new UnknownAccountException("用户不存在");
		}

		String newPassword = new SimpleHash("MD5", stu.getName(), ByteSource.Util.bytes(userName + ""), 3).toString();

		ByteSource credentialsSalt = ByteSource.Util.bytes(userName + "");
		// AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(userName, newPassword, this.getName());

		return new SimpleAuthenticationInfo(userName, newPassword, credentialsSalt, getName());
	}

	// 授权需要实现的方法
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		System.out.println("doGetAuthorizationInfo...");
		//1. 获取登录用户信息
		Object principal = principals.getPrimaryPrincipal();
		
		//2. 利用登录用户信息获取角色或权限信息(查询数据库)
		Set<String> roles = new HashSet<String>();
		roles.add("user");
		if ("1".equals(principal.toString())) {
			roles.add("admin");
		}
		
		Set<String> stringPermissions = new HashSet<String>();
		if ("1".equals(principal.toString())) {
			stringPermissions.add("student:_page");
		}
		
		//3. 创建 SimpleAuthorizationInfo，并设置其 roles 属性
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(roles);
		info.setStringPermissions(stringPermissions);
		
		//4. 返回 SimpleAuthorizationInfo 对象
		return info;
	}

}
