package com.wyj.dao;

import java.util.List;

import com.wyj.bean.VoteOption;

public interface VoteOptionDAO {
	public void addVoteOption(VoteOption voteOption);		
	public List<VoteOption> findVoteOptionByVoteID(int voteID);	
	public void deleteVoteOption(int voteOptionID);
}
