package com.example.callcenter.repository;

import com.example.callcenter.entity.Client;
import com.example.callcenter.entity.Employee;
import com.example.callcenter.entity.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface RequestRepository extends JpaRepository<Request, Long> {
    List<Request> getRequestsByClient(Client client);
    List<Request> getRequestsByEmployee(Employee employee);
    List<Request> getRequestsByDateCreatedBetween(LocalDate fromTheDate, LocalDate toTheDate);

    Request getByMsg(String fragmentOfMessage);

}
