package om.omantel.csv;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
//import java.io.Console;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
//import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class App {


	public static void main(String[] args) throws IOException {

			//System.out.println("Input File: ");
            String filename = args[0];
            File file = new File(filename);
          
		BufferedReader reader = new BufferedReader(new FileReader(
				file));

		String line = null;
		Scanner scanner = null;
		int index = 0;
		List<Data> dataList = new ArrayList<>();

        PrintStream out = new PrintStream(new FileOutputStream("output.txt"));

		while ((line = reader.readLine()) != null) {
			Data stat = new Data();
			scanner = new Scanner(line);
			//System.out.println("Input delimiter: ");
			scanner.useDelimiter(args[1]);
			while (scanner.hasNext()) {
				String data = scanner.next();
				if (index == 0)
					stat.setFN(data);
				else if (index == 1)
					stat.setLN(data);
				else if (index == 2)
					stat.setAN(data);
				else if (index == 3)
					stat.setDOB(data);
                else if (index == 4)
                    stat.setGender(data);
                else if (index == 5)
                    stat.setNat(data);
                else if (index == 6)
                    stat.setDeg(data);
                else if (index == 7)
                    stat.setGPA(data);
                else if (index == 8)
                    stat.setSalary(Integer.parseInt(data));
				else
					System.out.println("invalid data::" + data);
				index++;
			}
			index = 0;
			dataList.add(stat);

		}
		
        System.setOut(out);
        out.println(dataList+"\n");
        out.close();
		reader.close();

		
		System.out.println(dataList);
		
	}
    
}
