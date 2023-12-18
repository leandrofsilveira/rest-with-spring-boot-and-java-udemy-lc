package br.com.lfrancisco.mapper;

import java.util.ArrayList;
import java.util.List;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

public class DozerMapper {

	private static Mapper mapper = DozerBeanMapperBuilder.buildDefault();

	public static <O, D> D parseObject(O origin, Class<D> destination) {
		return mapper.map(origin, destination);
	}

	public static <O, D> List<D> parseListObject(List<O> originList, Class<D> destination) {
		List<D> destinationObjects = new ArrayList<>();

		for (O origin : originList) {
			destinationObjects.add(mapper.map(origin, destination));
		}

		return destinationObjects;
	}

}
