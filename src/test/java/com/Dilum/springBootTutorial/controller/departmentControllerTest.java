package com.Dilum.springBootTutorial.controller;

import com.Dilum.springBootTutorial.Entity.Department;
import com.Dilum.springBootTutorial.Service.DepartmentService;
import org.h2.mvstore.type.DataType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest
class departmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DepartmentService departmentService;

    private Department department;


    @BeforeEach
    void setUp() {

        department = Department.builder().departmentName("Java").departmentAddress("ABC").depatmentCode("IT")
                .departmentId(1L).build();
    }

    @Test
    void saveDepartment() throws Exception {
        Department inputDepartment = Department.builder().departmentName("Java").departmentAddress("ABC").depatmentCode("IT")
                .build();

        Mockito.when(departmentService.saveDepartment(inputDepartment)).thenReturn(department);

        mockMvc.perform(MockMvcRequestBuilders.post("/departments").contentType(MediaType.APPLICATION_JSON).content("{\n" +
                "        \n" +
                "        \"departmentName\": \"Java\",\n" +
                "        \"departmentAddress\": \"ABC\",\n" +
                "        \"depatmentCode\": \"IT\"\n" +
                "    }")).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void fetchDepartmentById() {
    }
}