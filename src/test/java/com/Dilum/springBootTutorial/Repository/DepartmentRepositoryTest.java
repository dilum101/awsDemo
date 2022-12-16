package com.Dilum.springBootTutorial.Repository;

import com.Dilum.springBootTutorial.Entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class DepartmentRepositoryTest {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private TestEntityManager entityManager;

    @BeforeEach
    void setUp() {

        Department department = Department.builder().departmentAddress("Melbourne").departmentName("JAVA")
                .depatmentCode("IT-108").build();

        Department department2= Department.builder().departmentAddress("Melbourne").departmentName("JAVAEE")
                .depatmentCode("IT-109").build();

        entityManager.persist(department);
        entityManager.persist(department2);
    }

    @Test
    public void whenFindById_thenReturnDepartment()
    {
        Department found = departmentRepository.findById(2L).get();
        assertEquals(found.getDepartmentName(),"JAVAEE");
    }


}