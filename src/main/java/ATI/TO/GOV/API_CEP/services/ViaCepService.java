package ATI.TO.GOV.API_CEP.services;
import ATI.TO.GOV.API_CEP.dto.ViaCepResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ATI.TO.GOV.API_CEP.exceptions.InvalidCepException;

@Service
public class ViaCepService {

    private static final String VIA_CEP_API = "https://viacep.com.br/ws/%s/json/";
    private static final Logger LOGGER = LoggerFactory.getLogger(ViaCepService.class);

    public ViaCepResponse consultaCep(String cep) {
        RestTemplate restTemplate = new RestTemplate();
        String url = String.format(VIA_CEP_API, cep);
        ResponseEntity<ViaCepResponse> response = restTemplate.getForEntity(url, ViaCepResponse.class);

        ViaCepResponse viaCepResponse = response.getBody();
        if (viaCepResponse == null || viaCepResponse.getCep() == null) {
            throw new InvalidCepException("CEP inválido" + cep);
        }

        LOGGER.info("CEP consultado: " + cep);

        return viaCepResponse;
    }
}

