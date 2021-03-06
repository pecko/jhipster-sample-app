package com.mycompany.myapp.web.rest.dto;


import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserDTO {

    public static final int PASSWORD_MIN_LENGTH = 5;
    public static final int PASSWORD_MAX_LENGTH = 100;

    @Pattern(regexp = "^[a-z0-9]*$")
    @NotNull
    @Size(min = 1, max = 50)
    private String login;

    @NotNull
    @Size(min = PASSWORD_MIN_LENGTH, max = PASSWORD_MAX_LENGTH)
    private String password;

    @Size(max = 50)
    private String firstName;

    @Size(max = 50)
    private String lastName;

    @Email
    @Size(min = 5, max = 100)
    private String email;

    @Size(min = 2, max = 5)
    private String langKey;

    private List<String> roles;

    private Set<ExternalAccountDTO> externalAccounts = new HashSet<>();

    public UserDTO() {
    }

    public UserDTO(String login, String password, String firstName, String lastName, String email, String langKey,
                   List<String> roles, Set<ExternalAccountDTO> externalAccounts) {
        this.login = login;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.langKey = langKey;
        this.roles = roles;
        if (externalAccounts != null) {
        	this.externalAccounts.addAll(externalAccounts);
        }
    }

    public UserDTO(String login, String password, String firstName, String lastName, String email, String langKey,
                   List<String> roles) {
    	this(login, password, firstName, lastName, email, langKey, roles, null);
    }

    public UserDTO(String login, String firstName, String lastName, String email, ExternalAccountDTO externalAccount) {
        this.login = login;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        if (externalAccount != null) {
        	this.externalAccounts.add(externalAccount);
        }
    }

    public String getPassword() {
        return password;
    }

    public String getLogin() {
        return login;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getLangKey() {
        return langKey;
    }

    public List<String> getRoles() {
        return roles;
    }

    public Set<ExternalAccountDTO> getExternalAccounts() {
        return Collections.unmodifiableSet(externalAccounts);
    }

    @Override
    public String toString() {
        return "UserDTO{" +
        "login='" + login + '\'' +
        ", password='" + password + '\'' +
        ", firstName='" + firstName + '\'' +
        ", lastName='" + lastName + '\'' +
        ", email='" + email + '\'' +
        ", langKey='" + langKey + '\'' +
        ", roles=" + roles +
        ", externalAccounts=" + externalAccounts +
        '}';
    }
}