package mybatis_implementation;

import java.io.IOException;
import java.io.Reader;

import instances.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisSelectStudent {

    public static void main(String[] args) throws IOException {

        Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession session = sqlSessionFactory.openSession();

        //select a particular student  by  id
        Student student = session.selectOne("Student.getById", 2);

        //Print the student details
        System.out.println(student.getId() + " " + student.getName() + " " + student.getBranch() + " " +
                student.getPercentage() + " " + student.getPhone() + " " + student.getEmail() + "\n");

        session.commit();
        session.close();

    }

}
