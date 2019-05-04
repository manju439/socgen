package com.socgen.EmployeePortal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class EmployeePortalApplicationTests {

    @InjectMocks
    private EmployeePortalApplication employeePortalApplication;

    @Test
    public void contextLoads() {
        String[] args = {};
        employeePortalApplication.main(args);
    }

}
