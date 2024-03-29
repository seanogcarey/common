package dcu.common.hibernate;

/**
 * Created by Sean on 13/02/2016.
 */
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.File;

public class SessionFactoryHelper {
    private static final SessionFactory sessionFactory;

    static {
        try {
            //
            // Build a SessionFactory object from session-factory configuration
            // defined in the hibernate.cfg.xml file. In this file we register
            // the JDBC connection information, connection pool, the hibernate
            // dialect that we used and the mapping to our hbm.xml file for each
            // Pojo (Plain Old Java Object).
            //

            //File f = new File("C:\\Users\\seano\\Documents\\DCU work\\CASE4\\Project\\SpringWorkspace\\common\\src\\main\\resources\\hibernate.cfg.xml");
            //sessionFactory = new Configuration().configure(f).buildSessionFactory();
//C:\Users\seano\Documents\DCU work\CASE4\Project\SpringWorkspace\common\src\main\resources


            Configuration configuration = new Configuration();
            System.out.println("dewrw");
            sessionFactory = configuration.configure("hibernate.cfg.xml").buildSessionFactory();
            System.out.println("ccccccc");
            //configuration.addResource("Claim.hbm.xml").configure();


            //sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable e) {
            System.err.println("Error in creating SessionFactory object."
                    + e.getMessage());
            throw new ExceptionInInitializerError(e);
        }
    }
// C:/Users/seano/Documents/DCU work/CASE4/Project/SpringWorkspace/common/src/main/java/dcu/common/resource
    /**
     * A static method for other application to get SessionFactory object
     * initialized in this helper class.
     */
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
//   /src/hibernate.cfg.xml