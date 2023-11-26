package com.project.OnlineAuctionSystemBackend.service;

import com.project.OnlineAuctionSystemBackend.dto.UserDto;
import com.project.OnlineAuctionSystemBackend.entity.UsersTable;
import com.project.OnlineAuctionSystemBackend.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.Objects;

@Service
public class UserService {
    @Autowired
    private UsersRepository usersRepository;

    @Transactional
    public String saveNewUser(UserDto userDto)  {
        UsersTable usersTable = new UsersTable();
        usersTable.setUserName(userDto.getUserName());
        usersTable.setEmail(userDto.getEmail());
        usersTable.setPassword(userDto.getPassword());
        UsersTable userInserted = usersRepository.save(usersTable);
        return "true";
    }

    public String verifyUser(UserDto userDto) {
        Optional<UsersTable> user = usersRepository.findByEmail(userDto.getEmail());
        if(user.isPresent()){
            if(Objects.equals(user.get().getEmail(),userDto.getEmail()) && Objects.equals(user.get().getPassword(), userDto.getPassword())) {
                return "true";
            }
        }
        return "false";
    }
}
