package mybatis_implementation;

import java.io.IOException;
import java.io.Reader;

import instances.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUpdateStudent {

    public static void main(String[] args) throws IOException {

        Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession session = sqlSessionFactory.openSession();

        //select a particular student using id
        Student student = session.selectOne("Student.getById", 1);
        System.out.println("Current details of the student are");
        System.out.println(student);

        //Set new values to the mail and phone number of the student
        student.setEmail("mohamad123@yahoo.com");
        student.setPhone(6789543);

        //Update the student record
        session.update("Student.update", student);
        System.out.println("Record updated successfully");
        session.commit();
        session.close();
    }
}
