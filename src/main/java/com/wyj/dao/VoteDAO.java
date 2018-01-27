package com.wyj.dao;

import com.wyj.bean.Vote;

public interface VoteDAO {
	public void addVote(Vote vote);
	public Vote findVoteByName(String voteName);
}
