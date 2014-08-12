package com.cti.dao;

import java.util.List;

import com.cti.model.UserGroup;

public interface GroupDAO {

	public void addGroup(UserGroup group);

	public void updateGroup(UserGroup group);

	public void deletGroup(String groupId);

	public UserGroup getGroupById(String groupId);

	public List<UserGroup> listGroups();
}
