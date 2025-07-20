package com.example.service;

import com.example.dto.LoginRequestDto;
import com.example.dto.SignUpRequestDto;
import com.example.dto.UserDto;
import com.example.exception.*;
import com.example.model.Token;
import com.example.model.User;
import com.example.repository.TokenRepository;
import com.example.repository.UserRepository;
import com.example.utility.enums.State;
import com.example.utility.enums.constants.ExceptionMessage;
import org.modelmapper.ModelMapper;
import org.modelmapper.internal.bytebuddy.utility.RandomString;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

import static com.example.utility.enums.constants.ExceptionMessage.*;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final TokenRepository tokenRepository;

    public AuthServiceImpl(UserRepository userRepository,
                           ModelMapper modelMapper,
                           BCryptPasswordEncoder  bCryptPasswordEncoder,
                           TokenRepository tokenRepository
    ) {
        this.userRepository = userRepository;
        this.modelMapper    = modelMapper;
        this.bCryptPasswordEncoder = new BCryptPasswordEncoder();
        this.tokenRepository = tokenRepository;
    }
    @Override
    public UserDto signup(SignUpRequestDto signUpDto) {
       Optional<User> userOptional= userRepository.findUsersByEmail(signUpDto.getEmail());
       if(userOptional.isPresent()){
           throw new UserAlreadyExistException(userAlreadyPresent+signUpDto.getEmail());
       }

        User user = modelMapper.map(signUpDto,User.class);
        user.setPassword(bCryptPasswordEncoder.encode(signUpDto.getPassword()));
        User saveUser= userRepository.save(user);
        return modelMapper.map(saveUser,UserDto.class);
    }

    @Override
    public String login(LoginRequestDto userDto) {
        User userOptional ;
        if(userDto.getEmail()!=null) {
            userOptional = userRepository.findUsersByEmail(userDto.getEmail())
                    .orElseThrow(() -> new UsernameNotFoundException(userNotFound));
        }else{
            userOptional = userRepository.findUserByUsername(userDto.getUsername())
                    .orElseThrow(()-> new UsernameNotFoundException(userNotFound));
        }


        if(!bCryptPasswordEncoder.matches(userDto.getPassword(),userOptional.getPassword())){
            throw new PasswordValidationFail(userPasswordMismatch);
        }

        //create a token and store it in database
        Token token = new Token();
        token.setUser(userOptional);
        token.setValue(RandomString.make(20));
        token.setState(State.ACTIVE);
        //token.setValue(RandomStringUtils.randomAlphanumeric(16));
        token.setExpiryDate(new java.util.Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24)); // 24 hours expiry


        tokenRepository.save(token);
        return  token.getValue();
   //     return new Pair<>(modelMapper.map(userOptional,UserDto.class),"token");
    }

    @Override
    public UserDto validateToken(String token) {
        if (token == null || token.isEmpty()) {
            throw new ValidateException(ExceptionMessage.tokenValidation);
        }

        Token savedToken=tokenRepository.findByValueAndExpiryDateAfter(token, new Date());
        if (savedToken == null || savedToken.getState() != State.ACTIVE) {
            if(savedToken!=null) {
                savedToken.setState(State.INACTIVE);
                tokenRepository.save(savedToken);
            }
            throw new TokenInvalidException(ExceptionMessage.tokenInvalid);
        }


        return modelMapper.map(savedToken.getUser(),UserDto.class); // Assuming User has a method to convert to UserDto
    }

}
