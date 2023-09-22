package com.chris.oreillyclone.service;

import com.chris.oreillyclone.model.*;
import com.chris.oreillyclone.repository.UserRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ContextConfiguration(classes = {CustomerUserServiceImplementation.class})
@ExtendWith(SpringExtension.class)
class CustomerUserServiceImplementationTest {
    @Autowired
    private CustomerUserServiceImplementation customerUserServiceImplementation;

    @MockBean
    private UserRepository userRepository;

    /**
     * Method under test: {@link CustomerUserServiceImplementation#loadUserByUsername(String)}
     */
    @Test
    void testLoadUserByUsername() throws UsernameNotFoundException {
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
        UserDetails actualLoadUserByUsernameResult = customerUserServiceImplementation.loadUserByUsername("janedoe");
        assertTrue(actualLoadUserByUsernameResult.getAuthorities().isEmpty());
        assertTrue(actualLoadUserByUsernameResult.isEnabled());
        assertTrue(actualLoadUserByUsernameResult.isCredentialsNonExpired());
        assertTrue(actualLoadUserByUsernameResult.isAccountNonLocked());
        assertTrue(actualLoadUserByUsernameResult.isAccountNonExpired());
        assertEquals("jane.doe@example.org", actualLoadUserByUsernameResult.getUsername());
        assertEquals("iloveyou", actualLoadUserByUsernameResult.getPassword());
        verify(userRepository).findByEmail(Mockito.<String>any());
    }

    /**
     * Method under test: {@link CustomerUserServiceImplementation#loadUserByUsername(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testLoadUserByUsername2() throws UsernameNotFoundException {
        User user = mock(User.class);
        when(user.getEmail()).thenReturn("");
        when(user.getPassword()).thenReturn("iloveyou");
        doNothing().when(user).setAddressList(Mockito.<List<Address>>any());
        doNothing().when(user).setCreatedAt(Mockito.<LocalDateTime>any());
        doNothing().when(user).setEmail(Mockito.<String>any());
        doNothing().when(user).setFirstName(Mockito.<String>any());
        doNothing().when(user).setId(Mockito.<Long>any());
        doNothing().when(user).setLastName(Mockito.<String>any());
        doNothing().when(user).setMobile(Mockito.<String>any());
        doNothing().when(user).setPassword(Mockito.<String>any());
        doNothing().when(user).setPaymentInformationList(Mockito.<List<PaymentInformation>>any());
        doNothing().when(user).setRatingList(Mockito.<List<Rating>>any());
        doNothing().when(user).setReviewList(Mockito.<List<Review>>any());
        doNothing().when(user).setRole(Mockito.<String>any());
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
        customerUserServiceImplementation.loadUserByUsername("janedoe");
    }

    /**
     * Method under test: {@link CustomerUserServiceImplementation#loadUserByUsername(String)}
     */
    @Test
    void testLoadUserByUsername3() throws UsernameNotFoundException {
        Optional<User> emptyResult = Optional.empty();
        when(userRepository.findByEmail(Mockito.<String>any())).thenReturn(emptyResult);
        assertThrows(UsernameNotFoundException.class,
                () -> customerUserServiceImplementation.loadUserByUsername("janedoe"));
        verify(userRepository).findByEmail(Mockito.<String>any());
    }
}

