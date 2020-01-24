import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;

public class Application {
    public static void main(String[] args) throws IOException {
        System.out.println("Verifying certificates...");
        Path path = Path.of(URI.create("file:///etc/ssl/certs/java/"));
        if (Files.exists(path)) {
            System.out.println(path + " exists, listing files:");
            Files.walk(path)
                    .filter(p -> Files.isRegularFile(p))
                    .forEach(System.out::println);
        } else {
            throw new RuntimeException(path + " does not exist");
        }
        System.out.println("Certificates verified OK!\n\n\n");

        System.out.println("Getting https://google.com");
        ResponseEntity<String> response = new RestTemplate().getForEntity("https://google.com", String.class);
        System.out.println("Got response from https://google.com with status " + response.getStatusCode());
    }
}
