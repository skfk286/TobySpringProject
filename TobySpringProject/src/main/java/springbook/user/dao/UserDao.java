package springbook.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import springbook.user.domain.User;

/**
 * <pre>
 * TABLE : USERS
 *      필드명 | 타입 | 설정
 *      Id,       VARCHAR(10), Primary key
 *      Name,     VARCHAR(20), Not Null
 *      Password, VARCHAR(20), Not Null
 * </pre>
 * 
 * 
 * @author ycjung
 *
 */
public class UserDao {
    public void addUser(User user) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection c = DriverManager.getConnection("jdbc:mysql://localhost/springbook", "spring", "book");
        
        PreparedStatement ps = c.prepareStatement(
                "insert into users(id, name, password) values(?, ?, ?)");
        ps.setString(1, user.getId());
        ps.setString(2, user.getName());
        ps.setString(3, user.getPassword());
        
        ps.executeUpdate();
        
        ps.close();
        c.close();
    }
}
