package com.chris.oreillyclone.service;

import com.chris.oreillyclone.config.JwtProvider;
import com.chris.oreillyclone.exception.UserException;
import com.chris.oreillyclone.model.User;
import com.chris.oreillyclone.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ContextConfiguration(classes = {UserServiceImplementation.class})
@ExtendWith(SpringExtension.class)
class UserServiceImplementationTest {
    @MockBean
    private JwtProvider jwtProvider;

    @MockBean
    private UserRepository userRepository;

    @Autowired
    private UserServiceImplementation userServiceImplementation;

    /**
     * Method under test: {@link UserServiceImplementation#findUserById(Long)}
     */
    @Test
    void testFindUserById() throws UserException {
        User user = new User();
        user.setAddressList(new ArrayList<>());
        user.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setId(1L);
        user.setLastName("Doe");
        user.setMobile("Mobile");
        user.setPassword("iloveyou");
        user.setPaymentInformationList(new ArrayList<>());
        user.setRatingList(new ArrayList<>());
        user.setReviewList(new ArrayList<>());
        user.setRole("Role");
        Optional<User> ofResult = Optional.of(user);
        when(userRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);
        assertSame(user, userServiceImplementation.findUserById(1L));
        verify(userRepository).findById(Mockito.<Long>any());
    }

    /**
     * Method under test: {@link UserServiceImplementation#findUserById(Long)}
     */
    @Test
    void testFindUserById2() throws UserException {
        Optional<User> emptyResult = Optional.empty();
        when(userRepository.findById(Mockito.<Long>any())).thenReturn(emptyResult);
        assertThrows(UserException.class, () -> userServiceImplementation.findUserById(1L));
        verify(userRepository).findById(Mockito.<Long>any());
    }

    /**
     * Method under test: {@link UserServiceImplementation#findUserByJWT(String)}
     */
    @Test
    void testFindUserByJWT() throws UserException {
        User user = new User();
        user.setAddressList(new ArrayList<>());
        user.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setId(1L);
        user.setLastName("Doe");
        user.setMobile("Mobile");
        user.setPassword("iloveyou");
        user.setPaymentInformationList(new ArrayList<>());
        user.setRatingList(new ArrayList<>());
        user.setReviewList(new ArrayList<>());
        user.setRole("Role");
        Optional<User> ofResult = Optional.of(user);
        when(userRepository.findByEmail(Mockito.<String>any())).thenReturn(ofResult);
        when(jwtProvider.getEmailFromToken(Mockito.<String>any())).thenReturn("ABC123");
        assertSame(user, userServiceImplementation.findUserByJWT("Jwt"));
        verify(userRepository).findByEmail(Mockito.<String>any());
        verify(jwtProvider).getEmailFromToken(Mockito.<String>any());
    }

    /**
     * Method under test: {@link UserServiceImplementation#findUserByJWT(String)}
     */
    @Test
    void testFindUserByJWT2() throws UserException {
        Optional<User> emptyResult = Optional.empty();
        when(userRepository.findByEmail(Mockito.<String>any())).thenReturn(emptyResult);
        when(jwtProvider.getEmailFromToken(Mockito.<String>any())).thenReturn("ABC123");
        assertThrows(UserException.class, () -> userServiceImplementation.findUserByJWT("Jwt"));
        verify(userRepository).findByEmail(Mockito.<String>any());
        verify(jwtProvider).getEmailFromToken(Mockito.<String>any());
    }

    /**
     * Method under test: {@link UserServiceImplementation#findUserByEmail(String)}
     */
    @Test
    void testFindUserByEmail() throws UserException {
        User user = new User();
        user.setAddressList(new ArrayList<>());
        user.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setId(1L);
        user.setLastName("Doe");
        user.setMobile("Mobile");
        user.setPassword("iloveyou");
        user.setPaymentInformationList(new ArrayList<>());
        user.setRatingList(new ArrayList<>());
        user.setReviewList(new ArrayList<>());
        user.setRole("Role");
        Optional<User> ofResult = Optional.of(user);
        when(userRepository.findByEmail(Mockito.<String>any())).thenReturn(ofResult);
        assertSame(user, userServiceImplementation.findUserByEmail("jane.doe@example.org"));
        verify(userRepository).findByEmail(Mockito.<String>any());
    }

    /**
     * Method under test: {@link UserServiceImplementation#findUserByEmail(String)}
     */
    @Test
    void testFindUserByEmail2() throws UserException {
        Optional<User> emptyResult = Optional.empty();
        when(userRepository.findByEmail(Mockito.<String>any())).thenReturn(emptyResult);
        assertThrows(UserException.class, () -> userServiceImplementation.findUserByEmail("jane.doe@example.org"));
        verify(userRepository).findByEmail(Mockito.<String>any());
    }
}

