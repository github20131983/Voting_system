package com.wyj.dao;

import java.util.List;

import com.wyj.bean.Vote;
import com.wyj.util.Page;

public interface VoteDAO {
	public void addVote(Vote vote);
	public Vote findVoteByName(String voteName);
	public int findAllCount();
	public List<Vote> findAllVote(Page page);
	public void deleteVote(int voteID);
}
