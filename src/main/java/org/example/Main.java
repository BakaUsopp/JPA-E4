package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.example.entities.Employee;
import org.example.entities.Product;
import org.example.entities.Students;
import org.example.entities.keys.StudentKey;
import org.example.persistence.CustomPersistenceUnitInfo;
import org.hibernate.jpa.HibernatePersistenceProvider;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        String puName = "pu-name";
        Map<String,String> props = new HashMap<>();
        props.put("hibernate.show_sql", "true");
        props.put("hibernate.hbm2ddl.auto", "none"); // create ,update, none

        EntityManagerFactory emf = new HibernatePersistenceProvider()
                .createContainerEntityManagerFactory(new CustomPersistenceUnitInfo(puName), props);

        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

//            var e1 = new Employee();
//            e1.setName("Usopp");
//            e1.setAddress("Ohio");
//
//            em.persist(e1);
//
//            Product pr = new Product();
//            pr.setCode("USO");
//            pr.setNumber(1);
//            pr.setColor("Blue");
//
//            em.persist(pr);
//
//
//
            StudentKey id = new StudentKey();
            id.setCode("ABC");
            id.setNumber(2);
//
//            Students s = new Students();
//            s.setId(id);
//            s.setName("Usopp");
//            em.persist(s);

            Students s =em.find(Students.class,id);
            System.out.println(s);




            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

}