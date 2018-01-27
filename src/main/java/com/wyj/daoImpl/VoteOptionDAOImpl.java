package com.wyj.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.wyj.bean.VoteOption;
import com.wyj.dao.VoteOptionDAO;
import com.wyj.util.DBconnection;

public class VoteOptionDAOImpl implements VoteOptionDAO{
	public void addVoteOption(VoteOption voteOption) {
		Connection conn = DBconnection.getConnection();	
		String addSQL = "insert into " +
				"tb_voteoption(voteOptionName,voteID,ticketNum) values(?,?,?)";
		PreparedStatement pstmt = null;					
		try {
			pstmt = conn.prepareStatement(addSQL);		
			pstmt.setString(1, voteOption.getVoteOptionName());	
			pstmt.setInt(2, voteOption.getVoteID());		
			pstmt.setInt(3, voteOption.getTicketNum());		
			pstmt.executeUpdate();								
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBconnection.close(pstmt);							
			DBconnection.close(conn);							
		}
	}
}

