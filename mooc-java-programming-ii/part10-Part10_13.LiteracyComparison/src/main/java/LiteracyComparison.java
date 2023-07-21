
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class LiteracyComparison {
    
    public static void main(String[] args) {
        ArrayList<Literacy> literacies = list("literacy.csv");
        literacies.stream()
                .sorted()
                .forEach(lt -> System.out.println(lt));
    }
    
    public static ArrayList<Literacy> list(String file) {
        ArrayList<Literacy> list = new ArrayList<>();
        try {
            list = Files.lines(Paths.get("literacy.csv"))
                    .map(row -> row.split(","))
                    .filter(arr -> arr.length >= 6)
                    .map(parts -> {
                            String theme = parts[0];
                            String ageGroup = parts[1];
                            String gender = parts[2].contains("female") ? "female" : "male";
                            String country = parts[3];
                            int year = Integer.valueOf(parts[4]);
                            double literacyRate = Double.valueOf(parts[5]);
                            
                            return new Literacy(theme, ageGroup, gender, country, year, literacyRate);
                        }
                    ).collect(Collectors.toCollection(ArrayList::new));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return list;
    }
}
