package hu.office.model.service.data;

import java.util.List;

public interface DataParser<T> {

	List<T> parse(List<String> lines);
}
