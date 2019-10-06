package com.lucas.uol.endpoint;

import com.google.gson.Gson;
import com.lucas.uol.entities.Incident;
import com.lucas.uol.service.IncidentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.Swagger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api("API REST Atendentes")
@CrossOrigin(origins = "*")
public class IncidentEndPoint {

    @GetMapping("/im-day")
    @ApiOperation(value = "Retorna uma lista de dias e o atendente para o respectivo dia. ")
    public ResponseEntity<String> imDay(){
       IncidentService incidentService = new IncidentService();
       List<Incident> incidents = incidentService.calculateAttendants();
       String json = new Gson().toJson(incidents);
       return ResponseEntity.ok(json);
    }

}
