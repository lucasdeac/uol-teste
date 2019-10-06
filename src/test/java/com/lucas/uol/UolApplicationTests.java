package com.lucas.uol;

import com.lucas.uol.entities.Incident;
import com.lucas.uol.service.IncidentService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UolApplicationTests {

	@Autowired
	private IncidentService incidentService;

	@Test
	public void shouldReturnNullAttendantWhenWeekend(){
		List<Incident> incidents = incidentService.calculateAttendants();
		incidents.forEach( it ->{
			LocalDate date = it.getDate();
			if(date.getDayOfWeek() == DayOfWeek.SATURDAY || date.getDayOfWeek() == DayOfWeek.SATURDAY){
				Assert.assertNull(it.getAttendant());
			}
		});
	}

	@Test
	public void contextLoads() {

	}

}
