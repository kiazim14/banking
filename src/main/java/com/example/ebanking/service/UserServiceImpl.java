package com.example.ebanking.service;

import com.example.ebanking.entity.Users;
import com.example.ebanking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigInteger;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoded;

    @Override
    public Users findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public Users save(Users theUser) {
        theUser.setPassword(passwordEncoded.encode(theUser.getPassword()));
        return userRepository.saveAndFlush(theUser);
    }

    @Override
    public Users findByAccountNo(BigInteger accountNo) {
        return userRepository.findByAccountNo(accountNo);
    }

    @Override
    public Users findByResetPasswordToken(String token) {
        return userRepository.findByResetPasswordToken(token);
    }

    @Override
    public void updateResetPasswordToken(String token, String email) {
        Users theUser = userRepository.findByEmail(email);
        theUser.setResetPasswordToken(token);
        userRepository.saveAndFlush(theUser);
    }

    @Override
    public void updatePassword(String password, String token) {
        Users theUser = userRepository.findByResetPasswordToken(token);
        theUser.setPassword(passwordEncoded.encode(password));
        theUser.setResetPasswordToken(null);
        userRepository.saveAndFlush(theUser);
    }

    @Override
    public Users findByOTP(String otp) {
        return userRepository.findByotp(otp);
    }

    @Override
    public void updateStatus(String otp) {
        Users theUser = userRepository.findByotp(otp);
        theUser.setStatus(1);
        theUser.setOtp(null);
        userRepository.saveAndFlush(theUser);
    }

    @Override
    public void updateOtp(String otp, String email) {
        Users theUser = userRepository.findByEmail(email);
        theUser.setOtp(otp);
        userRepository.saveAndFlush(theUser);
    }

    @Override
    public void deleteAccount(String email) {
        userRepository.deleteUser(email);
    }
}
