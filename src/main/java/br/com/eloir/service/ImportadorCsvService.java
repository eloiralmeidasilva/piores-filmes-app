package br.com.eloir.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
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

        	List<Premio> premios = new ArrayList<>();
        	
            reader.lines()
                    .skip(1) // Skip header line
                    .forEach(line -> {
                        String[] fields = line.split(";");
                        String[] produtores = fields[3].split(",");
                        
                        
                        for(int i=0; i < produtores.length; i++) {
                        	String[] produtoresAnd = produtores[i].split("and");
                        	
                        	for(int a=0; a < produtoresAnd.length; a++) {
                        		
                        		premios.add(new Premio(
                                        Integer.parseInt(fields[0]),
                                        fields[1],
                                        fields[2],
                                        produtoresAnd[a].trim(),
                                        fields.length == 5 ? fields[4].equals("yes") ? Boolean.TRUE : Boolean.FALSE  : Boolean.FALSE 
                                      )
                                );
                        	}
                        }
                    });
                    
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