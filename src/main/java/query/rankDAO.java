package query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import object.rankVO;

public class rankDAO {
	private PreparedStatement pstmt;
	private DataSource dataFactory;
	private Connection con;
	
	public rankDAO() {
		try {
			Context ctx = new InitialContext();
			// JNDI에 접근하기 위해 기본경로를 지정
			Context envContext = (Context) ctx.lookup("java:/comp/env");
			// context.xml 에서 설정한 name값으로 톰캣에 미리 연결한 DataSource 받아오기
			dataFactory = (DataSource) envContext.lookup("jdbc/mysql");
			// System.out.println("접속 성공");
			ctx.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	// rate of win top10
	public List<rankVO> listWinRate() {
		List<rankVO> list = new ArrayList<>();
		ResultSet rs = null;
		try {
			con = dataFactory.getConnection();
			String query = "select rank() over (order by win_rate desc) as ranking, user_id, user_nickname, win_rate ";
			query += "from (select * , round(ifnull(win/(win+lose)*100, 0),1) as win_rate from user) as a ";
			query += "limit 10";
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery(query);
			while (rs.next()) {
				String userId = rs.getString("user_id");
				String userNickname = rs.getString("user_nickname");
				double point = rs.getDouble("win_rate");
				rankVO vo = new rankVO();
				int rank = rs.getInt("ranking");
				vo.setRank(rank);
				vo.setUserId(userId);
				vo.setUserNickname(userNickname);
				vo.setPoint(point);
				list.add(vo);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				rs.close();
			} catch (Exception e) {
			}
			try {
				pstmt.close();
			} catch (Exception e) {
			}
			try {
				con.close();
			} catch (Exception e) {
			}
		}
		return list;
	}
	
	// count of wins top10
	public List<rankVO> listWinCount() {
		List<rankVO> list = new ArrayList<>();
		ResultSet rs = null;
		try {
			con = dataFactory.getConnection();
			String query = "select rank() over (order by win desc) as ranking, user_id, user_nickname, win ";
			query += "from user limit 10";
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery(query);
			while (rs.next()) {
				int rank = rs.getInt("ranking");
				String userId = rs.getString("user_id");
				String userNickname = rs.getString("user_nickname");
				double point = rs.getDouble("win");
				rankVO vo = new rankVO();
				vo.setRank(rank);
				vo.setUserId(userId);
				vo.setUserNickname(userNickname);
				vo.setPoint(point);
				list.add(vo);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				rs.close();
			} catch (Exception e) {
			}
			try {
				pstmt.close();
			} catch (Exception e) {
			}
			try {
				con.close();
			} catch (Exception e) {
			}
		}
		return list;
	}
}
