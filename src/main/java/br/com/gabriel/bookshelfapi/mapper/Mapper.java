package br.com.gabriel.bookshelfapi.mapper;


import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Mapper {

    private static final ModelMapper mapper = new ModelMapper();

    public static <O, D> D parseObject(O origin, Class<D> destination){
        return mapper.map(origin, destination);
    }

    public static <O, D> List<D> parseListObject(List<O> origin, Class<D> destination){
        List<D> destinationList = new ArrayList<D>();
        for (O o : origin){
            destinationList.add(mapper.map(o, destination));;
        }
        return destinationList;
    }
}
