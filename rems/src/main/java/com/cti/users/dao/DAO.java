package com.cti.users.dao;

import com.cti.common.REMS;

public interface DAO {

	void save(REMS remsObj);

	void update(REMS remsObj);

	void delete(REMS remsObj);
}
