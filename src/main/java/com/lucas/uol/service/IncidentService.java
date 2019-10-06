package com.lucas.uol.service;

import com.lucas.uol.entities.Incident;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class IncidentService {

    public List<Incident> calculateAttendants() {
        HashMap<Integer, String> attendants = fillInAttendants();
        LocalDate date = LocalDate.now().minusDays(1);
        Integer numberTotalDays = 11;
        Integer keyAttendants = 1;
        List<Incident> incidents = new ArrayList<Incident>();

        for (int i = 0; i < numberTotalDays ; i++) {
            Incident incident = new Incident();
            incident.setDate(date);
            incident.setDayOfWeek(days(i));
            if(i > 2) incident.setDayOfWeek(date.getDayOfWeek().name());
            if (date.getDayOfWeek() != DayOfWeek.SATURDAY && date.getDayOfWeek() != DayOfWeek.SUNDAY)
                incident.setAttendant(attendants.get(keyAttendants++));
            incidents.add(incident);
            date = date.plusDays(1);
            if (keyAttendants > numberTotalDays) keyAttendants = 1;
        }

        return incidents;
    }

    private String days(Integer key){
        HashMap<Integer, String> days = new HashMap<>();
        days.put(0, "YESTERDAY");
        days.put(1, "TODAY");
        days.put(2, "TOMORROW");

        return days.get(key);
    }


    private HashMap<Integer, String> fillInAttendants(){

        HashMap<Integer, String> attendants = new HashMap<>();
        attendants.put(1,"João");
        attendants.put(2,"Maria");
        attendants.put(3,"Zeca");
        attendants.put(4,"Mario");
        attendants.put(5,"Gustavo");
        attendants.put(6,"Camila");
        attendants.put(7,"Pedro");
        attendants.put(8,"Juliana");
        attendants.put(9,"Gisele");

        return attendants;

    }
}
