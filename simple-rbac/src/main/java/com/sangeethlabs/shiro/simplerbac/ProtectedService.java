package com.sangeethlabs.shiro.simplerbac;

import java.io.File;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;

/*
[users]
# username = password, roleName1, roleName2, ..., roleNameN
root = secret, admin
guest = guest, guest
gandhi = 12345, role1, role2
bose = 67890, role2

[roles]
# rolename = permissionDefinition1, permissionDefinition2, ..., permissionDefinitionN
# where
# permissionDefinition => (resource:permissions[:resourceIdentifiers]) | *
# permissions => (permissionName [,permissionName]*) | *
# resourceIdentifiers => (resourceIdentifier [,resourceIdentifier]*) | *
# 'admin' role has all permissions, indicated by the wildcard '*'
admin = *
role1 = filesystem:*,system:*
role2 = "calculator:add,subtract"
*/
public class ProtectedService {
	private static final List<String> USERS = Arrays.asList("root","guest","gandhi","bose");
	
	private static final List<String> ROLES = Arrays.asList("admin","guest","role1","role2");
	
	@RequiresPermissions("user-roles:*")
	public List<String> getUsers() {
		return USERS;
	}
	
	@RequiresPermissions("user-roles:*")
	public List<String> getRoles() {
		return ROLES;
	}
	
	@RequiresPermissions("system:read:time")
	public Date getSystemTime() {
		return Calendar.getInstance().getTime();
	}
	
	@RequiresPermissions("calculator:add")
	public int sum(int a, int b) {
		return a+b;
	}
	
	@RequiresPermissions("calculator:subtract")
	public int diff(int a, int b) {
		return a-b;
	}
	
	@RequiresPermissions("filesystem:read:home")
	public List<String> getHomeFiles() {
		File homeDir = new File(System.getProperty("user.home"));
		return Arrays.asList(homeDir.list());
	}

	public String getGreetingMessage(String name) {
		return String.format("Hello %s",name);
	}
}
