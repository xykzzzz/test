package groupid;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TestMaven {
    public static void main(String[] args) {
        query("中文系2019级3班");
    }
    public static List<Classes> query(String name)  {
        Connection connection=null;
        Statement statement=null;
        ResultSet resultSet=null;
        try {
            //加载jdbc驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            //创建数据库连接
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/db_test?user=root&password=ekuyaix123..&useUnicode=true&characterEncoding=UTF-8");
           /* System.out.println(connection);*/
            //创建操作命令对象Statement
            statement=connection.createStatement();
            //执行sql语句
            String sql=" select cla.name,stu.name,cou.name,sco.score from student stu\n" +
                    "     join classes cla on cla.id=stu.classes_id\n" +
                    "     join score sco on sco.student_id=stu.id\n" +
                    "     join course cou on sco.course_id=cou.id\n" +
                    "     where cla.name='" +
                    name+
                    "'";
            resultSet = statement.executeQuery(sql);
            //处理结果集
            List<Classes> list=new ArrayList<>();
            while (resultSet.next()){
                String cla = resultSet.getString("cla.name");
                String stu=resultSet.getString("stu.name");
                String cou=resultSet.getString("cou.name");
                double sco=resultSet.getDouble("sco.score");
                System.out.printf("cla=%s,stu=%s,cou=%s,sco=%s%n",
                        cla, stu, cou, sco);
                Classes classes=new Classes();
                classes.setClassName(cla);
                classes.setStudentName(stu);
                classes.setCourseName(cou);
                classes.setScore(sco);
                list.add(classes);
            }
            System.out.println(list);
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("没有找到："+e);
        } finally {
            try{
                if(connection!=null){
                    connection.close();
                }
                if(statement!=null){
                    statement.close();
                }
                if(resultSet!=null){
                    resultSet.close();
                }
            }catch (SQLException throwables){
                throwables.printStackTrace();
            }
        }
    }
    private static class Classes{
        String className;
        String studentName;
        String courseName;
        Double score;

        public String getClassName() {
            return className;
        }

        public String getStudentName() {
            return studentName;
        }

        public String getCourseName() {
            return courseName;
        }

        public double getScore() {
            return score;
        }

        public void setClassName(String className) {
            this.className = className;
        }

        public void setStudentName(String studentName) {
            this.studentName = studentName;
        }

        public void setCourseName(String courseName) {
            this.courseName = courseName;
        }

        public void setScore(double score) {
            this.score = score;
        }
    }

}
