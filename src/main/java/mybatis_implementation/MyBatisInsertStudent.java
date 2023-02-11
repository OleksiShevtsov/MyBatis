package mybatis_implementation;

import java.io.IOException;
import java.io.Reader;

import instances.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisInsertStudent {

    public static void main(String[] args) throws IOException{

        Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession session = sqlSessionFactory.openSession();

        //Create a new student object
        Student student = new Student("Bill","Phisics", 75, 753134, "bill@gmail.com" );

        //Insert student data
        session.insert("Student.insert", student);
        System.out.println("record inserted successfully");
        session.commit();
        session.close();

    }

}
