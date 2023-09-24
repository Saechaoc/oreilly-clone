//package com.chris.oreillyclone.controller;
//import com.chris.oreillyclone.model.User;
//
//import com.chris.oreillyclone.config.JwtProvider;
//import com.chris.oreillyclone.exception.UserException;
//import com.chris.oreillyclone.model.*;
//import com.chris.oreillyclone.repository.UserRepository;
//import com.chris.oreillyclone.request.LoginRequest;
//import com.chris.oreillyclone.response.AuthResponse;
//import com.chris.oreillyclone.service.CustomerUserServiceImplementation;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.jupiter.api.Disabled;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//import org.springframework.test.web.servlet.ResultActions;
//import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.*;
//import static org.mockito.Mockito.when;
//
//@ContextConfiguration(classes = {AuthController.class})
//@ExtendWith(SpringExtension.class)
//class AuthControllerTest {
//    @Autowired
//    private AuthController authController;
//
//    @MockBean
//    private CustomerUserServiceImplementation customerUserServiceImplementation;
//
//    @MockBean
//    private JwtProvider jwtProvider;
//
//    @MockBean
//    private PasswordEncoder passwordEncoder;
//
//    @MockBean
//    private UserRepository userRepository;
//
//    /**
//     * Method under test: {@link AuthController#createUserHandler(User)}
//     */
//    @Test
//    void testCreateUserHandler() throws UserException {
//        User user = new User();
//        user.setAddressList(new ArrayList<>());
//        user.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
//        user.setEmail("jane.doe@example.org");
//        user.setFirstName("Jane");
//        user.setId(1L);
//        user.setLastName("Doe");
//        user.setMobile("Mobile");
//        user.setPassword("iloveyou");
//        user.setPaymentInformationList(new ArrayList<>());
//        user.setRatingList(new ArrayList<>());
//        user.setReviewList(new ArrayList<>());
//        user.setRole("Role");
//        Optional<User> ofResult = Optional.of(user);
//
//        User user2 = new User();
//        user2.setAddressList(new ArrayList<>());
//        user2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
//        user2.setEmail("jane.doe@example.org");
//        user2.setFirstName("Jane");
//        user2.setId(1L);
//        user2.setLastName("Doe");
//        user2.setMobile("Mobile");
//        user2.setPassword("iloveyou");
//        user2.setPaymentInformationList(new ArrayList<>());
//        user2.setRatingList(new ArrayList<>());
//        user2.setReviewList(new ArrayList<>());
//        user2.setRole("Role");
//        UserRepository userRepository = mock(UserRepository.class);
//        when(userRepository.save(Mockito.<User>any())).thenReturn(user2);
//        when(userRepository.findByEmail(Mockito.<String>any())).thenReturn(ofResult);
//        JwtProvider jwtProvider = new JwtProvider();
//        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        AuthController authController = new AuthController(userRepository, jwtProvider, passwordEncoder,
//                new CustomerUserServiceImplementation(mock(UserRepository.class)));
//
//        User user3 = new User();
//        user3.setAddressList(new ArrayList<>());
//        user3.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
//        user3.setEmail("jane.doe@example.org");
//        user3.setFirstName("Jane");
//        user3.setId(1L);
//        user3.setLastName("Doe");
//        user3.setMobile("Mobile");
//        user3.setPassword("iloveyou");
//        user3.setPaymentInformationList(new ArrayList<>());
//        user3.setRatingList(new ArrayList<>());
//        user3.setReviewList(new ArrayList<>());
//        user3.setRole("Role");
//        ResponseEntity<AuthResponse> actualCreateUserHandlerResult = authController.createUserHandler(user3);
//        assertTrue(actualCreateUserHandlerResult.hasBody());
//        assertTrue(actualCreateUserHandlerResult.getHeaders().isEmpty());
//        assertEquals(201, actualCreateUserHandlerResult.getStatusCodeValue());
//        assertEquals("Sign up success", actualCreateUserHandlerResult.getBody().getMessage());
//        verify(userRepository).save(Mockito.<User>any());
//        verify(userRepository).findByEmail(Mockito.<String>any());
//    }
//
//    /**
//     * Method under test: {@link AuthController#createUserHandler(User)}
//     */
//    @Test
//    void testCreateUserHandler2() throws UserException {
//        User user = new User();
//        user.setAddressList(new ArrayList<>());
//        user.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
//        user.setEmail("jane.doe@example.org");
//        user.setFirstName("Jane");
//        user.setId(1L);
//        user.setLastName("Doe");
//        user.setMobile("Mobile");
//        user.setPassword("iloveyou");
//        user.setPaymentInformationList(new ArrayList<>());
//        user.setRatingList(new ArrayList<>());
//        user.setReviewList(new ArrayList<>());
//        user.setRole("Role");
//        Optional<User> ofResult = Optional.of(user);
//        UserRepository userRepository = mock(UserRepository.class);
//        when(userRepository.save(Mockito.<User>any())).thenThrow(new BadCredentialsException("Msg"));
//        when(userRepository.findByEmail(Mockito.<String>any())).thenReturn(ofResult);
//        JwtProvider jwtProvider = new JwtProvider();
//        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        AuthController authController = new AuthController(userRepository, jwtProvider, passwordEncoder,
//                new CustomerUserServiceImplementation(mock(UserRepository.class)));
//
//        User user2 = new User();
//        user2.setAddressList(new ArrayList<>());
//        user2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
//        user2.setEmail("jane.doe@example.org");
//        user2.setFirstName("Jane");
//        user2.setId(1L);
//        user2.setLastName("Doe");
//        user2.setMobile("Mobile");
//        user2.setPassword("iloveyou");
//        user2.setPaymentInformationList(new ArrayList<>());
//        user2.setRatingList(new ArrayList<>());
//        user2.setReviewList(new ArrayList<>());
//        user2.setRole("Role");
//        assertThrows(BadCredentialsException.class, () -> authController.createUserHandler(user2));
//        verify(userRepository).save(Mockito.<User>any());
//        verify(userRepository).findByEmail(Mockito.<String>any());
//    }
//
//    /**
//     * Method under test: {@link AuthController#createUserHandler(User)}
//     */
//    @Test
//    void testCreateUserHandler3() throws UserException {
//        UserRepository userRepository = mock(UserRepository.class);
//        Optional<User> emptyResult = Optional.empty();
//        when(userRepository.findByEmail(Mockito.<String>any())).thenReturn(emptyResult);
//        JwtProvider jwtProvider = new JwtProvider();
//        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        AuthController authController = new AuthController(userRepository, jwtProvider, passwordEncoder,
//                new CustomerUserServiceImplementation(mock(UserRepository.class)));
//
//        User user = new User();
//        user.setAddressList(new ArrayList<>());
//        user.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
//        user.setEmail("jane.doe@example.org");
//        user.setFirstName("Jane");
//        user.setId(1L);
//        user.setLastName("Doe");
//        user.setMobile("Mobile");
//        user.setPassword("iloveyou");
//        user.setPaymentInformationList(new ArrayList<>());
//        user.setRatingList(new ArrayList<>());
//        user.setReviewList(new ArrayList<>());
//        user.setRole("Role");
//        assertThrows(UserException.class, () -> authController.createUserHandler(user));
//        verify(userRepository).findByEmail(Mockito.<String>any());
//    }
//
//    /**
//     * Method under test: {@link AuthController#createUserHandler(User)}
//     */
//    @Test
//    @Disabled("TODO: Complete this test")
//    void testCreateUserHandler4() throws UserException {
//        User user = new User();
//        user.setAddressList(new ArrayList<>());
//        user.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
//        user.setEmail("jane.doe@example.org");
//        user.setFirstName("Jane");
//        user.setId(1L);
//        user.setLastName("Doe");
//        user.setMobile("Mobile");
//        user.setPassword("iloveyou");
//        user.setPaymentInformationList(new ArrayList<>());
//        user.setRatingList(new ArrayList<>());
//        user.setReviewList(new ArrayList<>());
//        user.setRole("Role");
//        Optional<User> ofResult = Optional.of(user);
//
//        User user2 = new User();
//        user2.setAddressList(new ArrayList<>());
//        user2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
//        user2.setEmail("jane.doe@example.org");
//        user2.setFirstName("Jane");
//        user2.setId(1L);
//        user2.setLastName("Doe");
//        user2.setMobile("Mobile");
//        user2.setPassword("iloveyou");
//        user2.setPaymentInformationList(new ArrayList<>());
//        user2.setRatingList(new ArrayList<>());
//        user2.setReviewList(new ArrayList<>());
//        user2.setRole("Role");
//        UserRepository userRepository = mock(UserRepository.class);
//        when(userRepository.save(Mockito.<User>any())).thenReturn(user2);
//        when(userRepository.findByEmail(Mockito.<String>any())).thenReturn(ofResult);
//        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        AuthController authController = new AuthController(userRepository, null, passwordEncoder,
//                new CustomerUserServiceImplementation(mock(UserRepository.class)));
//
//        User user3 = new User();
//        user3.setAddressList(new ArrayList<>());
//        user3.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
//        user3.setEmail("jane.doe@example.org");
//        user3.setFirstName("Jane");
//        user3.setId(1L);
//        user3.setLastName("Doe");
//        user3.setMobile("Mobile");
//        user3.setPassword("iloveyou");
//        user3.setPaymentInformationList(new ArrayList<>());
//        user3.setRatingList(new ArrayList<>());
//        user3.setReviewList(new ArrayList<>());
//        user3.setRole("Role");
//        authController.createUserHandler(user3);
//    }
//
//    /**
//     * Method under test: {@link AuthController#createUserHandler(User)}
//     */
//    @Test
//    void testCreateUserHandler5() throws UserException {
//        User user = new User();
//        user.setAddressList(new ArrayList<>());
//        user.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
//        user.setEmail("jane.doe@example.org");
//        user.setFirstName("Jane");
//        user.setId(1L);
//        user.setLastName("Doe");
//        user.setMobile("Mobile");
//        user.setPassword("iloveyou");
//        user.setPaymentInformationList(new ArrayList<>());
//        user.setRatingList(new ArrayList<>());
//        user.setReviewList(new ArrayList<>());
//        user.setRole("Role");
//        Optional<User> ofResult = Optional.of(user);
//
//        User user2 = new User();
//        user2.setAddressList(new ArrayList<>());
//        user2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
//        user2.setEmail("jane.doe@example.org");
//        user2.setFirstName("Jane");
//        user2.setId(1L);
//        user2.setLastName("Doe");
//        user2.setMobile("Mobile");
//        user2.setPassword("iloveyou");
//        user2.setPaymentInformationList(new ArrayList<>());
//        user2.setRatingList(new ArrayList<>());
//        user2.setReviewList(new ArrayList<>());
//        user2.setRole("Role");
//        UserRepository userRepository = mock(UserRepository.class);
//        when(userRepository.save(Mockito.<User>any())).thenReturn(user2);
//        when(userRepository.findByEmail(Mockito.<String>any())).thenReturn(ofResult);
//        JwtProvider jwtProvider = mock(JwtProvider.class);
//        when(jwtProvider.generateToken(Mockito.<Authentication>any())).thenReturn("ABC123");
//        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        AuthController authController = new AuthController(userRepository, jwtProvider, passwordEncoder,
//                new CustomerUserServiceImplementation(mock(UserRepository.class)));
//
//        User user3 = new User();
//        user3.setAddressList(new ArrayList<>());
//        user3.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
//        user3.setEmail("jane.doe@example.org");
//        user3.setFirstName("Jane");
//        user3.setId(1L);
//        user3.setLastName("Doe");
//        user3.setMobile("Mobile");
//        user3.setPassword("iloveyou");
//        user3.setPaymentInformationList(new ArrayList<>());
//        user3.setRatingList(new ArrayList<>());
//        user3.setReviewList(new ArrayList<>());
//        user3.setRole("Role");
//        ResponseEntity<AuthResponse> actualCreateUserHandlerResult = authController.createUserHandler(user3);
//        assertTrue(actualCreateUserHandlerResult.hasBody());
//        assertTrue(actualCreateUserHandlerResult.getHeaders().isEmpty());
//        assertEquals(201, actualCreateUserHandlerResult.getStatusCodeValue());
//        AuthResponse body = actualCreateUserHandlerResult.getBody();
//        assertEquals("Sign up success", body.getMessage());
//        assertEquals("ABC123", body.getJwt());
//        verify(userRepository).save(Mockito.<User>any());
//        verify(userRepository).findByEmail(Mockito.<String>any());
//        verify(jwtProvider).generateToken(Mockito.<Authentication>any());
//    }
//
//    /**
//     * Method under test: {@link AuthController#createUserHandler(User)}
//     */
//    @Test
////    @Disabled("TODO: Complete this test")
//    void testCreateUserHandler6() throws UserException {
//        User user = new User();
//        user.setAddressList(new ArrayList<>());
//        user.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
//        user.setEmail("jane.doe@example.org");
//        user.setFirstName("Jane");
//        user.setId(1L);
//        user.setLastName("Doe");
//        user.setMobile("Mobile");
//        user.setPassword("iloveyou");
//        user.setPaymentInformationList(new ArrayList<>());
//        user.setRatingList(new ArrayList<>());
//        user.setReviewList(new ArrayList<>());
//        user.setRole("Role");
//        Optional<User> ofResult = Optional.of(user);
//
//        User user2 = new User();
//        user2.setAddressList(new ArrayList<>());
//        user2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
//        user2.setEmail("jane.doe@example.org");
//        user2.setFirstName("Jane");
//        user2.setId(1L);
//        user2.setLastName("Doe");
//        user2.setMobile("Mobile");
//        user2.setPassword("iloveyou");
//        user2.setPaymentInformationList(new ArrayList<>());
//        user2.setRatingList(new ArrayList<>());
//        user2.setReviewList(new ArrayList<>());
//        user2.setRole("Role");
//        UserRepository userRepository = mock(UserRepository.class);
//        when(userRepository.save(Mockito.<User>any())).thenReturn(user2);
//        when(userRepository.findByEmail(Mockito.<String>any())).thenReturn(ofResult);
//        JwtProvider jwtProvider = mock(JwtProvider.class);
//        when(jwtProvider.generateToken(Mockito.<Authentication>any())).thenReturn("ABC123");
//
//        PasswordEncoder passwordEncoder = mock(PasswordEncoder.class);
//        when(passwordEncoder.encode(anyString())).thenReturn("EncodedPassword");
//        AuthController authController = new AuthController(userRepository, jwtProvider, passwordEncoder, new CustomerUserServiceImplementation(mock(UserRepository.class)));
//
//        User user3 = mock(User.class);
//        when(user3.getEmail()).thenReturn("jane.doe@example.org");
//        when(user3.getFirstName()).thenReturn("Jane");
//        when(user3.getLastName()).thenReturn("Doe");
//        when(user3.getPassword()).thenReturn("iloveyou");
//        doNothing().when(user3).setAddressList(Mockito.<List<Address>>any());
//        doNothing().when(user3).setCreatedAt(Mockito.<LocalDateTime>any());
//        doNothing().when(user3).setEmail(Mockito.<String>any());
//        doNothing().when(user3).setFirstName(Mockito.<String>any());
//        doNothing().when(user3).setId(Mockito.<Long>any());
//        doNothing().when(user3).setLastName(Mockito.<String>any());
//        doNothing().when(user3).setMobile(Mockito.<String>any());
//        doNothing().when(user3).setPassword(Mockito.<String>any());
//        doNothing().when(user3).setPaymentInformationList(Mockito.<List<PaymentInformation>>any());
//        doNothing().when(user3).setRatingList(Mockito.<List<Rating>>any());
//        doNothing().when(user3).setReviewList(Mockito.<List<Review>>any());
//        doNothing().when(user3).setRole(Mockito.<String>any());
//        user3.setAddressList(new ArrayList<>());
//        user3.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
//        user3.setEmail("jane.doe@example.org");
//        user3.setFirstName("Jane");
//        user3.setId(1L);
//        user3.setLastName("Doe");
//        user3.setMobile("Mobile");
//        user3.setPassword("iloveyou");
//        user3.setPaymentInformationList(new ArrayList<>());
//        user3.setRatingList(new ArrayList<>());
//        user3.setReviewList(new ArrayList<>());
//        user3.setRole("Role");
//        authController.createUserHandler(user3);
//    }
//
//    /**
//     * Method under test: {@link AuthController#loginUserHandler(LoginRequest)}
//     */
//    @Test
//    void testLoginUserHandler() throws Exception {
//        when(jwtProvider.generateToken(Mockito.<Authentication>any())).thenReturn("ABC123");
//        when(customerUserServiceImplementation.loadUserByUsername(Mockito.<String>any()))
//                .thenReturn(new org.springframework.security.core.userdetails.User("janedoe", "iloveyou", new ArrayList<>()));
//        when(passwordEncoder.matches(Mockito.<CharSequence>any(), Mockito.<String>any())).thenReturn(true);
//
//        LoginRequest loginRequest = new LoginRequest();
//        loginRequest.setEmail("jane.doe@example.org");
//        loginRequest.setPassword("iloveyou");
//        String content = (new ObjectMapper()).writeValueAsString(loginRequest);
//        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/auth/signin")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(content);
//        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(authController)
//                .build()
//                .perform(requestBuilder);
//        actualPerformResult.andExpect(MockMvcResultMatchers.status().isAccepted())
//                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
//                .andExpect(MockMvcResultMatchers.content().string("{\"jwt\":\"ABC123\",\"message\":\"Sign in success\"}"));
//    }
//
//    /**
//     * Method under test: {@link AuthController#loginUserHandler(LoginRequest)}
//     */
//    @Test
//    void testLoginUserHandler2() throws Exception {
//        when(jwtProvider.generateToken(Mockito.<Authentication>any())).thenReturn("ABC123");
//        when(customerUserServiceImplementation.loadUserByUsername(Mockito.<String>any()))
//                .thenReturn(new org.springframework.security.core.userdetails.User("janedoe", "iloveyou", new ArrayList<>()));
//        when(passwordEncoder.matches(Mockito.<CharSequence>any(), Mockito.<String>any())).thenReturn(true);
//
//        LoginRequest loginRequest = new LoginRequest();
//        loginRequest.setEmail("jane.doe@example.org");
//        loginRequest.setPassword("iloveyou");
//        String content = (new ObjectMapper()).writeValueAsString(loginRequest);
//        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/auth/signin")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(content);
//        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(authController)
//                .build()
//                .perform(requestBuilder);
//        actualPerformResult.andExpect(MockMvcResultMatchers.status().isAccepted())
//                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
//                .andExpect(MockMvcResultMatchers.content().string("{\"jwt\":\"ABC123\",\"message\":\"Sign in success\"}"));
//    }
//
//    /**
//     * Method under test: {@link AuthController#testEndpoint()}
//     */
//    @Test
//    void testTestEndpoint() throws Exception {
//        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/auth/test");
//        MockMvcBuilders.standaloneSetup(authController)
//                .build()
//                .perform(requestBuilder)
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
//                .andExpect(MockMvcResultMatchers.content().string("{\"message\":\"Test successful\"}"));
//    }
//
//    /**
//     * Method under test: {@link AuthController#testEndpoint()}
//     */
//    @Test
//    void testTestEndpoint2() throws Exception {
//        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/auth/test");
//        requestBuilder.contentType("https://example.org/example");
//        MockMvcBuilders.standaloneSetup(authController)
//                .build()
//                .perform(requestBuilder)
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
//                .andExpect(MockMvcResultMatchers.content().string("{\"message\":\"Test successful\"}"));
//    }
//}
//
