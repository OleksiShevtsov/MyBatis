package mybatis_implementation;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import instances.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisSelectAllStudent {

    public static void main(String[] args) throws IOException {

        Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession session = sqlSessionFactory.openSession();

        //select contact all contacts
        List<Student> student = session.selectList("Student.getAll");

        for (Student st : student) {
            System.out.println(st.getId() + " " + st.getName() + " " + st.getBranch() + " " + st.getPercentage() + " " +
                    st.getPhone() + " " + st.getEmail() + "\n");
        }

        System.out.println("Records Read Successfully ");
        session.commit();
        session.close();
    }
}

