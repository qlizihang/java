package Fifth_work;

/**
 * @author qlizihang
 * @date 2023/6/4 21:59
 * @description:   JDBC测试
 */


import java.sql.*;

public class JDBCExample {
    public static void main(String[] args) throws Exception {
        //注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        //获取连接
        String url = "jdbc:mysql:///jdbc";
        String user = "root";
        String psw = "1848483386";
        Connection connection = DriverManager.getConnection(url,user,psw);
        //1.插入数据：
        System.out.println("第一题效果-----------------\n");
        insertData(connection);
        //2.遍历输出:
        System.out.println("第二题效果-----------------\n");
        printData(connection);
        //3.删除s004的数据：
        System.out.println("第三题效果-----------------\n");
        deleteData(connection);
        //4.查询s003：
        System.out.println("第四题效果-----------------\n");
        selectData(connection);
        //5.修改信息：
        System.out.println("第五题效果-----------------\n");
        updateData(connection);

        //关闭资源
        connection.close();
    }
    private static void insertData(Connection connection) throws SQLException {
        //SQL：
        String sql = "insert into student values(?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        //赋值
        preparedStatement.setObject(1,"s001");
        preparedStatement.setObject(2,"老大");
        preparedStatement.setObject(3,20);
        preparedStatement.setObject(4,"计算机学院");
        preparedStatement.execute();

        preparedStatement.setObject(1,"s002");
        preparedStatement.setObject(2,"老二");
        preparedStatement.setObject(3,19);
        preparedStatement.setObject(4,"计算机学院");
        preparedStatement.execute();

        preparedStatement.setObject(1,"s003");
        preparedStatement.setObject(2,"老三");
        preparedStatement.setObject(3,18);
        preparedStatement.setObject(4,"计算机学院");
        preparedStatement.execute();

        preparedStatement.setObject(1,"s004");
        preparedStatement.setObject(2,"老四");
        preparedStatement.setObject(3,17);
        preparedStatement.setObject(4,"计算机学院");
        preparedStatement.execute();
        printData(connection);

    }

    //2.遍历输出
    private static void printData(Connection connection) throws SQLException {
        String sql = "select * from student";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery(sql);
        while (resultSet.next()){
            String SNO = resultSet.getString("SNO");
            String Name = resultSet.getString("Name");
            Integer Age = resultSet.getInt("Age");
            String College = resultSet.getString("College");
            System.out.println(SNO + "--" + Name + "--" + Age +"--" + College);
        }

    }
    private static void deleteData(Connection connection) throws SQLException {
        String sql = "delete from student where SNO=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setObject(1,"s004");
        preparedStatement.executeUpdate();
        printData(connection);

    }

    private static void selectData(Connection connection) throws SQLException{
        String sql = "select * from student where SNO=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setObject(1,"s003");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            String SNO = resultSet.getString("SNO");
            String Name = resultSet.getString("Name");
            Integer Age = resultSet.getInt("Age");
            String College = resultSet.getString("College");
            System.out.println(SNO + "--" + Name + "--" + Age +"--" + College);
        }


    }

    private static void updateData(Connection connection) throws SQLException {
        String sql = "update student set College =? where SNO = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setObject(1,"通信学院");
        preparedStatement.setObject(2,"s001");
        preparedStatement.executeUpdate();
        printData(connection);


    }
}
