package com.company.back.backendlogic;

import com.company.back.models.Students;

import java.util.ArrayList;

public interface DAO {

     Students getStudentByName(String name);
     ArrayList<Students> getStudensts();
     void addStident(Students student);

}
