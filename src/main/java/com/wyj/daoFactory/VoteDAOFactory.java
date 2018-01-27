package com.wyj.daoFactory;

import com.wyj.dao.VoteDAO;
import com.wyj.daoImpl.VoteDAOImpl;

public class VoteDAOFactory {
	public static VoteDAO getVoteDAOInstance(){	
		return new VoteDAOImpl();						
	}
}
