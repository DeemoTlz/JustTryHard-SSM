package com.qjh.shiro.realms;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.qjh.crud.bean.Student;
import com.qjh.crud.service.StudentService;

public class UserRealm2 extends AuthenticatingRealm {

	@Autowired
	StudentService service;

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		System.out.println("second realm");
		
		int userName = Integer.parseInt((String) token.getPrincipal());
		Student stu = service.getById(userName);

		if (null == stu) {
			throw new UnknownAccountException("用户不存在");
		}

		String newPassword = new SimpleHash("SHA1", stu.getName(), ByteSource.Util.bytes(userName + ""), 3).toString();

		ByteSource credentialsSalt = ByteSource.Util.bytes(userName + "");
		// AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(userName, newPassword, this.getName());
		AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(userName, newPassword, credentialsSalt, getName());

		return authcInfo;
	}

}
