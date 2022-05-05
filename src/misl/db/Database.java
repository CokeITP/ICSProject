package misl.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import misl.spring.model.extra.ResultMap;


public class Database {
	
	public Connection conn = null;
	private boolean autoConn = true;
	
	public Database() {
		
	}
	
	public void setAutoConn(boolean b) {
		this.autoConn = b;
	}
	
	private Connection getConnection() {
		try {
			conn = HikariCPDataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;

	}

	public boolean open() {
		conn = getConnection();
		return true;
	}
	
	public boolean close() {
		try {
			if (conn != null) {
				if (!conn.isClosed()) {
					conn.close();
				}
			}
			return true;
		} catch (SQLException ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public boolean commit() {
		try {
			conn.commit();
			return true;
		} catch (SQLException ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public boolean rollback() {
		try {
			conn.rollback();
			return true;
		} catch (SQLException ex) {
			ex.printStackTrace();
			return false;
		}
	}

	// return code
	public int add(String sql,Object... params) {
		int lastId = -1;
		try {
			if(autoConn) {
				conn = getConnection();
			}
			conn.setAutoCommit(false);
			if (conn != null) {
				PreparedStatement stmt = conn.prepareStatement(sql);
				for(int i = 1 ; i <= params.length ; i++) {
					stmt.setObject(i, params[i-1]);
				}
				lastId = stmt.executeUpdate();
				stmt.close();
			}
			return lastId;
		} catch (SQLException ex) {
			try {
				conn.rollback();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ex.printStackTrace();
		} finally {
			try {
				conn.setAutoCommit(true);
				if(autoConn) {
					close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return lastId;
	}

	// return key of inserted
	public int add(String sql, String[] returnId, Object... params) {
		int lastId = -1;
		try {
			if(autoConn) {
				conn = getConnection();
			}
			conn.setAutoCommit(false);

			if (conn != null) {
				PreparedStatement stmt = conn.prepareStatement(sql, returnId);
				for(int i = 1 ; i <= params.length ; i++) {
					stmt.setObject(i, params[i-1]);
				}
				stmt.executeUpdate();
				ResultSet rs = stmt.getGeneratedKeys();
				if (rs != null && rs.next()) {
					lastId = rs.getInt(1);
				}
				rs.close();
				stmt.close();
			}
			return lastId;
		} catch (SQLException ex) {
			try {
				conn.rollback();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ex.printStackTrace();
		} finally {
			try {
				conn.setAutoCommit(true);
				if(autoConn) {
					close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return lastId;
	}
	
// return key of inserted -- legacy
	public int add(String sql, String[] returnId) {
		int lastId = -1;
		try {
			if(autoConn) {
				conn = getConnection();
			}
			conn.setAutoCommit(false);

			if (conn != null) {
				PreparedStatement stmt = conn.prepareStatement(sql, returnId);
				stmt.executeUpdate();
				ResultSet rs = stmt.getGeneratedKeys();
				if (rs != null && rs.next()) {
					lastId = rs.getInt(1);
				}
				rs.close();
				stmt.close();
			}
			return lastId;
		} catch (SQLException ex) {
			try {
				conn.rollback();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ex.printStackTrace();
		} finally {
			try {
				conn.setAutoCommit(true);
				if(autoConn) {
					close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return lastId;
	}

	public int update(String sql, Object... params) {
		int lastId = -1;
		try {
			if(autoConn) {
				conn = getConnection();
			}
			conn.setAutoCommit(false);
			if (conn != null) {
				PreparedStatement stmt = conn.prepareStatement(sql);
				for(int i = 1 ; i <= params.length ; i++) {
					stmt.setObject(i, params[i-1]);
				}
				lastId = stmt.executeUpdate();
				stmt.close();
			}
			return lastId;
		} catch (SQLException ex) {
			try {
				conn.rollback();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ex.printStackTrace();
		} finally {
			try {
				conn.setAutoCommit(true);
				if(autoConn) {
					close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return lastId;
	}

	public int remove(String sql,Object... params) {
		int lastId = -1;
		try {
			if(autoConn) {
				conn = getConnection();
			}
			conn.setAutoCommit(false);
			if (conn != null) {
				PreparedStatement stmt = conn.prepareStatement(sql);
				for(int i = 1 ; i <= params.length ; i++) {
					stmt.setObject(i, params[i-1]);
				}
				lastId = stmt.executeUpdate();
				stmt.close();
			}
			return lastId;
		} catch (SQLException ex) {
			try {
				conn.rollback();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ex.printStackTrace();
		} finally {
			try {
				conn.setAutoCommit(true);
				if(autoConn) {
					close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return lastId;
	}

	public ResultMap querySingle(String sql, Object... params) {
		ResultMap map = new ResultMap();
		try {
			if(autoConn) {
				conn = getConnection();
			}
			if (conn != null) {
				PreparedStatement stmt = conn.prepareStatement(sql);
				
				for(int i = 1 ; i <= params.length ; i++) {
					stmt.setObject(i, params[i-1]);
				}
				
				ResultSet rs = stmt.executeQuery();
				ResultSetMetaData rsMetaData = rs.getMetaData();
				if (rs.isBeforeFirst()) {
					while (rs.next()) {
						for (int i = 0; i < rsMetaData.getColumnCount(); i++) {
							map.put(rsMetaData.getColumnLabel(i + 1), rs.getString(i + 1));
						}
					}
				}
				rs.close();
				stmt.close();

				return map;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			if(autoConn) {
				close();
			}
		}
		return map;
	}

	public ArrayList<ResultMap> queryList(String sql, Object... params) {
		ArrayList<ResultMap> mapList = new ArrayList<ResultMap>();
		try {
			if(autoConn) {
				conn = getConnection();
			}
			if (conn != null) {
				PreparedStatement stmt = conn.prepareStatement(sql);
				for(int i = 1 ; i <= params.length ; i++) {
					stmt.setObject(i, params[i-1]);
				}
				ResultSet rs = stmt.executeQuery();
				ResultSetMetaData rsMetaData = rs.getMetaData();
				if (rs.isBeforeFirst()) {
					while (rs.next()) {
						ResultMap map = new ResultMap();
						for (int i = 0; i < rsMetaData.getColumnCount(); i++) {
							map.put(rsMetaData.getColumnLabel(i + 1), rs.getString(i + 1));
						}
						mapList.add(map);
					}
				}
				rs.close();
				stmt.close();

				return mapList;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			if(autoConn) {
				close();
			}
		}
		return mapList;
	}
}
