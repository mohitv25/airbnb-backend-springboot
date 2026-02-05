package com.mohit.airbnb.Service.Interfaces;

import org.springframework.data.domain.Page;

import com.mohit.airbnb.Dto.*;
import com.mohit.airbnb.Entities.RoomEntity;

import java.util.List;

public interface InventoryService {
    void initializeRoomForAYear(RoomEntity room);

    void deleteAllInventories(RoomEntity room);

    Page<HotelPriceDTO> searchHotels(HotelSearchRequest hotelSearchRequest);

    List<InventoryDTO> getAllInventoryByRoom(Long roomId);

    void updateInventory(Long roomId, UpdateInventoryRequestDTO updateInventoryRequestDto);
}
