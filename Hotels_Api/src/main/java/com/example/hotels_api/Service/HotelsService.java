package com.example.hotels_api.Service;
import com.example.hotels_api.Api.ApiException;
import com.example.hotels_api.Model.Hotels;
import com.example.hotels_api.Repository.BranchRepository;
import com.example.hotels_api.Repository.HotelsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HotelsService {

    private final HotelsRepository hotelsRepository;
    private final BranchRepository branchRepository;


    public List<Hotels> getAll(){
        return hotelsRepository.findAll();
    }

    public void add(Hotels hotels){
        hotelsRepository.save(hotels);
    }

    public void update(Integer id,Hotels hotels){
        Hotels hotels1= hotelsRepository.findHotelById(id);

        if (hotels1==null){
            throw new ApiException("not found");
        }

        hotels1.setName(hotels.getName());
        hotelsRepository.save(hotels1);
    }


    public void delete(Integer id){
        Hotels hotels1= hotelsRepository.findHotelById(id);
        if (hotels1==null){
            throw new ApiException("not found");
        }
        hotelsRepository.delete(hotels1);
    }



}