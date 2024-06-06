package br.com.eloir.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import br.com.eloir.entity.Premio;
import br.com.eloir.repository.PremioRepository;


@Service
public class ImportadorCsvService {

	@Value("${arquivo.csv.carga.windows}")
    String filePathWindows;
	
    @Value("${arquivo.csv.carga.linux}")
    String filePathLinux;
	
	@Autowired
	private PremioRepository movieRepository;
	

    public void importCsvToDatabase() {

    	String filePath = getFilePath();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {

            List<Premio> premios = reader.lines()
                    .skip(1) // Skip header line
                    .map(line -> {
                        String[] fields = line.split(";");
                        return new Premio(
                                Integer.parseInt(fields[0]),
                                fields[1],
                                fields[2],
                                fields[3],
                                fields.length == 5 ? Boolean.parseBoolean(fields[4]) : Boolean.FALSE 
                        );
                    })
                    .collect(Collectors.toList());

            movieRepository.saveAll(premios);
            
            System.out.println("CSV data imported successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private String getFilePath() {
        String os = System.getProperty("os.name").toLowerCase();

        if (os.contains("win")) {
            return filePathWindows;
        } else if (os.contains("nix") || os.contains("nux") || os.contains("aix")) {
            return filePathLinux;
        } else {
            System.err.println("Unsupported operating system.");
            return null;
        }

    }
    
}