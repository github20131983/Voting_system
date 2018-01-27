package com.wyj.daoFactory;

import com.wyj.dao.VoteOptionDAO;
import com.wyj.daoImpl.VoteOptionDAOImpl;

public class VoteOptionDAOFactory {
	public static VoteOptionDAO getVoteOptionDAOInstance(){	
		return new VoteOptionDAOImpl();						
	}
}
