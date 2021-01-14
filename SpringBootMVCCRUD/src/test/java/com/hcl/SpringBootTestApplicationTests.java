import java.net.URI;
import java.net.URISyntaxException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
 
import com.hcl.model.Employee;
 
//@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class SpringBootDemoApplicationTests 
{   
    @LocalServerPort
    int randomServerPort;
     
    @Test
    public void testAddEmployeeSuccess() throws URISyntaxException 
    {
        RestTemplate restTemplate = new RestTemplate();
        final String baseUrl = "http://localhost:"+randomServerPort+"/employees/";
        URI uri = new URI(baseUrl);
        Employee employee = new Employee(111 "John");
         
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-COM-PERSIST", "true");      
 
        HttpEntity<Employee> request = new HttpEntity<>(employee, headers);
         
        ResponseEntity<String> result = restTemplate.postForEntity(uri, request, String.class);
         
        //Verify request succeed
        Assertions.assertEquals(201, result.getStatusCodeValue());
    }
     
    @Test
    public void testAddEmployeeMissingHeader() throws URISyntaxException 
    {
        RestTemplate restTemplate = new RestTemplate();
        final String baseUrl = "http://localhost:"+randomServerPort+"/employees/";
        URI uri = new URI(baseUrl);
        Employee employee = new Employee(null, "Adam", "Gilly", "test@email.com");
         
        HttpHeaders headers = new HttpHeaders();
 
        HttpEntity<Employee> request = new HttpEntity<>(employee, headers);
         
        try
        {
            restTemplate.postForEntity(uri, request, String.class);
            Assertions.fail();
        }
        catch(HttpClientErrorException ex) 
        {
            //Verify bad request and missing header
            Assertions.assertEquals(400, ex.getRawStatusCode());
            Assertions.assertEquals(true, ex.getResponseBodyAsString().contains("Missing request header"));
        }
    }
 
    @Test
    public void testGetEmployeeListSuccessWithHeaders() throws URISyntaxException 
    {
        RestTemplate restTemplate = new RestTemplate();
         
        final String baseUrl = "http://localhost:"+randomServerPort+"/employees/";
        URI uri = new URI(baseUrl);
         
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-COM-LOCATION", "USA");
 
        HttpEntity<Employee> requestEntity = new HttpEntity<>(null, headers);
 
        try
        {
            restTemplate.exchange(uri, HttpMethod.GET, requestEntity, String.class);
            Assertions.fail();
        }
        catch(HttpClientErrorException ex) 
        {
            //Verify bad request and missing header
            Assertions.assertEquals(400, ex.getRawStatusCode());
            Assertions.assertEquals(true, ex.getResponseBodyAsString().contains("Missing request header"));
        }
    }
}