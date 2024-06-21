package ATI.TO.GOV.API_CEP.controllers;

import ATI.TO.GOV.API_CEP.dto.ViaCepResponse;
import ATI.TO.GOV.API_CEP.services.ViaCepService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ViaCepController {

    private final ViaCepService service;

    public ViaCepController(ViaCepService service) {
        this.service = service;
    }

    @GetMapping("/cep/{cep}")
    public ViaCepResponse consultaCep(@PathVariable String cep) {
        return service.consultaCep(cep);
    }
}
