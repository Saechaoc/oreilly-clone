package com.chris.oreillyclone.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.catalina.connector.Response;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.security.authentication.BadCredentialsException;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class JwtValidatorTest {
    /**
     * Method under test: {@link JwtValidator#doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)}
     */
    @Test
    void testDoFilterInternal() throws ServletException, IOException {
        JwtValidator jwtValidator = new JwtValidator();
        MockHttpServletRequest request = new MockHttpServletRequest();
        Response response = new Response();
        FilterChain filterChain = mock(FilterChain.class);
        doNothing().when(filterChain).doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());
        jwtValidator.doFilterInternal(request, response, filterChain);
        verify(filterChain).doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());
    }

    /**
     * Method under test: {@link JwtValidator#doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testDoFilterInternal2() throws ServletException, IOException {

        JwtValidator jwtValidator = new JwtValidator();
        Response response = new Response();
        FilterChain filterChain = mock(FilterChain.class);
        doNothing().when(filterChain).doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());
        jwtValidator.doFilterInternal(null, response, filterChain);
    }

    /**
     * Method under test: {@link JwtValidator#doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)}
     */
    @Test
    void testDoFilterInternal3() throws ServletException, IOException {
        JwtValidator jwtValidator = new JwtValidator();
        MockHttpServletRequest request = new MockHttpServletRequest();
        Response response = new Response();
        FilterChain filterChain = mock(FilterChain.class);
        doThrow(new BadCredentialsException(JwtConstant.JWT_HEADER)).when(filterChain)
                .doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());
        assertThrows(BadCredentialsException.class, () -> jwtValidator.doFilterInternal(request, response, filterChain));
        verify(filterChain).doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());
    }

    /**
     * Method under test: {@link JwtValidator#doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)}
     */
    @Test
    void testDoFilterInternal4() throws ServletException, IOException {
        JwtValidator jwtValidator = new JwtValidator();

        MockHttpServletRequest request = new MockHttpServletRequest();
        request.addHeader(JwtConstant.JWT_HEADER, "Value");
        Response response = new Response();
        FilterChain filterChain = mock(FilterChain.class);
        doThrow(new BadCredentialsException(JwtConstant.JWT_HEADER)).when(filterChain)
                .doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());
        assertThrows(BadCredentialsException.class, () -> jwtValidator.doFilterInternal(request, response, filterChain));
        verify(filterChain).doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());
    }
}

