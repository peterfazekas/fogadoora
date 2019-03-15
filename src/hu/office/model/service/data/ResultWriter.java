package hu.office.model.service.data;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ResultWriter {

	public String print(String output, String text) {
		try (PrintWriter pw = new PrintWriter(new FileWriter(output))) {
			pw.println(text);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return text;
	}
	
}
