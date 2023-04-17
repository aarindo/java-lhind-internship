package com.lhind.util;

public final class Queries {

    public static String FIND_ALL_EMPLOYEES = "SELECT e FROM Employee e";
    public static String FIND_EMPLOYEE_BY_USERNAME = "SELECT e FROM Employee e WHERE e.username = ?1";
    public static String FIND_EMPLOYEE_BY_USERNAME_METHOD_2 = "SELECT e FROM Employee e WHERE e.username = :username";
    public static final String FIND_EMPLOYEE_BY_ROLE = "SELECT e FROM Employee e WHERE e.role = :role";


    public static final String FIND_ALL_EMPLOYEE_DETAILS = "SELECT e FROM EmployeeDetails e";
    public static final String FIND_EMPLOYEE_DETAILS_BY_EMAIL ="SELECT e FROM EmployeeDetails e WHERE e.email = :email";


    public static final String FIND_ALL_BOOKINGS = "SELECT e FROM Booking e";


    public static final String FIND_ALL_FLIGHTS = "SELECT e FROM Flight e";
    public static final String FIND_FLIGHT_BY_ORIGIN = "SELECT e FROM Flight e WHERE e.origin = :origin";
    public static final String FIND_FLIGHT_BY_DESTINATION = "SELECT e FROM Flight e WHERE e.destination = :destination";
    public static final String FIND_FLIGHT_BY_AIRLINE = "SELECT e FROM Flight e WHERE e.airline = :airline";
    public static final String FIND_FLIGHT_BY_FLIGHT_NUMBER = "SELECT e FROM Flight e WHERE e.flight_number = :flight_number";
    public static final String FIND_FLIGHT_BY_DEPARTURE_DATE = "SELECT e FROM Flight e WHERE e.departure_date = :departure_date";
    public static final String FIND_FLIGHT_BY_ARRIVAL_DATE = "SELECT e FROM Flight e WHERE e.arrival_date = :arrival_date";

    private Queries() {}

}
