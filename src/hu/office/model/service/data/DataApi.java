package hu.office.model.service.data;

import java.util.List;

public class DataApi<T> {
	
	private final DataReader input;
	private final DataParser<T> data;

	
	public DataApi(DataReader input, DataParser<T> data) {
		this.input = input;
		this.data = data;
	}


	public List<T> getData(String name) {
		return data.parse(input.read(name));
	}
	
	

}
