package com.mohit.stayease.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mohit.stayease.Dto.RoomDTO;
import com.mohit.stayease.Entities.HotelEntity;
import com.mohit.stayease.Entities.RoomEntity;
import com.mohit.stayease.Entities.UserEntity;
import com.mohit.stayease.Exceptions.ResourceNotFoundException;
import com.mohit.stayease.Exceptions.UnAuthorisedException;
import com.mohit.stayease.Repositories.HotelRepository;
import com.mohit.stayease.Repositories.RoomRepository;
import com.mohit.stayease.Service.Interfaces.InventoryService;
import com.mohit.stayease.Service.Interfaces.RoomService;

import static com.mohit.stayease.Utils.AppUtils.getCurrentUser;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;
    private final HotelRepository hotelRepository;
    private final InventoryService inventoryService;
    private final ModelMapper modelMapper;

    @Override
    public RoomDTO createNewRoom(Long hotelId, RoomDTO roomDto) {
        log.info("Creating a new room in hotel with ID: {}", hotelId);

        HotelEntity hotel = hotelRepository
                .findById(hotelId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Hotel not found with ID: " + hotelId));

        UserEntity user = getCurrentUser();
        if (!user.equals(hotel.getOwner())) {
            throw new UnAuthorisedException(
                    "This user does not own this hotel with id: " + hotelId);
        }

        RoomEntity room = modelMapper.map(roomDto, RoomEntity.class);
        room.setHotel(hotel);
        room = roomRepository.save(room);

        // Inventory only if hotel is active
        if (Boolean.TRUE.equals(hotel.getActive())) {
            inventoryService.initializeRoomForAYear(room);
        }

        return modelMapper.map(room, RoomDTO.class);
    }

    @Override
    public List<RoomDTO> getAllRoomsInHotel(Long hotelId) {
        log.info("Getting all rooms in hotel with ID: {}", hotelId);

        HotelEntity hotel = hotelRepository
                .findById(hotelId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Hotel not found with ID: " + hotelId));

        UserEntity user = getCurrentUser();
        if (!user.equals(hotel.getOwner())) {
            throw new UnAuthorisedException(
                    "This user does not own this hotel with id: " + hotelId);
        }

        return hotel.getRooms()
                .stream()
                .map(room -> modelMapper.map(room, RoomDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public RoomDTO getRoomById(Long roomId) {
        log.info("Getting the room with ID: {}", roomId);

        RoomEntity room = roomRepository
                .findById(roomId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Room not found with ID: " + roomId));

        return modelMapper.map(room, RoomDTO.class);
    }

    @Override
    @Transactional
    public void deleteRoomById(Long roomId) {
        log.info("Deleting the room with ID: {}", roomId);

        RoomEntity room = roomRepository
                .findById(roomId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Room not found with ID: " + roomId));

        UserEntity user = getCurrentUser();
        if (!user.equals(room.getHotel().getOwner())) {
            throw new UnAuthorisedException(
                    "This user does not own this room with id: " + roomId);
        }

        inventoryService.deleteAllInventories(room);
        roomRepository.deleteById(roomId);
    }

    @Override
    @Transactional
    public RoomDTO updateRoomById(Long hotelId, Long roomId, RoomDTO roomDto) {
        log.info("Updating the room with ID: {}", roomId);

        HotelEntity hotel = hotelRepository
                .findById(hotelId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Hotel not found with ID: " + hotelId));

        UserEntity user = getCurrentUser();
        if (!user.equals(hotel.getOwner())) {
            throw new UnAuthorisedException(
                    "This user does not own this hotel with id: " + hotelId);
        }

        RoomEntity room = roomRepository
                .findById(roomId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Room not found with ID: " + roomId));

        modelMapper.map(roomDto, room);
        room.setId(roomId);

        // Future improvement: sync inventory if price / count changes
        room = roomRepository.save(room);

        return modelMapper.map(room, RoomDTO.class);
    }
}