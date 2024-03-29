package com.icolak.service.impl;

import com.icolak.client.WeatherApiClient;
import com.icolak.dto.AddressDTO;
import com.icolak.dto.WeatherDTO;
import com.icolak.entity.Address;
import com.icolak.util.MapperUtil;
import com.icolak.repository.AddressRepository;
import com.icolak.service.AddressService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;
    private final MapperUtil mapperUtil;
    private final WeatherApiClient weatherApiClient;

    @Value("${access_key}")
    private String access_key;

    public AddressServiceImpl(AddressRepository addressRepository, MapperUtil mapperUtil, WeatherApiClient weatherApiClient) {
        this.addressRepository = addressRepository;
        this.mapperUtil = mapperUtil;
        this.weatherApiClient = weatherApiClient;
    }

    @Override
    public List<AddressDTO> findAll() {
        return addressRepository.findAll()
                .stream()
                .map(address -> mapperUtil.convert(address, new AddressDTO()))
                .collect(Collectors.toList());
    }

    @Override
    public AddressDTO findById(Long id) throws Exception {

        Address foundAddress = addressRepository.findById(id)
                .orElseThrow(() -> new Exception("No Address Found!"));

        // after we get the address from the db, since this address entity doesn't have the temperature field
        // we set temperature for the addressDTO before returning.
        AddressDTO addressDTO = mapperUtil.convert(foundAddress, new AddressDTO());
        addressDTO.setCurrentTemperature(getCurrentWeather(addressDTO.getCity()) // returns WeatherDTO
                .getCurrent().getTemperature());

        return addressDTO;

    }

    @Override
    public AddressDTO update(AddressDTO addressDTO) throws Exception {

        addressRepository.findById(addressDTO.getId())
                .orElseThrow(() -> new Exception("No Address Found!"));

        Address addressToSave = mapperUtil.convert(addressDTO, new Address());

        addressRepository.save(addressToSave);

        AddressDTO updatedAddress = mapperUtil.convert(addressToSave, new AddressDTO());
        updatedAddress.setCurrentTemperature(getCurrentWeather(updatedAddress.getCity()).getCurrent().getTemperature());

        return updatedAddress;

    }

    @Override
    public AddressDTO create(AddressDTO addressDTO) throws Exception {

        Optional<Address> foundAddress = addressRepository.findById(addressDTO.getId());

        if (foundAddress.isPresent()) {
            throw new Exception("Address Already Exists!");
        }

        Address addressToSave = mapperUtil.convert(addressDTO, new Address());

        addressRepository.save(addressToSave);

        return mapperUtil.convert(addressToSave, new AddressDTO());

    }

    private WeatherDTO getCurrentWeather(String city) {
        return weatherApiClient.getCurrentWeather(access_key, city);
    }

}