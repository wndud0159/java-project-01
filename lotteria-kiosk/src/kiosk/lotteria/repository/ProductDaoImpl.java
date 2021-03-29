package kiosk.lotteria.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kiosk.lotteria.entity.ProductDto;

public class ProductDaoImpl implements ProductDao {
	private static final ProductDaoImpl INSTANCE = new ProductDaoImpl();
	public static final String DRIVER = "com.mysql.jdbc.Driver";
	
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	
	
	// 싱글턴 패턴
	public static ProductDaoImpl getInstance() {
		return INSTANCE;
	}
	
	// DB연결
	private Connection getConnection() {
		final String url = "jdbc:mysql://localhost:3306/jypdb";
	    final String user = "jyp";
		final String password = "1234";
		try {
			return DriverManager.getConnection(url, user, password);
		} catch(SQLException e) {
			return null;
		}
	}
	
	private void getClose(ResultSet rs, PreparedStatement pstmt, Connection conn)throws SQLException {
		if(rs != null) {
			rs.close();
		}
		if(pstmt != null) {
			pstmt.close();
		}
		if(conn != null) {
			conn.close();
		}
	}
	
	@Override
	public List<ProductDto> productTypeList() {
		this.conn = getConnection();
		final String sql = "select * from product order by productId asc";
		try {
			this.pstmt = conn.prepareStatement(sql);
			this.rs = this.pstmt.executeQuery();
			
			final List<ProductDto> list = new ArrayList<>();
			
			while(rs.next()) {
				list.add(new ProductDto(rs.getLong("productId"),rs.getString("productType")));
			}
			
			getClose(this.rs, this.pstmt, this.conn);
			return list;
		} catch(SQLException e) {
			e.getStackTrace();
		}
		return null;
	}
	
	
	@Override
	public List<ProductDto> productListByType(String type) {
		this.conn = getConnection();
		final String sql = "select productId, productName, productPrice from productInfo where productType=? order by productId asc";
		try {
			this.pstmt = conn.prepareStatement(sql);
			this.pstmt.setString(1, type);
			rs = pstmt.executeQuery();
			
			final List<ProductDto> list = new ArrayList<>();
			
			while(rs.next()) {
				list.add(new ProductDto(rs.getLong("productId"),rs.getString("productName"),rs.getLong("productPrice")));
			}
			
			getClose(this.rs, this.pstmt, this.conn);
			return list;
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
