package com.example.callcenter.service;

import com.example.callcenter.entity.Client;
import com.example.callcenter.entity.Employee;
import com.example.callcenter.entity.Request;
import com.example.callcenter.entity.RequestDto;
import com.example.callcenter.repository.RequestRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.junit4.SpringRunner;


import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
class RequestServiceTest {

    @Autowired
    private RequestService requestService;


    @Autowired
    private RequestRepository requestRepository;

    @Test
    void postRequest(){

        Client client = new Client();
        client.setName("Test");
        Employee employee = new Employee();
        employee.setName("Test1");

        RequestDto dto = new RequestDto();
        dto.setIdClient(client.getIdClient());
        dto.setIdEmployee(employee.getIdEmployee());
        dto.setMsg("Test_Msg");

        Request request = new Request();
        request.setIdRequest(100L);
        request.setClient(client);
        request.setEmployee(employee);
        request.setMsg("Test");

        Request createdRequest = requestService.addRequest(dto);
        Assert.assertNotNull("Test_add_request",createdRequest);
    }

    @Test
    void getEmployeeAllRequest(){
        Employee employee = new Employee();
        List<Request> requestsList;
        requestsList = requestRepository.getRequestsByEmployee(employee);
        Assert.assertNotNull(requestsList);
    }
}