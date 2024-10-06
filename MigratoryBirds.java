import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result
{
    public static int migratoryBirds(List<Integer> arr)
    {
        HashMap<Integer, Integer> birdCounter = new HashMap<>();
        int maxFrequency = 0;
        int mostCommonBird = Integer.MAX_VALUE;
        
        for (int bird : arr)
        {
            int birdCount = birdCounter.getOrDefault(bird, 0) + 1;
            birdCounter.put(bird, birdCount);
            
            if (birdCount > maxFrequency)
            {
                maxFrequency = birdCount;
                mostCommonBird = bird;
            }
            else if (birdCount == maxFrequency && bird < mostCommonBird)
            {
                mostCommonBird = bird;
            }
        }
        
        return mostCommonBird;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.migratoryBirds(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
