package pe.isil.resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.isil.model.Appoinment;
import pe.isil.service.CreateAppoinmentEvent;

@RestController
@RequestMapping("/api/create-appoinment")
public class CreateAppoinmentResource {

    private final CreateAppoinmentEvent createAppoinmentEvent;

    public CreateAppoinmentResource(CreateAppoinmentEvent createAppoinmentEvent) {
        this.createAppoinmentEvent = createAppoinmentEvent;
    }

    @PostMapping
    public ResponseEntity createAppoinment(@RequestBody Appoinment appoinment) {
        createAppoinmentEvent.sendEvent(appoinment);
        return new ResponseEntity(HttpStatus.CREATED);
    }
}
