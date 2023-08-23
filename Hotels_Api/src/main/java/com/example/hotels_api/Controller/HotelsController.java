package com.example.hotels_api.Controller;



import com.example.hotels_api.Api.ApiResponse;
import com.example.hotels_api.Model.Hotels;
import com.example.hotels_api.Repository.BranchRepository;
import com.example.hotels_api.Service.HotelsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/hotels")
public class HotelsController {

    private final HotelsService hotelsService;



    @GetMapping("/get")
    public ResponseEntity getAll(){
        return ResponseEntity.status(200).body(hotelsService.getAll());
    }


    @PostMapping("/add")
    public ResponseEntity add(@RequestBody @Valid Hotels hotels){
        hotelsService.add(hotels);
        return ResponseEntity.status(200).body(new ApiResponse("added"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Integer id){

        hotelsService.delete(id);
        return ResponseEntity.status(200).body(new ApiResponse("deleted"));
    }

}
