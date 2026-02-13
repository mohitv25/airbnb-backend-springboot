package com.mohit.stayease.Controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.mohit.stayease.Dto.HotelDTO;
import com.mohit.stayease.Dto.HotelInfoDto;
import com.mohit.stayease.Dto.HotelPriceDTO;
import com.mohit.stayease.Dto.HotelSearchRequest;
import com.mohit.stayease.Service.Interfaces.HotelService;
import com.mohit.stayease.Service.Interfaces.InventoryService;

@RestController
@RequestMapping("/hotels")
@RequiredArgsConstructor
@SecurityRequirement(name = "BearerAuth")
@Tag(name = "Hotel Browse", description = "Browse and search for hotels")
public class HotelBrowseController {

    private final InventoryService inventoryService;
    private final HotelService hotelService;

    @PostMapping("/search")
    @Operation(summary = "Search for hotels", description = "Filter hotels based on location, price, availability, etc.")
    public ResponseEntity<Page<HotelPriceDTO>> searchHotels(@RequestBody HotelSearchRequest hotelSearchRequest) {

        Page<HotelPriceDTO> page = inventoryService.searchHotels(hotelSearchRequest);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{hotelId}/info")
    @Operation(summary = "Get detailed hotel information", description = "Retrieve information about a specific hotel")
    public ResponseEntity<HotelInfoDto> getHotelInfo(@PathVariable Long hotelId) {
        return ResponseEntity.ok(hotelService.getHotelInfoById(hotelId));
    }
}
